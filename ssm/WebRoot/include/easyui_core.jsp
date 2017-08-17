<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="${pageContext.request.contextPath}" var="path" scope="page"/>
<%@page import="com.ms.www.model.TSysUser"%>

<%
	TSysUser user = (TSysUser)request.getSession().getAttribute("sysUser");
%>

<script type="text/javascript">
    var path = "${path}";
</script>
	<link rel="stylesheet" type="text/css" href="${path}/js/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${path}/js/easyui/themes/icon.css">
	<script type="text/javascript" src="${path}/js/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="${path}/js/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${path}/js/easyui/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${path}/js/Clock.js"></script>
    <script type="text/javascript" src="${path}/js/lhgdialog4.2.0/lhgcore.lhgdialog.min.js"></script>
