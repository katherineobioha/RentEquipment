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
	color: white;

 }

</style>
</head>
<body style ="background-color:black;">
   <div> 
   <p style = "font-size:80%;" style = "color:grey;" >Search by name, manufacturer, University-location e.g. MIT, BIOSCOPE MICROSCOPE, Brosandcos </p>
    <form action="doSearch" method="post">
     <c> Search: <input type="text" name="searchText" /><br/></c>
      <input type="reset"/>
      <input type="submit"/>
    </form>
   </div>
    
   
    
</body>
</html>