<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${login.loginType }
	<br>
	${login.jobCode }
	<br>
	${login.tool }
	<br>
	${login.favoriteOs }
	<br>
	${login.osCode }
	<br>
	${login.strSubject }
	<br>
	<c:forEach items="${login.subject }" var="subject" varStatus="idx">
	${subject }
	</c:forEach>
</body>
</html>