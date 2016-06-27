<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8" session="false" %> 
<html lang="zh-cn">
<head>
	<meta charset="utf-8"/>
	<title>bootstrap扁平化风格布局-------->登录</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<meta name="description" content="overview &amp; stats">
	<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
	<link href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css" rel="stylesheet" /> 
	<link href="<%=request.getContextPath()%>/bootstrap/css/font-awesome.min.css" rel="stylesheet" />
	<link href="<%=request.getContextPath()%>/bootstrap/css/cyrillic.css" rel="stylesheet" /> 
	<link href="<%=request.getContextPath()%>/bootstrap/css/ace.min.css" rel="stylesheet" />
	<link href="<%=request.getContextPath()%>/bootstrap/css/ace-rtl.min.css" rel="stylesheet"  /> 
	<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap/css/ace-skins.min.css" />
	 <!--[if lte IE 9]>
			<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap/css/ace-part2.min.css" />
	<![endif]-->
 	<!--[if lte IE 9]>
		  <link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap/css/ace-ie.min.css" />
	<![endif]-->
	<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap/css/ace.onpage-help.css" />
	
	
 	<!--js 引入-->
 	<script src="<%=request.getContextPath()%>/bootstrap/js/jquery.min.js"></script> 
 	<script src="<%=request.getContextPath()%>/bootstrap/js/bootstrap.min.js"></script> 
	<script src="<%=request.getContextPath()%>/bootstrap/js/ace-extra.min.js"></script>  
 	<script src="<%=request.getContextPath()%>/bootstrap/js/typeahead-bs2.min.js"></script>
 	<script src="<%=request.getContextPath()%>/bootstrap/js/ace-elements.min.js"></script>
	<!--[if lt IE 9]>
	<script src="<%=request.getContextPath() %>/bootstrap/js/html5shiv.js"></script>
	<script src="<%=request.getContextPath() %>/bootstrap/js/respond.min.js"></script> 
	<![endif]-->
	<script src="<%=request.getContextPath() %>/bootstrap/otherjs/html5Ie.js"></script> 
	<!--[if lte IE 8]>
	  <script src="<%=request.getContextPath() %>/bootstrap/js/excanvas.min.js"></script>
	<![endif]-->  
	<script src="http://ditu.google.com/maps?file=api&hl=zh-CN&v=2&key=AIzaSyCHV8c9Xzm0wrlPOSrLlIdY29TiIAyzUtg" type="text/javascript"></script>
	<script type="text/javascript">
	//732140506889656  facebook key 
	//42ab09ff57b11e6e28a5595be670e167 百度地图key
	//AIzaSyCHV8c9Xzm0wrlPOSrLlIdY29TiIAyzUtg  谷歌地图key
