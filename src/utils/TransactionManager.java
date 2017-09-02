package utils;

import java.sql.Connection;
import java.sql.SQLException;

//事务
public class TransactionManager {
	/**
	 * 数据库事务的添加
	 * 事务是指逻辑上的一组操作，要么成功要么不成功
	 * -- 开启事务,在这条语句之后的所有的sql将处在同一事务中,要么同时完成要么同时不完成
			......
		--事务中的sql在执行时,并没有真正修改数据库中的数据
			commit; 
		-- 提交事务,将整个事务对数据库的影响一起发生
			rollback; 
		-- 回滚事务,将这个事务对数据库的影响取消掉
		
		事务的四大特性：	原子性，事务不可分割的一个工作单位
						一致性，事务前后完整性必须一致
						持久性，一个事务一旦提交，对数据库的操作是永久的
						隔离性，当多个用户访问数据库时，一个用户的事务不能被其他的事务
								所干扰
	 */
	public static ThreadLocal<Connection> tl=new ThreadLocal<Connection>(){
		//						初始值
		protected Connection initialValue() {
			try {
				//拿到当前c3p0的链接，绑定
				return DaoUtils.getConn();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
			
		};
	};
	//
	public static Connection getConn(){
		//绑定好返回
		return tl.get();
	}
	//开启事务
	public static void startTran(){
		try {
			tl.get().setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//提交事务
	public static void commitTran(){
		try {
			tl.get().commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//回滚事务
	public static void rollbackTran(){
		try {
			tl.get().rollback();
			tl.remove();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//关闭数据库连接
	public static void release(){
		try {
			tl.get().close();
			tl.remove();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
