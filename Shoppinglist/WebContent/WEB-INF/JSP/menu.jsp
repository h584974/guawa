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
		<form action="menu" method="POST">
			<div class="row">
				<c:forEach items="${ownedShoppinglists}" var="list">
					<div class="col-sm-4">
						<h2>${list.title}</h2>
						<p>This is a shoppinglist</p>
					</div>
				</c:forEach>
			</div>
		</form>
	</div>
	
</body>
</html>