</script>
</head>   
	<body class="login-layout"> 
		<div class="main-container">
			<div class="main-content">
				<div class="row">
					<div class="col-sm-10 col-sm-offset-1">
						<div class="login-container">
							<div class="center">
								<h1>
									<i class="icon-leaf green"></i>
									<span class="red">建筑项目</span>
									<span class="white" id="id-text2">个人网站</span>
								</h1>
								<h4 class="blue" id="id-company-text">&copy; jhone温顺全</h4>
							</div>

							<div class="space-6"></div>

							<div class="position-relative">
								<div id="login-box" class="login-box visible widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header blue lighter bigger">
												<i class="icon-coffee green"></i>
												请输入你的登录信息
											</h4> 
											<div class="space-6"></div> 
											<form action="checklogin" id="myform" method="post">
												<fieldset>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="text" class="form-control" placeholder="登录名" />
															<i class="icon-user"></i>
														</span>
													</label> 
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" class="form-control" placeholder="密码" />
															<i class="icon-lock"></i>
														</span>
													</label>

													<div class="space"></div>

													<div class="clearfix">
														<label class="inline">
															<input type="checkbox" class="ace" />
															<span class="lbl">记住我</span>
														</label>

														<button class="width-35 pull-right btn btn-sm btn-primary" type="submit">
															<i class="icon-key"></i>
															<span class="bigger-110">登录</span>
														</button>
													</div> 
													<div class="space-4"></div>
												</fieldset>
											</form>

											<div class="social-or-login center">
												<span class="bigger-110">用其它方式登录</span>
											</div>

											<div class="space-6"></div>

											<div  class="social-login center">
												<a class="btn btn-primary">  
												<i class="icon-facebook" id="status" data-share="true" data-width="450" data-show-faces="true"></i>
												 </a>

												<a class="btn btn-info">
													<i class="icon-twitter"></i>
												</a>

												<a class="btn btn-danger">
													<i class="icon-google-plus"></i>
												</a>
											</div>
										</div><!-- /.widget-main -->

										<div class="toolbar clearfix">
											<div>
												<a href="#" data-target="#forgot-box" class="forgot-password-link">
													<i class="ace-icon fa fa-arrow-left"></i>
													我忘记了我的密码?
												</a>
											</div>

											<div>
												<a href="#" data-target="#signup-box" class="user-signup-link">
													我想要注册
													<i class="icon-arrow-right"></i>
												</a>
											</div>
										</div>
									</div><!-- /.widget-body -->
								</div><!-- /.login-box --> 
								<div id="forgot-box" class="forgot-box widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header red lighter bigger">
												<i class="icon-key"></i>
												请输入验证邮箱
											</h4>

											<div class="space-6"></div>
											<p>
												输入您的邮箱地址以方便发送重置密码命令
											</p>

											<form>
												<fieldset>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="email" class="form-control" placeholder="邮箱地址" />
															<i class="icon-envelope"></i>
														</span>
													</label>

													<div class="clearfix">
														<button type="button" class="width-35 pull-right btn btn-sm btn-danger">
															<i class="icon-lightbulb-o"></i>
															<span class="bigger-110">发送给我!</span>
														</button>
													</div>
												</fieldset>
											</form>
										</div><!-- /.widget-main -->

										<div class="toolbar center">
											<a href="#" data-target="#login-box" class="back-to-login-link">
												返回到登录
												<i class="icon-arrow-right"></i>
											</a>
										</div>
									</div><!-- /.widget-body -->
								</div><!-- /.forgot-box -->

								<div id="signup-box" class="signup-box widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header green lighter bigger">
												<i class="icon-users blue"></i>
												新用户注册
											</h4>

											<div class="space-6"></div>
											<p> 请输入您的详细信息: </p> 
											<form>
												<fieldset>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="email" class="form-control" placeholder="邮箱地址" />
															<i class="icon-envelope"></i>
														</span>
													</label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="text" class="form-control" placeholder="用户名" />
															<i class="icon-user"></i>
														</span>
													</label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" class="form-control" placeholder="密码" />
															<i class="icon-lock"></i>
														</span>
													</label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" class="form-control" placeholder="确认密码" />
															<i class="icon-retweet"></i>
														</span>
													</label>

													<label class="block">
														<input type="checkbox" class="ace" />
														<span class="lbl">
															我同意 
															<a href="#">用户协议</a>
														</span>
													</label> 
													<div class="space-24"></div> 
													<div class="clearfix">
														<button type="reset" class="width-30 pull-left btn btn-sm">
															<i class="icon-refresh"></i>
															<span class="bigger-110">重置</span>
														</button>

														<button type="button" class="width-65 pull-right btn btn-sm btn-success">
															<span class="bigger-110">注册</span>

															<i class="icon-arrow-right icon-on-right"></i>
														</button>
													</div>
												</fieldset>
											</form>
										</div>

										<div class="toolbar center">
											<a href="#" data-target="#login-box" class="back-to-login-link">
												<i class="icon-arrow-left"></i>
												返回到登录
											</a>
										</div>
									</div><!-- /.widget-body -->
								</div><!-- /.signup-box -->
							</div><!-- /.position-relative --> 
						 
						</div>
					</div><!-- /.col -->
				</div><!-- /.row -->
			</div><!-- /.main-content -->
		</div><!-- /.main-container -->


<!--[if !IE]> -->
		<script type="text/javascript">
			window.jQuery || document.write("<script src='<%=request.getContextPath() %>/bootstrap/js/jquery.min.js'>"+"<"+"/script>");
		</script>

		<!-- <![endif]--> 
		
			<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='<%=request.getContextPath() %>/bootstrap/js/jquery1x.min.js'>"+"<"+"/script>");
</script>
<![endif]-->	
<script type="text/javascript">
			if('ontouchstart' in document.documentElement) document.write("<script src='<%=request.getContextPath() %>/bootstrap/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>

		<!-- inline scripts related to this page -->
		<script type="text/javascript">
			jQuery(function($) {
			 $(document).on('click', '.toolbar a[data-target]', function(e) {
				e.preventDefault();
				var target = $(this).data('target');
				$('.widget-box.visible').removeClass('visible');//hide others
				$(target).addClass('visible');//show target
			 });
			});  
		</script> 	
</body>
</html>