<%@page import="cs.dit.dto.LoginDto"%>
<%@page import="cs.dit.dao.LoginDao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix ="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>  

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>제품 목록</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container"><br>	
	<h2 class="text-center font-weight-bold">제품 목록</h2>
	<br>
	<table class="table table-hover">
		<tr>
			<th>번호</th>
			<th>제품명</th>
			<th>수량</th>
			<th>가격</th>
			<th>총액</th>
		</tr>
		<c:forEach var='dto' items='${dtos}'>
			<tr>
				<td>${dto.num}</td>
				<td><a href="updateForm.do?num=${dto.num}">${dto.p_name}</a></td> 
				<td>${dto.quantity}</td>
				<td>${dto.price}</td>
				<td>${dto.price*dto.quantity}</td>				
			</tr>
		</c:forEach>
	</table>
	<br>
	<input type="button" value ="홈으로" onclick ="location.href='index.do'">
	<input type="button" value ="제품 등록" onclick ="location.href='insertForm.do'">
	</div>	
</body>
</html>