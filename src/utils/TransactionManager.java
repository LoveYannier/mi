package utils;

import java.sql.Connection;
import java.sql.SQLException;

//����
public class TransactionManager {
	/**
	 * ���ݿ���������
	 * ������ָ�߼��ϵ�һ�������Ҫô�ɹ�Ҫô���ɹ�
	 * -- ��������,���������֮������е�sql������ͬһ������,Ҫôͬʱ���Ҫôͬʱ�����
			......
		--�����е�sql��ִ��ʱ,��û�������޸����ݿ��е�����
			commit; 
		-- �ύ����,��������������ݿ��Ӱ��һ����
			rollback; 
		-- �ع�����,�������������ݿ��Ӱ��ȡ����
		
		������Ĵ����ԣ�	ԭ���ԣ����񲻿ɷָ��һ��������λ
						һ���ԣ�����ǰ�������Ա���һ��
						�־��ԣ�һ������һ���ύ�������ݿ�Ĳ��������õ�
						�����ԣ�������û��������ݿ�ʱ��һ���û��������ܱ�����������
								������
	 */
	public static ThreadLocal<Connection> tl=new ThreadLocal<Connection>(){
		//						��ʼֵ
		protected Connection initialValue() {
			try {
				//�õ���ǰc3p0�����ӣ���
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
		//�󶨺÷���
		return tl.get();
	}
	//��������
	public static void startTran(){
		try {
			tl.get().setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//�ύ����
	public static void commitTran(){
		try {
			tl.get().commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//�ع�����
	public static void rollbackTran(){
		try {
			tl.get().rollback();
			tl.remove();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//�ر����ݿ�����
	public static void release(){
		try {
			tl.get().close();
			tl.remove();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
