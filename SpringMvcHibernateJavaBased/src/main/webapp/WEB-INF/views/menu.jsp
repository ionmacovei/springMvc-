<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="css/style.css" />" rel="stylesheet">

<title>Spring MVC</title>
</head>
<body>

	<nav class="nav">
	<ul>
		<li><a href="./">Home</a></li>
		<li class="drop"><a>Users</a>
			<div class="dropdownContain">
				<div class="dropOut">
					<div class="triangle"></div>
					<ul>
						<li><a href="newUser">Add User</a></li>
						<li><a href="listUsers">View Users</a></li>
					</ul>
				</div>
			</div></li>
		<li class="drop"><a>Adress</a>

			<div class="dropdownContain">
				<div class="dropOut">
					<div class="triangle"></div>
					<ul>
						<li><a href="newAdress">Add Address</a></li>
						<li><a href="listAdress">View Adsresses</a></li>
					</ul>
				</div>
			</div></li>
		<li class="drop"><a>Project</a>

			<div class="dropdownContain">
				<div class="dropOut">
					<div class="triangle"></div>
					<ul>
						<li><a href="newProject">Add Project</a></li>
						<li><a href="listProjects">View Projects</a></li>
					</ul>
				</div>
			</div></li>

	</ul>
	</nav>