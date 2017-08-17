<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>功能管理</title>
<%@include file="/include/easyui_core.jsp"%>

<script type="text/javascript">
	$(function(){
	    InitGrid();	
	});
        //实现对DataGird控件的绑定操作
        function InitGrid() {
            $('#grid').treegrid({   //定位到Table标签，Table标签的ID是grid
                url: '${path}/manage/functionMenu/datagrid.do',   //指向后台的Action来获取当前菜单的信息的Json格式的数据
                fit:true,
                title: '功能列表',
                iconCls: 'icon-save',
                fitColumns:true, 
                method: 'post',
				lines: true,
				rownumbers: true,
				idField: 'id',
				treeField: 'name',
                columns: [[
                     { title: '功能名称', field: 'name', width:'25%',align:'left'},
                     { title: '功能代码', field: 'code', width:'10%',align:'center'},
                     { title: '功能连接', field: 'url', width:'30%',align:'left'},
                     { title: '功能排序', field: 'sortnum', width:'5%',align:'center'},
                     { title: '创建时间', field: 'createTime', width:'15%',align:'center' },
                     { title: '更新时间', field: 'updateTime', width:'15%',align:'center' },
                ]],
                toolbar: [{
                    id: 'btnAdd',
                    text: '添加',
                    iconCls: 'icon-add',
                    handler: function () {
                        add();//实现添加记录的页面
                    }
                },'-', {
                    id: 'btnEdit',
                    text: '编辑',
                    iconCls: 'icon-edit',
                    handler: function () {
                        Edit();//实现直接删除数据的方法
                    }
                }, '-', {
                    id: 'btnDelete',
                    text: '删除',
                    iconCls: 'icon-remove',
                    handler: function () {
                        Delete();//实现直接删除数据的方法
                    }
                }, '-', {
                    id: 'btnReload',
                    text: '刷新',
                    iconCls: 'icon-reload',
                    handler: function () {
                        //实现刷新栏目中的数据
                        $("#grid").treegrid("reload");
                    }
                }],
            });
        };
        
        
    function add(){
		$('#dlg').dialog('open').dialog('setTitle','添加');
		$('#fm').form('clear');
		var row = $('#grid').datagrid('getSelected');
	 	if (row){
	 		var id = row.id;
	 		
	 		
	 	}else{
	 	
	 	}
		
		url = path+"/menu/save?parentid=0";
		mesTitle = '添加成功';
	}
	
		function save(){
	 	$('#fm').form('submit',{
		 	url: url,
		 	onSubmit: function(){
		 		return $(this).form('validate');
		 	},
			success: function(result){
				var result = eval('('+result+')');
				if (result.success){
				 	$('#dlg').dialog('close'); 
				 	$('#datagrid').datagrid('reload'); 
				} else {
					 mesTitle = '新增菜单失败';
				}
				$.messager.show({ 
					 title: mesTitle,
					 msg: result.msg
				});
			}
	 	});
	}	
</script>

</head>
<body >
<div class="easyui-layout" data-options="fit:true">
            <table id="grid" class="easyui-treegrid"></table>
</div>
            
            
            		<!-- 添加/修改对话框 -->
		<div id="dlg" class="easyui-dialog"
			style="width:400px;height:200px;padding:10px 20px" closed="true"
			buttons="#dlg-buttons">
			<form id="fm" method="post" novalidate>
				<div class="fitem">
					<label>功能名称:</label> <input name="text" class="easyui-textbox" required="true">
				</div>
				<div class="fitem">
					<label>功能代码:</label> <input name="text" class="easyui-textbox" >
				</div>
				<div class="fitem">
					<label>功能连接:</label> <input name="url" class="easyui-textbox" required="true">
				</div>
				<div class="fitem">
					<label>功能排序:</label> <input name="url" class="easyui-textbox" required="true">
				</div>
			</form>
		</div>
		
		<!-- 添加/修改对话框按钮 -->
		<div id="dlg-buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton c6"
				iconCls="icon-ok" onclick="save()" style="width:90px">保存</a> 
				<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')"
				style="width:90px">取消</a>
		</div>
</body>
</html>
