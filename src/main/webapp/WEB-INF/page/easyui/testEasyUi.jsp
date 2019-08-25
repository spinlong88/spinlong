<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zh-CN">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<meta name="format-detection" content="telephone=no">
		<title>发布采购</title>
	
		
		<script type="text/javascript" src="<%=request.getContextPath()%>/easyui/jquery.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/easyui/jquery.easyui.min.js"></script>
		 <!-- 引入EasyUI的中文国际化js，让EasyUI支持中文 -->
  		 <script type="text/javascript" src="<%=request.getContextPath()%>/easyui//locale/easyui-lang-zh_CN.js"></script>
  		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/easyui/themes/default/easyui.css">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/easyui/themes/icon.css">
		
		
		</head>
	<body class="no-header" id="body">
		
		<table id="mytable"></table>

		<script type="text/javascript">
		
		$(function() {
			//页面加载完成后，创建数据表格datagrid
			$("#mytable").datagrid(
							{
								//定义标题行所有的列，注意这是一个二维数组
								columns : [ [ {
									title : '编号',
									field : 'id',
									checkbox : true
								}, {
									title : '姓名',
									field : 'username'
								}, {
									title : '年龄',
									field : 'age'
								}, {
									title : '地址',
									field : 'address'
								} ] ],
								//指定数据表格发送ajax请求的地址
								url : '${pageContext.request.contextPath }/list',
                                            <!--使用独立的一列显示行数-->
								rownumbers : true,
								singleSelect : true,
								//定义工具栏
								toolbar : [ {
									text : '添加',
									iconCls : 'icon-add',
									//为按钮绑定单击事件
									handler : function() {
										alert('add...');
									}
								}, {
									text : '删除',
									iconCls : 'icon-remove'
								}, {
									text : '修改',
									iconCls : 'icon-edit'
								}, {
									text : '查询',
									iconCls : 'icon-search'
								} ],
								//显示分页条
								pagination : true,
 
                                                                     //显示分页的条数
								pageList : [ 3, 5, 7, 10 ]
							});
		});
		
		
		</script>
	</body>
</html>

