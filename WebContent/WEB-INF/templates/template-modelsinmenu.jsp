<%-- classic2 layout --%> 

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link href="${param.css}" type="text/css" rel="stylesheet" />
  <title> ${param.title} </title>
  <link rel="shortcut icon" href="${param.favicon}" />
</head>
<body>
	<div id="page-wrap">
		<jsp:include page="${param.header}" />
		<jsp:include page="${param.body}" />
		<jsp:include page="${param.footer}" />
	</div>
	<script type="text/javascript" src="${param.jquery}" ></script>
	<script type="text/javascript" src="${param.jquery_ui}" ></script>
	<script type="text/javascript" src="${param.js}" ></script>
</body>
</html>
