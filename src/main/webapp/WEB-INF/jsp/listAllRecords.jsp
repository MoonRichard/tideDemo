<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ListAllRecord</title>
</head>
<body>
<%@ include file="includeTop.jsp" %>
<table border="1px" width="100%">
	<tr>
		<td colspan="3" bgcolor="#EEEEEE">所有Records</td>
	</tr>
	<tr>
	<tr>
			   <c:if test="${USER_CONTEXT.userType == 2}">
			     <td>
			        <script>
			            function switchSelectBox(){
			                var selectBoxs = document.all("boardIds");
			                if(!selectBoxs) return ;
			                if(typeof(selectBoxs.length) == "undefined"){//only one checkbox
			                    selectBoxs.checked = event.srcElement.checked;
			                }else{//many checkbox ,so is a array 
			                  for(var i = 0 ; i < selectBoxs.length ; i++){
			                     selectBoxs[i].checked = event.srcElement.checked;
			                  }
			                } 
			            }
			        </script>
			        <input type="checkbox" onclick="switchSelectBox()"/>
			     </td>
			   </c:if>
		<td width="20%">recordText</td>
		<td width="70%">eventLocation</td>
		<td width="10%">evenTime</td>
	</tr>
	<c:forEach var="record" items="${records}">
		<tr>
	       	<c:if test="${USER_CONTEXT.userType == 2}">
			          <td><input type="checkbox" name="recordId" value="${record.recordId}"/></td>
			 </c:if>
			<td>${record.recordText}</td>
			<td>${record.eventLocation}</td>
			<td>${record.evenTime}</td>
		</tr>
	</c:forEach>
</table>

</body>
</html>
