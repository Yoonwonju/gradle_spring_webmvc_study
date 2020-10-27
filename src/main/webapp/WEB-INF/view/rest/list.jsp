<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
$(function(){
	$.get("/gradle_spring_webmvc_study/api/members",
			function(json){
		var dataLength = json.length;
		if(dataLength >= 1){
			var sCont = "";
			for(i = 0; i < dataLength; i++){
				sCont += "<tr>";
				sCont += "<td>" + json[i].id + "</td>";
				sCont += "<td><a href='members/" + json[i].id +"'>"
							+ json[i].name + "</a></td>";
				sCont += "<td>" + json[i].email + "</td>";
                sCont += "<td>" + json[i].registerDateTime + "</td>";
                sCont += "</tr>";
			}
			$("#load:last-child").append(sCont);
		}
	});
});
</script>
<title><spring:message code="member.list" /></title>
</head>
<body>
	<table border="1">
		<thead>
			<th><spring:message code="id" /></th>
			<th><spring:message code="email" /> </th>
			<th><spring:message code="name" /> </th>
			<th><spring:message code="subscription.date" /> </th>
		</thead>
		<tbody id="load"></tbody>
	</table>
</body>
</html>