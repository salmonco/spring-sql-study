<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수강신청</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
	<div style="max-width: 800px; margin: 0 auto">
        <h2>개설강의 목록</h2>
        <table border="1" style="border-color:blue; width: 100%">
            <thead>
                <tr>
                    <th>번호</th>
                    <th>신청</th>
                    <th>과목코드</th>
                    <th>과목명</th>
                    <th>교수명</th>
                    <th>강의 요일/교시</th>
                    <th>수강인원</th>
                </tr>
            </thead>
            <tbody>
                <c:if test="${empty lectureList}">
                <tr>
                    <td colspan="7" align = "center">조회된 데이터가 없습니다.</td>
                </tr>
                </c:if>
                <c:if test="${not empty lectureList}">
                    <c:forEach var="l" items="${lectureList}" varStatus="status">
                        <tr>
                            <td>${status.count}</td>
                            <td></td>
                            <td>${l.SUBJECT_CD}</td>
                            <td>${l.SUBJECT_NM}</td>
                            <td>${l.PROFESSOR_NM}</td>
                            <td>${l.DOW_P}</td>
                            <td>${l.SUBJECT_LIMIT}</td>
                        </tr>
                    </c:forEach>
                </c:if>
            </tbody>
            
        </table>
        <button type="button" id="fnCloseBtn">닫기</button>
    </div>
	
	<script>
	    
	    $(document).ready(function () {
	    	$("#fnCloseBtn").click(function(){
	    		self.close();
            });
	    });
	</script>
	
</body>

</html>