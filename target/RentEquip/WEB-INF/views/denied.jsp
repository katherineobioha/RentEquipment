<?xml  version="1.0" encoding="UTF-8"?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	
		<h1 id="banner">Unauthorized Access !!</h1>
	
		<hr />
	
		<c:if test="${not empty error}">
			<div style="color:red"> 
				Caused : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
			</div>
		</c:if>
	
		<p class="message">Access denied!</p>
		<a href="/login">Go back to login page</a> 
		<h6><a href="javascript:window.history.back()">Back to last page</a></h6>
	</body>
</html>