<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="login.title" /></title>
</head>
<body>
	<form:form modelAttribute="loginCommand">
	<form:errors />
		<p>
			<label><spring:message code="email" />:<br>
				<form:input path="email" />
				<form:errors path="email" />
			</label>
		</p>
		<p>
			<label><spring:message code="password" />:<br>
				<form:password path="password" />
				<form:errors path="password" />
			</label>
		</p>
		<p>
			<label><spring:message code="rememberEmail" />:
				<form:checkbox path="rememberEmail" /> 
			</label>
		</p>
		<input type="submit" value="<spring:message code="login.btn" />">
	</form:form>
</body>
</html>

<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form modelAttribute="login" method="post" action="result">
		<p>
			<label for="loginType">■ 로그인 타입</label>
			<form:select path="loginType" items="${loginTypes }" />
			<form:select path="loginType">
				<option value=""> -- 선택하세요 -- </option>
				<form:options items="${loginTypes }"/>
			</form:select>
		</p>
	
		<p>
			<label for="jobCodes">■ 직군</label>
			<form:select path="jobCode">
				<option value=""> -- 선택하세요2 -- </option>
				<form:options items="${jobCodes }" itemLabel="label" itemValue="code" />
			</form:select>
		</p>
		
		<p>
			<label for="tools">■ 주로 사용하는 개발 툴</label><br>
			<form:radiobuttons items="${tools }" path="tool" delimiter="<br>"/>
		</p>
		
		<p>
			<label for="favoriteOsNames">■ 선호 OS</label>
			<form:checkboxes items="${favoriteOsNames }" path="favoriteOs" delimiter=" "/>
		</p>

		<p>
			<label for="osCodes">■ 좋아 OS</label>
			<form:checkboxes items="${osCodes }" path="osCode" itemLabel="label" itemValue="code" delimiter=" "/>
		</p>
		
		<p>
			<label for="strSubject">■ 좋아하는 과목 </label>
			<form:checkboxes items="${subjects }" path="strSubject" itemLabel="label" itemValue="code" delimiter=" "/>
		</p>

		<input type="submit" value="결과보기">
	</form:form>
</body>
</html> --%>