<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="CSS/my-styles.css" type="text/css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<title>Create Account</title>
</head>
<body>
	
	<div class="jumbotron text-center">
		<h1>G U A W A</h1>
	</div>
	
	<div class="container text-center text-dark">
		<p class="center text-lg text-danger">${param.m}</p>
		<form action="create-account" method="POST">
			<table class="center">
				<tr>
					<td class="right padding"><strong class="text-lg">Username: </strong></td>
					<td><input type="text" name="username" placeholder="username" class="form-control-lg"></td>
				</tr>
				<tr>
					<td class="right padding"><strong class="text-lg">Password: </strong></td>
					<td><input type="password" name="password" placeholder="password" class="form-control-lg"></td>
				</tr>
				<tr>
					<td class="right padding"><strong class="text-lg">Repeat password: </strong></td>
					<td><input type="password" name="password2" placeholder="repeat password" class="form-control-lg"></td>
				</tr>
				<tr>
					<td></td>
					<td class="padding-sm"><button type="submit" class="btn btn-lg btn-light btn-outline-dark form-control">Create Account</button></td>
				</tr>
				<tr>
					<td></td>
					<td class="padding-sm"><button type="submit" form="login" class="btn btn-lg btn-light btn-outline-dark form-control">Login</button></td>
				</tr>
			</table>
		</form>
	</div>
	
	<form action="login" method="GET" id="login"></form>
	
</body>
</html>