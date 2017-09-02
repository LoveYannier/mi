<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" buffer="0kb" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta charset="utf-8" />
	<title>小米Max2-小米商城</title>
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/img/index/title.ico"/>
	<link rel="stylesheet" type="text/css" href="css/index.css">
	<script type="text/javascript" src="js/xiaomi_.js"></script>
</head>
<body>
	<div id="XiaoMi">
    	<!--小米首頁导航栏顶部-->
		<div id="xiaomi_top">
			<div id ="daohang_top">
				<a href="#">小米商城</a>|
				<a href="#">MIUI</a>|
				<a href="#">米聊</a> |
				<a href="#">游戏</a>|
				<a href="#">金融</a>|
				<a href="#">小米商城移动版</a>|
				<a href="#">问题反馈</a>|
				<a href="#">Select Region</a>|
				<c:if test="${sessionScope.user==null}" var="isLogin" scope="page">
					<a href="login.jsp"  id="login">登录</a>|
					<a href="regist.jsp"id="regist">注册</a>|
				</c:if>	
				<c:if test="${!isLogin}">
					<a class="login1">欢迎回来, ${sessionScope.user.username}</a>
					<a href="#" >后台管理</a>
					<a href="LogoutServlet" >注销</a>
				</c:if>	
				<a href="#">消息通知</a>|

				<div id="cart">
					<div id="cart_image">

					</div>
					购物车(0)
					<!--<div id="cart_down">
						购物车还没有商品，赶紧选购吧
					</div>-->
				</div>
			</div>
            <!--导航栏-->
            <div id="daohang">
            	<!--小米标志-->
            	<img id="mi_icon" src="img/index/xiaomibiaozhi.png"/>
                	<!--小米文字导航-->
                <div id="mi_navigation">
                	<a href="#" id="mi_roll">小米手机</a>
                    <a href="#">红米</a>
					<a href="#">平板·笔记本</a>
					<a href="#">电视</a>
					<a href="#">盒子·影音</a>
					<a href="#">路由器</a>
					<a href="#">智能硬件</a>
					<a href="#">服务</a>
                    <!--搜索栏-->
                 	<input type="text" id="mi_sousuo_space" />
                 	<span id="seach_icon"></span>
                 </div>
            </div>
            <!--左侧三级菜单-->
            <div id="mi_line1">
            	<ul id="mi_list">
                		<li>
							<font>手机 电话卡</font>
						</li>
						<li>
							<font>笔记本平板</font>
						</li>
						<li>
							<font>电视 盒子</font>
						</li>
						<li>
							<font>路由器 智能硬件</font>
						</li>
						<li>
							<font>移动电源 电池 插线板</font>
						</li>
						<li>
							<font>耳机 音响</font>
						</li>
						<li>
							<font>保护套 贴膜</font>
						</li>
						<li>
							<font>线材 支架 储存卡</font>
						</li>
						<li>
							<font>箱包 服饰</font>
						</li>
						<li>
							<font>米兔 生活周边</font>
						</li>
            	</ul>
                <!--banner图-->
                <div id="xiaomi_lunbo">
						<a href="#" ><img src="img/index/lunbo_1.jpg" /></a>
				</div>
            </div>
             <!--三图-->
            <div id="mi_third_images">
				<div id="mi_first_image">
					<ul>
                        <li>选购手机</li>
                        <li>企业团购</li>
                        <li>一元活动</li>
                        <li>小米移动</li>
                        <li>以旧换新</li>
                        <li>话费充值</li>
                    </ul>
                </div>
                <div id="mi_second_image">
                	<img src="img/index/dier.jpg" />
                </div>
                <div id="mi_third_image">
                	<img src="img/index/disan.jpg" />
                </div>
            </div>
            
            <div id="zhinengyingjian">
            <div id="zhinengyingjian_top">
				<h2>智能硬件</h2>
				<h3>查看全部</h3>
			</div>
            <div id="zhinengyingjian_content">
						<div id="zhinengyingjian_content_left"></div>
						<div id="zhinengyingjian_content_right">
							<ul>
								<li>
									<div class="dapei_tupian">
										<img class="danpin_tupian" src="img/index/mijia1.jpg" />
									</div>
									<div class="danpin_wenzi">
										<p class="wenzi_1">米家行车记录仪</p>
										<p class="wenzi_2">晚上能拍清车牌的行车记录仪</p>
										<p class="wenzi_3">349元</p>
									</div>
								</li>
								<li>
									<div class="dapei_tupian">

										<img class="danpin_tupian" src="img/index/mijia2.jpg" />

									</div>

									<div class="danpin_wenzi">
										<p class="wenzi_1">小米空气净化器2</p>
										<p class="wenzi_2">高效除霾，10分钟换新房间空气</p>
										<p class="wenzi_3">699元</p>
									</div>
								</li>
								<li>
									<div class="dapei_tupian">

										<img class="danpin_tupian" src="img/index/mijia3.jpg" />

									</div>

									<div class="danpin_wenzi">
										<p class="wenzi_1">米兔智能故事机</p>
										<p class="wenzi_2">微信远程互动，智能语音交互</p>
										<p class="wenzi_3">199元</p>
									</div>

								</li>
								<li>
									<div class="dapei_tupian">

										<img class="danpin_tupian" src="img/index/mijia4.jpg" />

									</div>

									<div class="danpin_wenzi">
										<p class="wenzi_1">米兔儿童手表Q</p>
										<p class="wenzi_2">11重安全设计，五重精准定位</p>
										<p class="wenzi_3">299元</p>

									</div>

								</li>
								<li>
									<div class="dapei_tupian">

										<img class="danpin_tupian" src="img/index/mijia5.jpg" />

									</div>

									<div class="danpin_wenzi">
										<p class="wenzi_1">米家小白智能摄像机</p>
										<p class="wenzi_2">360° 全景拍摄，1080P 高清摄像</p>
										<p class="wenzi_3">399元</p>

									</div>

								</li>
								<li>
									<div class="dapei_tupian">

										<img class="danpin_tupian" src="img/index/mijia6.jpg" />

									</div>

									<div class="danpin_wenzi">
										<p class="wenzi_1">米家车载空气净化器</p>
										<p class="wenzi_2">双风机循环气流，高效净化车内空气</p>
										<p class="wenzi_3">449元</p>

									</div>

								</li>
								<li>

									<div class="dapei_tupian">

										<img class="danpin_tupian" src="img/index/mijia7.jpg" />

									</div>

									<div class="danpin_wenzi">
										<p class="wenzi_1">米家骑记电助力折叠自行车</p>
										<p class="wenzi_2">力矩传感电助力，让城市出行轻松有趣</p>
										<p class="wenzi_3">2999元</p>

									</div>

								</li>
								<li>
									<div class="dapei_tupian">

										<img class="danpin_tupian" src="img/index/mijia8.jpg" />

									</div>

									<div class="danpin_wenzi">
										<p class="wenzi_1">小米米家电动滑板车</p>
										<p class="wenzi_2">极简几何设计，1 分钟轻松上手</p>
										<p class="wenzi_3">1999元</p>

									</div>

								</li>
							</ul>

						</div>

					</div>

				</div>
            	 <div id="dibu">
					
					<div id="dibu_top">
						
						<ul>
							<li class="biaoqianbiankuang diyi_biaoqian">预约维修服务</li>
							<li class="biaoqianbiankuang">7天无理由退货</li>
							<li class="biaoqianbiankuang">15天免费换货</li>
							<li class="biaoqianbiankuang">满150元包邮</li>
							<li>520余家售后网点</li>
						</ul>
						
					</div>
					
					<!--底部内容-->
					<div id="dibu_content">
						
						<div id="dibufengexian">
							
							<img src="img/index/dibufengexian.png"/>
							
						</div>
						
						
						<div id="dibu_neirong">
							
							<ul>
								<li>
									
									<p class="dibu_toubu_ziti">帮助中心</p>
									<p class="dibu_sanhang_ziti">账户管理</p>
									<p class="dibu_sanhang_ziti">购物指南</p>
									<p class="dibu_sanhang_ziti">订单操作</p>
									
								</li>
								<li class="fenli">
										<p class="dibu_toubu_ziti">服务支持</p>
									<p class="dibu_sanhang_ziti">售后政策</p>
									<p class="dibu_sanhang_ziti">自助服务</p>
									<p class="dibu_sanhang_ziti">相关下载</p>
									
								</li>
								<li class="fenli">
										<p class="dibu_toubu_ziti">线下门店</p>
									<p class="dibu_sanhang_ziti">小米之家</p>
									<p class="dibu_sanhang_ziti">服务网点</p>
									<p class="dibu_sanhang_ziti">零售网点</p>
									
								</li>
								<li class="fenli">
										<p class="dibu_toubu_ziti">关于小米</p>
									<p class="dibu_sanhang_ziti">了解小米</p>
									<p class="dibu_sanhang_ziti">加入小米</p>
									<p class="dibu_sanhang_ziti">联系我们</p>
									
								</li>
								<li class="fenli">
										<p class="dibu_toubu_ziti">关注我们</p>
									<p class="dibu_sanhang_ziti">新浪微博</p>
									<p class="dibu_sanhang_ziti">小米部落</p>
									<p class="dibu_sanhang_ziti">官方微信</p>
									
								</li>
								<li class="fenli">
										<p class="dibu_toubu_ziti">特色服务</p>
									<p class="dibu_sanhang_ziti">F 码通道</p>
									<p class="dibu_sanhang_ziti">礼物码</p>
									<p class="dibu_sanhang_ziti">防伪查询</p>
									
								</li>
							</ul>
							
							
							<div id="shufengexian">
								
							</div>
							
							<div id="dianhua">
								
								<p class="dianhua_">400-100-5678</p>
								<p class="dier_ziti">周一至周日 8:00-18:00 </p>
								<p class="dier_ziti">（仅收市话费）</p>
								
								
							</div>
							
							
							
							
						</div>
						
						
						<div id="dibu_dibu_dibu">
							
							
							
							<div id="xiaomibiaozhi_">
								
							</div>
							
							<div id="xiaomi_dibu_ziti">
								
								<p>小米商城|MIUI|米聊|多看书城|小米路由器|视频电话|企业团购|小米天猫店|小米淘宝直营店|小米网盟|小米移动|Select Region</p>
								<p>©mi.com 京ICP证110507号 京ICP备10046444号 京公网安备11010802020134号 京网文[2014]0059-0009号</p>
								<p>违法和不良信息举报电话：185-0130-1238，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</p>
<!--								
								
								
小米商城|MIUI|米聊|多看书城|小米路由器|视频电话|企业团购|小米天猫店|小米淘宝直营店|小米网盟|小米移动|Select Region
©mi.com 京ICP证110507号 京ICP备10046444号 京公网安备11010802020134号 京网文[2014]0059-0009号 
违法和不良信息举报电话：185-0130-1238，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试-->
								
							</div>
							
							
							<div id="youbiantubiao">
								
							</div>
							
							<div id="xiaomikeji">
								
							</div>
							
							
							
						</div>
						
						
						
						
					</div>
					
					<div id="dibu_dibu">
						
					</div>
					
					
				</div>
            
   
           
            
            
            
		</div>
    </div>
</body>
</html>
