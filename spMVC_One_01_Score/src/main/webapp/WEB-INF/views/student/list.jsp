<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>

	fieldset {
		margin-left: auto;
		margin-right: auto;
		margin-top: 20px;
		border: 1px solid black; 
		width: 80%; 
	}

	legend {
	
	border-radius: 5px;
	background-color: rgba(0, 0, 0, 0.8);
	margin: 10px 50px;
	padding: 15px 15px;
	color: white;
	font-size: 25px;
	font-weight: bold;
	
	}
</style>
</head>
<body>
<%@include file="/WEB-INF/views/include/include_header.jspf" %>
	<fieldset>
		<legend>학생정보</legend>
		
	</fieldset>
</body>
</html>