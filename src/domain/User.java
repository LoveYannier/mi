package domain;

import exception.MsgException;

public class User{
	private int id;
	private String username;
	private String password;
	private String password2;
	private String nickname;
	private String email;
	private String valistr;
	public void check() throws MsgException{
		//>>�ǿ�У��
		if(username == null || "".equals(username)){
			throw new MsgException("�û�������Ϊ��");
		}
		if(password == null || "".equals(password)){
			throw new MsgException("���벻��Ϊ��");
		}
		if(password2 == null || "".equals(password2)){
			throw new MsgException("ȷ�����벻��Ϊ��");
		}
		//>>���������Ƿ�һ��
		if(!password.equals(password2)){
			throw new MsgException("�������벻һ��");
		}
		
		if(nickname == null || "".equals(nickname)){
			throw new MsgException("�ǳƲ���Ϊ��");
		}
		if(email == null || "".equals(email)){
			throw new MsgException("���䲻��Ϊ��");
		}
		//>>�����ʽ�Ƿ���ȷ
		if(!email.matches("^\\w+@\\w+(\\.\\w+)+$")){
			throw new MsgException("�����ʽ����ȷ");
		}
		
		if(valistr == null || "".equals(valistr)){
			throw new MsgException("��֤�벻��Ϊ��");
		}
    }
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getValistr() {
		return valistr;
	}
	public void setValistr(String valistr) {
		this.valistr = valistr;
	}
	
}
