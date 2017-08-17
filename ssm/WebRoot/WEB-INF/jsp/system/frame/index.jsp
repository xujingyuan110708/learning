<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/include/easyui_core.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>管理系统</title>
<script type="text/javascript">
	function treeClick(node) {
				if (node.attributes.url) {
					var src = path + node.attributes.url;
					var tabs = $('#mainTabs');
					var opts = {
						title : node.text,
						closable : true,
						content : '<iframe src="'+src+'" allowTransparency="true" style="border:0;width:99%;height:99%;padding-left:2px;" frameBorder="0"></iframe>',
						border : false,
						fit : true
					};
					if (tabs.tabs('exists', opts.title)) {
						tabs.tabs('select', opts.title);
					} else {
						tabs.tabs('add', opts);
					}
				}
			}
	
</script>

</head>
    <body class="easyui-layout">  
        <!-- 正上方panel -->  
        <div data-options="region:'north',border:false" style="height:60px;padding:0px">
	        <div id="sessionInfoDiv" style="position: absolute;right: 5px;top:10px;">
	            <strong>${sessionScope.sysUser.name}</strong>&nbsp;欢迎你！
	            <SPAN id=clock style="color: blue;"></SPAN>
				<SCRIPT type=text/javascript> 
				    var clock = new Clock();
				    clock.display(document.getElementById("clock"));
				</SCRIPT>
	        </div>
        </div>  
		<!-- 左侧菜单 -->
      	<div data-options="region:'west',split:true" title="功能菜单" style="width:200px;">
			<div class="easyui-accordion" data-options="fit:true,border:false">
				<c:if test="${!empty menuList }">
				  <c:forEach items="${menuList }" var="item" varStatus="x">
				       <div title="${item.menuName }" style="padding:10px;"  <c:if test="${x.first}">data-options="selected:true"</c:if>>
					   <ul  class="easyui-tree" data-options="url:'${path }/manage/frame/getChildrenMenus.do?pid=${item.id }',method:'post',animate:true,lines:true,onClick:treeClick"></ul>
					   </div>
				  </c:forEach>
				</c:if>
			</div>
		</div>
        <!-- 正中间panel -->  
        <!-- <div region="center" title="功能区" >   -->
        <div region="center">  
            <div class="easyui-tabs" id="mainTabs" fit="true" border="false">  
                <div title="欢迎使用" style="padding:20px;">   
                    <div style="margin-top:20px; float:left;min-width:600px;widht: 600px; height: 90%; ">  
                        <h1 style="font-size:24px;">欢迎使用项目管理系统</h1>
                    </div>  
                </div>  
            </div>  
        </div>  
        <!-- 正下方panel -->  
        <div region="south" style="height:24px;line-height:22px;" align="center">  
            <label style="font-size:11px;">XXXXXX</label>  
        </div>   
    </body>
</html>
