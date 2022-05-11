<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	${result.tempVal}
	
	<div class="box-btn">
		<c:url var="uptUrl" value="/temp2/tempRegist.do">
			<c:param name="tempId" value="${result.tempId}"/>
		</c:url>
		<a href="${uptUrl}">수정</a>
		
		<c:url var="delUrl" value="/temp2/delete.do">
			<c:param name="tempId" value="${result.tempId}"/>
		</c:url>
		<a href="${delUrl}" class="btn-del">삭제</a>
		
		<a href="/temp2/selectList.do">목록</a>	 	
	</div>
	
	<script>
	$(document).ready(function(){
		$(".btn-del").click(function(){
			if(!confirm("삭제하시겠습니까?")){
				return false;
			}
		});
	});
	</script>
	
	<table>
		<tbody>
			<tr>
				<th>제목</th>
				<td><c:out value="${result.crudId}"/></td>
				<th>작성자</th>
				<td><c:out value="${result.userNm}"/></td>
				<th>작성일</th>
				<td><c:out value="${result.frstRegistPnttm}" patten="yyyy-MM-dd"/></td>
				<th>내용</th>
				<td><c:out value="${result.crudCn}"/></td>
			</tr>
		</tbody>
	</table>
</body>
</html>