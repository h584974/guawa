<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>Login</title>
</head>
<body>
	
	<div class="jumbotron text-center">
		<h1>G U A W A</h1>
	</div>
	
	<div class="container text-center text-dark">
		<form action="login" method="POST">
			<div class="form-group">
				<label for="username">Username: </label>
				<input type="text" name="username" id="username" placeholder="username" class="form-control-lg">
			</div>
			<div class="form-group">
				<label for="password">Password: </label>
				<input type="password" name="password" id="password" placeholder="password" class="form-control-lg">
			</div>
			<button type="submit" class="btn btn-lg btn-light btn-outline-dark form-control-lg">Login</button>
		</form>
	</div>
	
</body>
</html>