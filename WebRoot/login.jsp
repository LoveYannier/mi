<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="java.net.URLDecoder"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
	<head>
		<meta http-equiv="Content-type" content="text/html; charset=UTF-8" />
		<link rel="shortcut icon" href="${pageContext.request.contextPath}/img/login/title.ico"/>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/login.css"/>
		<title>小米帐号-登录</title>
	</head>
	<body>
		<div id="login_top">
		<img id="mi_icon" src="img/regist/xiaomibiaozhi.png"/>
		<p>小米帐号-登录</p>
		<form action="${pageContext.request.contextPath }/LoginServlet" method="POST">
			<table>
				<tr>
					<td class="tdx" colspan="2" style="color:red; text-align:center" >
						${requestScope.msg}
					</td>
				</tr>
				<tr>
					<td class="tdx">账户：</td>
					<td><input type="text" name="username" value=""/></td>
				</tr>
				<tr>
					<td class="tdx">密码：</td>
					<td><input type="password" name="password" value=""/></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="checkbox" name="remname" value="true" 
						<c:if test="${cookie.username!=null}">checked="checked"</c:if>
						/>记住用户名 &emsp;&emsp;&emsp;
						<input type="checkbox" name="autologin" value="true"/>30天内自动登陆
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="立即登陆"/>
					</td>
				</tr>
			</table>
			<div id="mi_foot">
				<p>简体| 繁体| English| 常见问题</p>
				<p>小米公司版权所有-京ICP备10046444-京公网安备11010802020134号-京ICP证110507号</p>
			</div>
		</form>	
		</div>	
		
	</body>
</html>
