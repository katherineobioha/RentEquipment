<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

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
c 
 {
	
	text-decoration: none;
	color: white;

 }

</style>
</head>
<body style = "background-color:black;">

<c:url var="addAction" value="/Person/add" ></c:url>

<form:form action="${addAction}" commandName="Person">
<div>
<p id="banner">Sign Up</p>
<table>
	<c:if test="${!empty Person.username}">
	<tr>
		<td>
		
			<form:label path="ID">
				<c><spring:message text="ID"/></c>
			</form:label>
		</td>
		<td>
			<form:input path="ID" readonly="true" size="8"  disabled="true" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="firstname">
				<c><spring:message text="Firstname"/></c>
			</form:label>
		</td>
		<td>
			<form:input path="firstname" />
		</td>
		<td><c><form:errors path="firstname" /></c></td>
	</tr>
	<tr>
		<td>
			<form:label path="lastname">
				<c><spring:message text="Lastname"/></c>
			</form:label>
		</td>
		<td>
			<form:input path="lastname" />
		</td>
		<td><c><form:errors path="lastname" /></c></td>
	</tr>
	<tr>
		<td>
			<form:label path="username">
				<c><spring:message text="username"/></c>
			</form:label>
		</td>
		<td>
			<form:input path="username" />
		</td>
		<td><c><form:errors path="username" /></c></td>
	</tr>
	<tr>
		<td>
			<form:label path="password">
				<c><spring:message text="Password"/></c>
			</form:label>
		</td>
		<td>
			<form:input path="password" />
		</td>
		<td><c><form:errors path="password" /></c></td>
	</tr>
	<tr>
		<td>
			<form:label path="university">
				<c><spring:message text="University"/></c>
			</form:label>
		</td>
		<td>
			<form:input path="university" />
		</td>
		<td><c><form:errors path="university" /></c></td>
	</tr>
	<tr>
		<td>
			<form:label path="location">
				<c><spring:message text="Location"/></c>
			</form:label>
		</td>
		<td>
			<form:input path="location" />
		</td>
		<td><c><form:errors path="location" /></c></td>
	</tr>
	<tr>
		<td>
			<form:label path="role">
				<c><spring:message text="Role"/></c>
			</form:label>
		</td>
		<td>
			<form:input path="role" />
		</td>
		<td><c><form:errors path="role" /><c></td>
	</tr>
	
	<tr>
		<td colspan="2">
			<c:if test="${empty Person.username}">
				<input type="submit"
					value="<spring:message text="Sign up"/>" />
			</c:if>
		</td>
	</tr>
	
</table>	
</div>
</form:form>
</body>
</html>
