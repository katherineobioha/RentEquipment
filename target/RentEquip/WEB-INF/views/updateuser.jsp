<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="true" %>


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

<c:url var="updateAction" value="/person/uppy" ></c:url>

<form:form action="${updateAction}" commandName="ser">
<div>
<table>
	<c:if test="${!empty ser.ID}">
	<tr>  
		<td>
			<form:label path="ID">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="ID" readonly="true" size="8"  disabled="true" />
			<form:hidden path="ID" />
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
		<td><form:errors path="firstname" /></td>
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
		<td><form:errors path="lastname" /></td>
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
		<td><form:errors path="username" /></td>
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
		<td><form:errors path="password" /></td>
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
		<td><form:errors path="university" /></td>
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
		<td><form:errors path="location" /></td>
	</tr>
	<tr>
		<td>
			<form:input path="role" type = "hidden" />
		</td>
		<td><form:errors path="role" /></td>
	</tr>
	
	<tr> 
		<td colspan="2">
			<c:if test="${!empty ser.ID}">
				<input type="submit"
					value="<spring:message text="Edit Person"/>" />
			</c:if>
		</td>
	</tr>
</table>	

</form:form>
<button><a href="<c:url value='/menu' />">Menu</a></button>
</div>
</body>
</html>