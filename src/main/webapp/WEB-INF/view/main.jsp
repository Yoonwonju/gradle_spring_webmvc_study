<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="main"/></title>
</head>
<body>
	<c:if test="${empty authInfo }">
		<p><spring:message code="welcome"></spring:message></p>
		<p>
			<a href="<c:url value="/register/step1" />">[<spring:message code="member.join" />]</a>
<!--value="/login" 는 LoginController의 @RequestMapping("/login")값을 가져옴  -->
			<a href="<c:url value="/login" />">[<spring:message code="login.title" />]</a>
		</p>
	</c:if>

	<c:if test="${!empty authInfo }">
		<p>${authInfo.name }님 <spring:message code="welcome"/></p>
		<p>
			<a href="<c:url value="/edit/changePassword" />">[<spring:message code="password.change" />]</a>
			<a href="<c:url value="/logout" />">[<spring:message code="logout.title" />]</a>
		</p>
	</c:if>
</body>

</html>
<!-- <spring:message code="login.title" /> -->