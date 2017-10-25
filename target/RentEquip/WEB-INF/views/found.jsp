<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	color: green;

 }

</style>
</head>
<body style ="background-color:black;">
<div>
    <c><h2>Found Equipments</h2></c>
 
    <c:forEach var="equip" items="${foundEquip}">
        <ul>
        <c> <li>Manufacturer:</li></c>
         <c> <li>${equip.getmanufacturer()}</li></c>
         <c> <li>Name:</li></c>
          <c><li>${equip.getname()}</li></c>
          <c> <li>Location:</li></c>
         <c> <li>${equip.getlocation()}</li></c>
         <c> <li>User:</li></c>
         <c> <li>${equip.person.firstname}</li></c>
         <c> <li>${equip.person.lastname}</li></c>
         <c:if test="${equip.getborrowed() ne 1}">
         <c> <li>Availability:</li></c>
         <c> <li>Available</li></c>
         </c:if>
         <c:if test="${equip.getborrowed() eq 1}">
         <c> <li>Availability:</li></c>
         <c> <li>Not Available</li></c>
         </c:if>
         
          <c> </li><button><a href="<c:url value='/rent/${equip.getID()}' />" style ="text-decoration:none" style="color:green">Rent</a></button></li></c>
        </ul>
        <hr>
    </c:forEach>
    <button><a href="<c:url value='/menu' />">Menu</a></button>
 </div>
</body>
</html>