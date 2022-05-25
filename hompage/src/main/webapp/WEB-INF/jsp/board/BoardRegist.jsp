<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Language" content="ko" >
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<title>수업용 게시판</title>
<!-- BBS Style -->
<link href="/asset/BBSTMP_0000000000001/style.css" rel="stylesheet" />
<!-- 공통 Style -->
<link href="/asset/LYTTMP_0000000000000/style.css" rel="stylesheet" />
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>

<!-- 업데이트냐 인서트이냐 분기점 -->
<c:choose>
	<c:when test="${not empty searchVO.boardId}">
		<c:set var="actionUrl" value="/board/update.do"/>
	</c:when>
	<c:otherwise>
		<c:set var="actionUrl" value="/board/insert.do"/>
	</c:otherwise>
</c:choose>

<!-- 감싸는 영역 -->
<div class="container">
	<!-- 감싸는 영역 -->
	<div id="contents">
		<!-- onsubmit 폼 태그를 유효성 검사할때 많이쓴다. 누락한게 있으면 작동한다.regist() 검사가 제대로 되면 리턴을 보낸다. -->
		<form action="${actionUrl}" method="post" id="frm" name="frm" onsubmit="return regist()">
			<input type="hidden" name="boardId" value="${result.boardId}"/>
			
			<table class="chart2">
				<!-- 이 표에대한 제목 꼭들어가 줘야한다. 장애인을 위한 웹편의성  -->
				<caption>게시글 작성</caption>
				<!-- 열너비 조절 -->
				<colgroup>
				<!-- 전체 크기에서 col마다 크기가 배분해서 들어감 -->
					<col style="width:120px">
					<!-- 전체  크기에서 120을 뺀 나머지 값이 들어감(반응형 웹을 위해 이렇게 작성) -->
					<col />
				</colgroup>
				<!-- 제목,공지여부,비공개여부등을 가로로 출력할꺼기 때문에 thead를 써주지 않는다. -->
				<tbody>
					<tr>
						<!-- scope row ,col행렬 차이 -->
						<!-- row 는 열에 표시 ,col는 행에 표시-->
						<th scope="row">제목</th>
						<td>
							<input type="text" id="boardSj" name="boardSj" title="제목입력" class="q3" value="<c:out value="${result.boardSj}"/>"/>
						</td>
					</tr>
					<tr>
						<th scope="row">공지여부</th>
						<td>
							<!-- 예/아니오 선택 -->
							<!-- checked="checked"는 체크박스에 체크가 되있는 디폴트 옵션이다. 일단 아니오가 디폴트가 되게 설정 -->
							<!-- 체크박스로 만드는 경우엔 VO에서 리스트로 받아야된다. 여러개를 선택할수 있으니까 -->
							<!-- 라디오로 만드는 경우엔 오직 하나만을 선택할수 있다. 둘다 체크드로 되어있는 경우 마지막으로 체크드라고 되어있는 곳을 체크한다.-->
							<label for="noticeAtY">예: </label>
							<input type="radio" id="noticeAtY" value="Y" name="noticeAt" <c:if test="${result.noticeAt eq 'Y'}">checked="checked"</c:if>/>&nbsp;&nbsp;&nbsp;
							<label for="noticeAtN">아니오: </label>
							<!-- result.noticeAt ne 'Y'이라고 한 이유는 디폴트 값이 null일수도 있기 때문에 이렇게 만든것이다.
							처음에 등록페이지로 들어올때는 null값으로 들어오기 때문에 그걸 보완해 주기 위해 이렇게 만들것이다. -->
							<input type="radio" id="noticeAtN" value="N" name="noticeAt" <c:if test="${result.noticeAt ne 'Y'}">checked="checked"</c:if>/>
						</td>
					</tr>
					<tr>
						<!-- 비공계도 위랑 동일하다 일단 아니오가 디폴트가 되겠끔설정-->
						<th scope="row">비공개여부</th>
						<td>
							<label for="noticeAtY">예: </label>
							<input type="radio" id="othbcAtY" value="Y" name="othbcAt" <c:if test="${result.othbcAt eq 'Y'}">checked="checked"</c:if>/>&nbsp;&nbsp;&nbsp;
							<label for="noticeAtN">아니오: </label>
							<input type="radio" id="othbcAtN" value="N" name="othbcAt" <c:if test="${result.othbcAt ne 'Y'}">checked="checked"</c:if>/>
						</td>
					</tr>
					<tr>
						<!-- java에서 넘어온 USER_INFO가 출력된다. -->
						<th scope="row">작성자ID</th>
						<td>
							<c:out value="${USER_INFO.id}"/>
						</td>
					</tr>
					<tr>
						<th scope="row">내용</th>
						<td>
							<!-- textarea 코드를 한줄로 붙여 쓰는 이유:중간에 공백이 들어가면 그대로 공백이 적용되어 버린다.
							 textarea태그 안에 존재하는 데이터는 무조건 붙여 써야 정상 출력된다.
							 <c:out value="${result.boardCn}"/>여기부분을 쓸때 <textarea></textarea>태그 사이에 공백을 넣으면 안된다는거다.-->
							<textarea id="boardCn" name="boardCn" rows="15" title="내용입력"><c:out value="${result.boardCn}"/></textarea>
						</td>
					</tr>
				</tbody>
			</table>
			<!--클래스가 두개 쓰인다. btn-cont  / ar-->
			<div class="btn-cont ar">
				<c:choose>
					<c:when test="${not empty searchVO.boardId}">
					<!-- 수정 삭제를 할때 작성자와 관리만 가능해야 하는 역역임에도 여기서 따로 코드를 세팅해주지 않은 이유는 
					이미 콘트롤러에서 해당 코드 내용을 만들어놨기 때문이다.
					자바스크립트 ,jsp, 자바,sql(쿼리) 순으로 보안적으로 막아놓는다. 여기서는 자바에서 막아놨다.
					 -->
						<c:url var="uptUrl" value="/board/update.do">
							<c:param name="boardId" value="${result.boardId}"/>
						</c:url>
						<a href="${uptUrl}" id="btn-reg" class="btn">수정</a>
						
						<c:url var="delUrl" value="/board/delete.do">
							<c:param name="boardId" value="${result.boardId}"/>
						</c:url>
						<a href="${delUrl}" id="btn-del" class="btn">
							<i class="ico-del"></i>삭제</a>
					</c:when>
					<c:otherwise>
						<a href="#none" id="btn-reg" class="btn spot">등록</a>
					</c:otherwise>	
				</c:choose>
				<c:url var="listUrl" value="/board/selectList.do"/>
				<a href="${listUrl}" class="btn">취소</a>
			</div>
		</form>
	</div>
