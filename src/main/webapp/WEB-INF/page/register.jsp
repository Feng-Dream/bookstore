<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="base/first.jsp"%>
</head>
<body>

	<%@ include file="base/head.jsp"%>

	<!--nav-->
	<div id="nav">
		<ul id="menu"></ul>
	</div>
	<!--end nav-->
	<!--end top-->

	<!--content-->
	<div class="logoin_wrap mt30">
		<h2>用户注册</h2>
		<div id="table">
			<f:form action="user/doRegister" method="post" modelAttribute="user">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td height="30px"></td>
					</tr>
				</table>
				<div align="center"><font style="color: red;"><f:errors path="message"></f:errors></font></div>
				<table width="100%" height="35" border="0" cellpadding="0"
					cellspacing="0">
					<tr>
						<td width="44%" align="right" valign="middle" class="f14">用户名：</td>
						<td width="56%" align="left" valign="middle"><input
							type="text" minlength="4" maxlength="10" name="username" value="${user.username }" id="username"
							class="input w180" required autofocus placeholder="请输入用户名"><font style="color: red;"><f:errors path="username"></f:errors></font></td>
					</tr>
				</table>
				<table width="100%" height="35" border="0" cellpadding="0"
					cellspacing="0">
					<tr>
						<td width="44%" align="right" valign="middle" class="f14">密&nbsp;码：</td>
						<td width="56%" align="left" valign="middle"><input
							type="password" minlength="6" maxlength="16" name="password" value="" id="password"
							class="input w180" required placeholder="请输入密码"><font style="color: red;"><f:errors path="password"></f:errors></font></td>
					</tr>
				</table>

				<table width="100%" height="35" border="0" cellpadding="0"
					cellspacing="0">
					<tr>
						<td width="44%" align="right" valign="middle" class="f14"></td>
						<td width="56%" align="left" valign="middle">
							<!-- 图片按钮，与type=submit按钮的效果是一样，也可以用来提交表单 --> <input type="image"
							src="resources/images/admin_zc.png" />
						</td>
					</tr>
				</table>

				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td>&nbsp;</td>
					</tr>
				</table>
			</f:form>
		</div>
	</div>
	<!--end content-->

	<%@ include file="base/foot.jsp"%>
</body>
</html>
