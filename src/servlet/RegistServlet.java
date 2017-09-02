package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import service.UserService;
import service.UserServiceImpl;
import domain.User;
import exception.MsgException;
//注册
public class RegistServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			//0 解决乱码问题   数据库 utf-8  浏览器 GBK 
			//1.请求参数乱码
			req.setCharacterEncoding("UTF-8");
			//响应正文乱码
			resp.setContentType("text/html;charset=utf-8");
			//创建user的实例对象
			User user =new User();
			//
			try {
				//页面中参数我们封装到user对象中了，现在需要调用service层的方法进行处理了
				UserService userService=new UserServiceImpl() ;
				//密码加密
				BeanUtils.populate(user, req.getParameterMap());
				//MD5加密
				//后台数据校验
				//验证码的校验
				
				
				//service层去处理
				userService.regist(user);
				//给出注册成功的提示,跳转到首页
				resp.getWriter().write("恭喜注册成功, 3秒之后跳转到首页...如果没有跳转,可以点击下面的链接:" +
						"<br/><a href="+req.getContextPath()+"/index.jsp>http://www.easymall.com</a>");
				resp.setHeader("Refresh", "3;url="+req.getContextPath() +"/index.jsp");
			} catch (MsgException e) {
				req.setAttribute("msg", e.getMessage());
				//请求转发
				req.getRequestDispatcher("/regist.jsp").forward(req, resp);
				e.printStackTrace();
			}catch(Exception e1){
				e1.printStackTrace();
			}
			
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			super.doPost(req, resp);
	}
}