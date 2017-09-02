package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.ResultSetHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;


//�����ݿ����CRUD�����Ĺ��߰�
public class DaoUtils {
	public static Connection conn=null;
	public static PreparedStatement pstat=null;
	public static ResultSet rs=null;
	
	private static ComboPooledDataSource source=new ComboPooledDataSource();
	
	//дһ����̬����������c3p0�е�ǰʹ�õ����ӣ�
	public static Connection getConn()  throws SQLException{
		return source.getConnection();
	}
	
	/**
	 * ʵ�ֲ�ѯ
	 * @param sql��sql���
	 * @param rsh��ResultSetHandlerʵ����Ķ���ͨ��ʹ��BeanHandler��BeanListHandler
	 * @param params:��ѯ�����õ���ֵ�����������Ĳ���д����
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
			//Ϊռλ����ֵ
			for(int i=1;i<=params.length;i++){
				pstat.setObject(i, params[i-1]);
			}
			//ִ�в�ѯ
			rs = pstat.executeQuery();
			return rsh.handle(rs);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(rs, pstat, null);//�м�conn�����ڴ˹ر�
		}
		return null;
	}
	/**
	 * ʵ��ע��
	 */
	
	public static int update(String sql,Object ...params){
		conn=TransactionManager.getConn();
		try {
			pstat=conn.prepareStatement(sql);
			//Ϊռλ����ֵ
			for (int i = 1; i <=params.length; i++) {
				pstat.setObject(i, params[i-1]);
			}
			
		//ִ�в�ѯ
			return pstat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//���ݿ����Ӳ��ɹر�
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
