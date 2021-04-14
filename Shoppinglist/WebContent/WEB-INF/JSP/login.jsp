<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="CSS/my-styles.css" type="text/css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<title>Login</title>
</head>
<body>
	
	<div class="jumbotron text-center">
		<h1>G U A W A</h1>
	</div>
	
	<div class="container text-center text-dark">
		<p class="center text-lg text-danger">${param.m}</p>
		<form action="login" method="POST">
			<table class="center">
				<tr>
					<td class="right padding"><strong class="text-lg">Email: </strong></td>
					<td><input type="email" name="email" placeholder="email" class="form-control-lg"></td>
				</tr>
				<tr>
					<td class="right padding"><strong class="text-lg">Password: </strong></td>
					<td><input type="password" name="password" placeholder="password" class="form-control-lg"></td>
				</tr>
				<tr>
					<td></td>
					<td class="padding-sm"><button type="submit" class="btn btn-lg btn-light btn-outline-dark form-control">Login</button></td>
				</tr>
				<tr>
					<td></td>
					<td class="padding-sm"><button type="submit" form="create-account" class="btn btn-lg btn-light btn-outline-dark form-control">Create Account</button></td>
				</tr>
			</table>
		</form>
	</div>
	
	<form action="create-account" method="GET" id="create-account"></form>
	
</body>
</html>