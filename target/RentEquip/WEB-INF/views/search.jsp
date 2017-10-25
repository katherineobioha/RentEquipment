<html>
<body>
    <h1>Search for Books</h1>
    <form action="doSearch" method="post">
      Search: <input type="text" name="searchText" /><br/>
      <input type="reset"/>
      <input type="submit"/>
    </form>
    
    
    <c:forEach var="equip" items="${foundEquips}">
        <ul>
          <li>${equip.name}</li>
          <li>${equip.manufacturer}</li>
          <li>${equip.location}</li>
          </li><a href="<c:url value='/rent/${equip.id}' />" >Rent</a></li>
        </ul>
    </c:forEach>
    
</body>
</html>