</div>

<!-- 대부분의 스크립트는 아래다 둔다. 나중에 랜더링 되라고
$(document).ready(function() 모든 스크립트가 해당 구문에 쌓여있는게 아니기 때문에 그냥 하단에 위치시킨것같다. -->
<script>

$(document).ready(function(){
	//게시글 등록
	$("#btn-reg").click(function(){
		$("#frm").submit();
		/* 클릭에대한 값을 중복해서 보내지 않기 위해 return false를 준다.
		return false를 넣지만으면 클릭시 바로 해당 기능을 수행하러 이동한다.
		return false를 넣으면 이동하지 않고 해당 페이지에 그대로 머물러 있는다.*/
		return false;
	});
	
	//게시글 삭제
	//#btn-del -->id를 불러오는
	//쿼리는 id,class,tag,input 선택자가 있고
	//id는 ${"# "},class는 ${"."} ,tag는 ${"태그이름"},input은 ${"input[name=text]"} 이런식으로 쓴다.
	//아이디라는 속성은 브라우저 페이지 기준 하나만 있어야 하고 클래스는 여러개있어도 상관없다. 
	$("#btn-del").click(function(){
		if(!confirm("삭제하시겠습니까?")){
			return false;
		}
		
	});
});

function regist(){
	/* boardSj의 값을 가져왔을 때 없으면 */
	if(!$("#boardSj").val()){
		alert("제목을 입력해주세요");
		return false;
	}
}
</script>

</body>
</html>