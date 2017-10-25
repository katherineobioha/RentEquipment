<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="true" %>

<html>
<head>
<sec:authorize access="isAuthenticated()">
		 Username: <sec:authentication property="principal.username" />
		 Role: <sec:authentication property="principal.authorities"/>
		 </sec:authorize>
<style>		 
		 
div {
    font-family: monospace;
    background-color: black;
    margin-top: 150px;
    margin-bottom: 100px;
    margin-right: 300px;
    margin-left: 300px;
   
}
article {
   margin-left: 170px;
    border-left: 1px solid gray;
    padding: 1em;
    overflow: hidden;
}
time {
	
	float: left;
    max-width: 160px;
    margin: 0;
    padding: 1em;
}
header, footer{

 padding: 1em;
    color: white;
    background-color: black;
    clear: left;
    text-align: center;
    
}
time ul {
    list-style-type: none;
    padding: 0;
}
   
 a {
    text-decoration: none;
    color: green;
}


}
th, td {
    padding: 5px;
    text-align: left;    
}
dc{

margin-left: 100px;
}

</style>
</head>
<body style ="background-color:black;" >
<div>
<time><ul><button><a href="<c:url value='/search' />">Rent Equipment</a> </button> </ul></time>
<article>
<table style="width:100%">
  <tr>
    <th><a>Firstname:</a></th>
    <td><a>${ser.firstname}</a></td>
  </tr>
  <tr>
    <th><a>Lastname:</a></th>
    <td><a>${ser.lastname}</a></td>
  </tr>
  <tr>
    <th><a>Username:</a></th>
    <td><a>${ser.username}</a></td>
  </tr>
  <tr>
    <th><a>University:</a></th>
    <td><a>${ser.university}</a></td>
  </tr>
  <tr>
    <th><a>Location:</a></th>
    <td><a>${ser.location}</a></td>
  </tr>
  <tr>
  <th><a>role:</a></th>
    <td><a>${ser.role}</a></td>
  </tr>
</table>
  
   <dc><td style = width:><button><a href="<c:url value='/Person/update/${ser.ID}' />">Update</a></button></td></dc>
   
</article>
</div>
 ${ser.username}
 ${ser.ID}
 



</body>
</html>