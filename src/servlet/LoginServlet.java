package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;
import service.UserServiceImpl;
import domain.User;
import exception.MsgException;

public class LoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//1.解决乱码
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//2.获取请求参数
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String remname = req.getParameter("remname");
		
	
		try{
			UserService service =new UserServiceImpl();
			User user = service.login(username,password);
			//如果不存在
			if(user==null){
				throw new MsgException("用户名或密码错误！");
			}
			//存在，登录：将该用户的信息保存到session
			req.getSession().setAttribute("user", user);
		
			
			//提示登录成功，回到主页面
			resp.getWriter().write("恭喜登录成功, 3秒之后跳转到首页...如果没有跳转, " +
					"可以点击下面的链接:<br/><a href="+req.getContextPath()+"'/index.jsp'>http://www.easymall.com</a>");
			resp.setHeader("Refresh", "3;url="+ req.getContextPath() +"/index.jsp");
		}catch (MsgException me) {
			req.setAttribute("msg", me.getMessage());
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			doPost(req, resp);
	}
}
