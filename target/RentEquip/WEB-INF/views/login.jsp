<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<html>
<head>
<style>


div {
    font-family: monospace;
    background-color: black;
    margin-top: 150px;
    text-decoration: none;
    color: white;
    margin-bottom: 100px;
    margin-right: 300px;
    margin-left: 300px;
   
}

c  {
	
	text-decoration: none;
	color: white;

 }

</style>
</head>
	<body style ="background-color:black;">
	<div>	
		<p id="banner">Rent An Equipment</p>
		 
		<form name="f" action="j_spring_security_check" method="POST">
			<table>
			
				<tr>
					<td> <c> Username: </c></td>
					<td><input type='text' name='j_username' /></td>
				</tr>
				<tr>
					<td><c>Password:</c></td>
					<td><input type='password' name='j_password'></td>
				</tr>
				
				<tr>
					<td colspan="2">&nbsp;</td>
				</tr>
				<tr>
					<td colspan='2'>&nbsp;<input value="Login" name="submit" type="submit">&nbsp;<button><a href="<c:url value='/signup' />" style = "text-decoration:none; color: black;">Signup</a></button></td>
				</tr>
			</table>
		</form>
	
			</div> 
		</body>
		
		
	
	
	
	
</html>