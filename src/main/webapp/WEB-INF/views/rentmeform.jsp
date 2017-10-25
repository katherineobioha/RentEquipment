<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="true" %>

<html>
<head>
<style>


div {
    font-family: monospace;
    background-color: black;
    margin-top: 150px;
    margin-bottom: 100px;
    margin-right: 300px;
    margin-left: 300px;
   
}

c  {
	
	text-decoration: none;
	color: green;

 }

</style>
</head>
<body style = "background-color:black">

<div>
        <c> <li>Manufacturer:</li></c>
         <c> <li>${equipment.getmanufacturer()}</li></c>
         <c> <li>Name:</li></c>
          <c><li>${equipment.getname()}</li></c>
          <c> <li>Location:</li></c>
         <c> <li>${equipment.getlocation()}</li></c>
         <c> <li>User:</li></c>
         <c> <li>${equipment.person.firstname}</li></c>
         <c> <li>${equipment.person.lastname}</li></c>
         <c:if test="${equipment.getborrowed() ne 1}">
         <c> <li>Availability:</li></c>
         <c> <li>Available</li></c>
         </c:if>
         <c:if test="${equipment.getborrowed() eq 1}">
         <c> <li>Availability:</li></c>
         <c> <li>Not Available</li></c>
         </c:if>

<c:url var="updateEquip" value="/rentso" ></c:url>
<form:form action="${updateEquip}" commandName  ="equipment">
      <table>
       <tr>
           <td><form:input path="ID" readonly="true" type = "hidden"/></td>
       </tr> 
       
       <tr>
          
           <td><form:input path="name" readonly="true" type = "hidden"/></td>
           
       </tr> 
       <tr>
           
           <td><form:input path="manufacturer" readonly="true" type = "hidden"/></td>
          
       <tr>
           
           <td><form:input path="location" readonly="true" type = "hidden"/></td>
        
       </tr> 
       <tr>
           
          <td><form:input path="taxonomy" readonly="true" type = "hidden" /></td>
        
       </tr> 
       
       <c:if test="${equipment.getborrowed() ne 1}">
         
         <tr>
        <td>
        
        </td>
       <td><form:input path="borrowed" value="1"  type = "hidden"/></td>
      
       </tr>
       
       <tr>
        <td>
       
        </td>
        <td><form:input path="person.ID" value="${ser.ID}" type = "hidden"/></td>
      
       </tr> 
       <tr>
       <td>
       	<input type="submit"
					value="<spring:message text="Rent"/>" style = "text-decoration:none" style ="color:green"/>
      </td>
       </tr>
       </c:if>
        <c:if test="${equipment.getborrowed() eq 1}">
         <tr>
        <td>
        
        </td>
        <td><form:input path="borrowed" value="0" type = "hidden"/></td>
       
       </tr>
       
       <tr>
       <td>
       <input type="submit"
					value="<spring:message text="Return"/>" style = "text-decoration:none" style ="color:green"/>
       </td>
       </tr> 
       </c:if>
   </table> 
  </form:form> <button><a href="<c:url value='/menu' />">Menu</a></button> </div>
</body>
</html>