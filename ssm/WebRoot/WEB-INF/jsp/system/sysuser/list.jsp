<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>用户管理</title>
<%@include file="/include/easyui_core.jsp"%>

<script type="text/javascript">
	$(function(){
	    InitGrid();	
	    BindSearchEvent();
	});
        //实现对DataGird控件的绑定操作
        function InitGrid(queryData) {
            $('#grid').datagrid({   //定位到Table标签，Table标签的ID是grid
                url: '${path}/manage/sysuser/datagrid.do',   //指向后台的Action来获取当前菜单的信息的Json格式的数据
                fit:true,
                title: '用户列表',
                iconCls: 'icon-save',
                fitColumns:true, 
                nowrap: true,
                autoRowHeight: false,
                striped: true,
                collapsible: true,
                pagination: true,
                pageSize: 10,
                pageList: [10,20,50],
                rownumbers: true,
                sortOrder: 'asc',
                remoteSort: false,
                idField: 'id',
                queryParams: queryData,  //异步查询的参数
                columns: [[
                     { field: 'ck', checkbox: true },   //选择
                     { title: '用户名', field: 'userName', width:100,align:'center'},
                     { title: '密码', field: 'userRealPassword', width:100,align:'center'},
                     { title: '姓名', field: 'name', width:100,align:'center'},
                     { title: '电话', field: 'phone', width:100,align:'center' },
                     { title: '手机号', field: 'mobile', width:100,align:'center' },
                     { title: '邮箱', field: 'email',width:100,align:'center' },
                     { title: '创建时间', field: 'createTime',width:100,align:'center',formatter: function (val, rowdata, index) {
                                 var date = new Date(val);
                                 return date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate();
                         }
                     
                      },
                     { title: '操作', field: 'action', width:100,align:'center',formatter: function (val, rowdata, index) {
                                return '<a href="javascript:onEdit()">修改</a>';
                         }
                       },
                ]],
                toolbar: [{
                    id: 'btnAdd',
                    text: '添加',
                    iconCls: 'icon-add',
                    handler: function () {
                        ShowAddDialog();//实现添加记录的页面
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
                        $("#grid").datagrid("reload");
                    }
                }],
            })
        };
        
       function BindSearchEvent() {
            //按条件进行查询数据，首先我们得到数据的值
            $("#btnSearch").click(function () {
                var queryData = {
                    userName: $("#userName").val(),
                };
                //将值传递给
                InitGrid(queryData);
                return false;
            });
        }
        
        function ShowAddDialog(){
	        $.dialog({ 
				    title:'添加',
				    content: 'url:${path}/manage/sysuser/add.do', 
				    width:'750px',
				    hight:'500px',
				    skin:'blue',
				    min:false,
				    max:false,
				    lock:true
				});	
        }
	
</script>

</head>
<body >
<div class="easyui-layout" data-options="fit:true" id="tb">
        <div data-options="region:'north'" style="padding:5px;height:70px">
            <!-------------------------------搜索框----------------------------------->
            <fieldset>
                <legend>信息查询</legend>
                    <div id="toolbar">
                        <table cellspacing="0" cellpadding="0">
                            <tr>
                                <th>
                                    <label for="userName">用户名：</label>
                                </th>
                                <td>
                                    <input type="text" id="userName" name="userName" style="width:100px" />
                                </td>
                                <td colspan="2">
                                    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" id="btnSearch">查询</a>
                                </td>
                            </tr>
                        </table>
                    </div>
            </fieldset>
        </div>
        <div data-options="region:'center'">
            <table id="grid"></table>
        </div>
    </div>
</body>
</html>
