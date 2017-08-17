<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>用户管理</title>
<%@include file="/include/easyui_core.jsp"%>

</head>
<body class="easyui-layout" fit="true">
	<div region="center" border="false" style="overflow: hidden;">
		<!-- 添加/修改对话框 -->
		<div  class="easyui-dialog"
			style="width:400px;height:400px;padding:30px 20px" buttons="#dlg-buttons">
			<form id="fm" method="post" novalidate>
				<div class="fitem">
					<label>用户名:</label> <input name="username" class="easyui-textbox" required="true">
				</div>
				<div class="fitem">
					<label>密码:</label> <input name="password" class="easyui-textbox" required="true">
				</div>
				<div class="fitem">
					<label>身份证:</label> <input name="idcard" class="easyui-textbox" required="true">
				</div>
				<div class="fitem">
					<label>性别:</label> 
					<input type="radio" name="gender" id="gender" value="男" style="width:50px;">男</input>
					<input type="radio" name="gender" id="gender" value="女" style="width:50px;">女</input>
				</div>
				<div class="fitem">
					<label>入职时间:</label> <input name="regtime" type="text" class="easyui-datebox" required="required"/>
				</div>
				<div class="fitem">
					<label>Email:</label> <input name="email" class="easyui-textbox" validType="email">
				</div>
				<div class="fitem">
					<label>QQ:</label> <input name="qq" class="easyui-textbox" >
				</div>
				<div class="fitem">
					<label>微信:</label> <input name="weixin" class="easyui-textbox" >
				</div>
			</form>
		</div>
		
		<!-- 添加/修改对话框按钮 -->
		<div id="dlg-buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton c6"
				iconCls="icon-ok" onclick="saveUser()" style="width:90px">保存</a> 
				<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')"
				style="width:90px">取消</a>
		</div>
	</div>
</body>
</html>
