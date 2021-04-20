<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="CSS/my-styles.css" type="text/css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Menu</title>
</head>
<body>
	
	<div class="jumbotron text-center">
		<h1>G U A W A</h1>
	</div>
	
	<div class="container text-center text-dark">
		<div class="row">
			<div class="col-lg-6"><h2>My lists</h2></div>
			<div class="col-lg-6"><h2>My lists</h2></div>
		</div>
		
		<br><br>
		
		<form action="menu" method="POST">
			<div class="row">
				<c:forEach items="${ownedShoppinglists}" var="list">
					<div class="col-lg-3">
						<h5>${list.title}</h5>
						<p>This is a shoppinglist</p>
					</div>
				</c:forEach>
			</div>
		</form>
	</div>
	
</body>
</html>