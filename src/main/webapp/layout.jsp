<%@ page contentType="text/html;charset=UTF-8" language="java" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/> 
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Basic Layout - jQuery EasyUI Demo</title>
    <link rel="stylesheet" type="text/css" href="${ctx }/static/easyui-1.4.5/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${ctx }/static/easyui-1.4.5/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="${ctx }/static/easyui-1.4.5/demo.css">
    <script type="text/javascript" src="${ctx }/static/easyui-1.4.5/jquery.min.js"></script>
    <script type="text/javascript" src="${ctx }/static/easyui-1.4.5/jquery.easyui.min.js"></script>
    <style type="text/css">
    	.copyright {
    		/*background:#ccc;*/
    		text-align: center;
    	}
    </style>
</head>
<body class="easyui-layout">
    <div data-options="region:'north',title:'North Title',split:true" style="height:100px;"></div>
    <div data-options="region:'south',title:'Copyright(c) niugg 2016',collapsible:false,headerCls:'copyright'"></div>
    <!-- <div data-options="region:'east',title:'East',split:true" style="width:100px;"></div> -->
    <div data-options="region:'west',title:'West',split:true" style="width:100px;"></div>
    <div data-options="region:'center',title:'center title'" style="padding:5px;background:#eee;"></div>
</body>