<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>

	<link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

	<c:url value="/css/main.css" var="jstlCss" />
	<link href="${jstlCss}" rel="stylesheet" />

      <style>
         table, th, td {
            border: 1px solid black;
         }
      </style>

</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Carlos Test</a>
			</div>
		</div>
	</nav>

	<hr style="height:2px;border-width:0;color:gray;background-color:gray">

	<div class="container">
		<div class="starter-template">
			<h1>Spring Boot Web, API and Persitence Test</h1>
			<h2>Message: ${message}</h2>
		</div>
	</div>
	
	<hr style="height:2px;border-width:0;color:gray;background-color:gray">
	
	<font color="red">${errorMessage}</font>
	
	<!-- ADD -->
	<c:url var="add_person_url" value="/add"/>
    <form method="post" action="${add_person_url}" modelAttribute="person">
		<input type="submit"  value="Add" />
        <br>
        <br> 
        <br> 
        Nome : <input type="name" name="name" />
        Sobrenome : <input type="lastName" name="lastName" />
    </form>

	<hr style="height:2px;border-width:0;color:gray;background-color:gray">
	
	<!-- LIST -->
	<c:url var="list_person_url" value="/list" />
    <form method="get" action="${list_person_url}" >
        <input type="submit" value="List"/>
        <br>
        <br> 
        <br> 
        <table>
            <thead>
                <tr>
                	<th style="padding:10px">CPF</th>
                    <th style="padding:10px">Nome</th>
                    <th style="padding:10px">Sobrenome</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${persons}" var="person">
                    <tr>
                        <td style="padding:10px">${person.cpf}</td>
                        <td style="padding:10px">${person.name}</td>
                        <td style="padding:10px">${person.lastName}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </form>
	
	<hr style="height:2px;border-width:0;color:gray;background-color:gray">
	
	<!-- UPDATE -->
	<c:url var="update_person_url" value="/update" />
	<form method="post" action="${update_person_url}" modelAttribute="person">
		<input type="submit"  value="Update" />
        <br>
        <br> 
        <br> 
        Id : <input type="cpf" name="cpf" />
        Nome : <input type="name" name="name" />
        Sobrenome : <input type="lastName" name="lastName" />
    </form>
	
	<hr style="height:2px;border-width:0;color:gray;background-color:gray">
	
	<!-- DELETE -->
	<c:url var="delete_person_url" value="/delete" />
	<form method="post" action="${delete_person_url}" modelAttribute="person">
		<input type="submit"  value="Delete" />
        <br>
        <br> 
        <br> 
        Id : <input type="cpf" name="cpf" />
        
    </form>

	<hr style="height:2px;border-width:0;color:gray;background-color:gray">	
	
	<!-- FIND BY CPF -->
	<c:url var="find_person_url" value="/find" />
	<form method="get" action="${find_person_url}" modelAttribute="person">
		<input type="submit"  value="Find By CPF" />
        <br>
        <br> 
        <br> 
        Id : <input type="cpf" name="cpf" />
        <br>
        <br> 
        <br> 
        <table>
            <thead>
                <tr>
                	<th style="padding:10px">CPF</th>
                    <th style="padding:10px">Nome</th>
                    <th style="padding:10px">Sobrenome</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${list}" var="person">
                    <tr>
                        <td style="padding:10px">${person.cpf}</td>
                        <td style="padding:10px">${person.name}</td>
                        <td style="padding:10px">${person.lastName}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </form>
	
	<hr style="height:2px;border-width:0;color:gray;background-color:gray">	

</body>

</html>