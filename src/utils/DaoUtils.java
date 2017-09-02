package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.ResultSetHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;


//对数据库进行CRUD操作的工具包
public class DaoUtils {
	public static Connection conn=null;
	public static PreparedStatement pstat=null;
	public static ResultSet rs=null;
	
	private static ComboPooledDataSource source=new ComboPooledDataSource();
	
	//写一个静态方法，返回c3p0中当前使用的链接，
	public static Connection getConn()  throws SQLException{
		return source.getConnection();
	}
	
	/**
	 * 实现查询
	 * @param sql：sql语句
	 * @param rsh：ResultSetHandler实现类的对象：通常使用BeanHandler和BeanListHandler
	 * @param params:查询条件用到的值（不定个数的参数写法）
	 * @return 
	 * @throws SQLException
	 */
	public static <T> T query(String sql, ResultSetHandler<T> rsh, 
			Object... params){
		Connection conn = null;
		PreparedStatement pstat = null;
		ResultSet rs = null;
		try{
			conn = TransactionManager.getConn();
			pstat = conn.prepareStatement(sql);
			//为占位符赋值
			for(int i=1;i<=params.length;i++){
				pstat.setObject(i, params[i-1]);
			}
			//执行查询
			rs = pstat.executeQuery();
			return rsh.handle(rs);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(rs, pstat, null);//切记conn不能在此关闭
		}
		return null;
	}
	/**
	 * 实现注册
	 */
	
	public static int update(String sql,Object ...params){
		conn=TransactionManager.getConn();
		try {
			pstat=conn.prepareStatement(sql);
			//为占位符赋值
			for (int i = 1; i <=params.length; i++) {
				pstat.setObject(i, params[i-1]);
			}
			
		//执行查询
			return pstat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//数据库连接不可关闭
			close(null, pstat, null);
		}
		
		
		return 0;
	}
	
	public static void close(ResultSet rs,PreparedStatement pstat ,Connection conn){
		if (rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				rs=null;
			}
		}
		
		if (pstat!=null) {
			try {
				pstat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				pstat=null;
			}
		}
		if (conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				conn=null;
			}
		}
	}
}
