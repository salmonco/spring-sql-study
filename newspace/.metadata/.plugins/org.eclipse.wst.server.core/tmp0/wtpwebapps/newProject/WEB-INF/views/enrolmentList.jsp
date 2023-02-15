<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//session.getAttribute("");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수강신청</title>
<link rel="stylesheet" type="text/css" href="/resources/css/popup.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
	<div style="max-width: 800px; margin: 0 auto">
	    <div style="display: flex; justify-content: space-between">
	        <h2>수강신청 목록 (${session.getAttribute("STUDENT_ID")} )</h2>
	        <div style="margin: auto 0">
	            <button type="button">삭제</button>
	            <button type="button" id="fnEnrolBtn">신청</button>
	        </div>
	    </div>
	    <table border="1" style="border-color:blue; width: 100%">
		    <thead>
		        <tr>
		            <th>선택</th>
		            <th>번호</th>
		            <th>수강번호</th>
		            <th>학생명</th>
		            <th>과목코드</th>
		            <th>과목명</th>
		            <th>교수명</th>
		            <th>수강인원</th>
		        </tr>
		    </thead>
		    <tbody>
		        <c:if test="${empty enrolmentList}">
			    <tr>
	                <td colspan="8" align = "center">조회된 데이터가 없습니다.</td>
	            </tr>
	            </c:if>
	            <c:if test="${not empty enrolmentList}">
	                <c:forEach var="e" items="${enrolmentList}" varStatus="status">
	                    <tr>
	                        <td></td>
	                        <td>${status.count}</td>
	                        <td>${e.ENROLMENT_ID}</td>
	                        <td>${e.STUDENT_NM}</td>
	                        <td>${e.SUBJECT_CD}</td>
	                        <td>${e.SUBJECT_NM}</td>
	                        <td>${e.PROFESSOR_NM}</td>
	                        <td>${e.SUBJECT_LIMIT}</td>
	                    </tr>
	                </c:forEach>
	            </c:if>
		    </tbody>
		    
		</table>
	</div>
	
	<div class="popup_layer" id="popup_layer" style="display: none;">
        <div class="popup_box">
        <h2>개설강의 목록  (${session.getAttribute("STUDENT_ID")} )</h2>
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
            <tbody id="tbodyEl">
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
    </div>
	
	<script>
		//팝업 띄우기
		function openPop() {
		    //document.getElementById("popup_layer").style.display = "block";
		     $.ajax({
                type: "POST",
                url: "/enrolmentJson",
                cache: false,
                data: {
                	STUDENT_ID: '4'
                },
                datatype: "JSON",
                success: function (obj) {
                	alert("obj="+JSON.stringify(obj));
                	fnDraw(obj);
                    //var data = JSON.parse(obj);
                    //alert("data="+data);

                    //$.each(data, function (k, v) {
                    //    $('<option></option>').val(k).text(v).appendTo($('#exhibition_id'));
                    //});

                },
                error: function (xhr, status, error) {
                    console.log("ERROR!!!");
                },
                complete : function (xhr, status, error) {
                    console.log("complete!!!");
                }
            });
		    $("#popup_layer").show();
		}
	
		function fnDraw(data){
			console.log("data.length!!!"+data.length);
			var htmlStr = "";
			for(var i=0;i<data.length;i++){
				htmlStr += "<tr>";
				htmlStr += "<td>" + Number(i + 1) + "</td>";
				htmlStr += "<td>" + "<button type=\"button\" onclick=\"fnEnrolByIdBtn('" + ${session.getAttribute('STUDENT_ID')} + "', '" + data[i].PS_ID + "') \">신청</button>" + "</td>";
				htmlStr += "<td>" + data[i].SUBJECT_CD +  "</td>";
				htmlStr += "<td>" + data[i].SUBJECT_NM + "</td>";
				htmlStr += "<td>" + data[i].PROFESSOR_NM + "</td>";
				htmlStr += "<td>" + data[i].DOW_P + "</td>";
				htmlStr += "<td>" + data[i].SUBJECT_LIMIT + "</td>";
				htmlStr += "<tr>";
			}
			console.log("htmlStr="+htmlStr);
			$("#tbodyEl").html(htmlStr);
		}
		//팝업 닫기
		function closePop() {
		    //document.getElementById("popup_layer").style.display = "none";
		    $("#popup_layer").hide();
		}
	
	    const fnEnrolBtn = document.getElementById('fnEnrolBtn');
	    /*fnEnrolBtn.addEventListener('click', function () {
	    	fnEnrolSub('12');
	    });*/
	    //fnEnrolBtn.addEventListener('click', {param1: "Hello"}, fnEnrol );
	    
	    function fnEnrol(event){
		    alert("신청." + event.data.param1);
	    }
	    
	    function fnEnrolSub(val1){
            //window.open("/enrolmentForm","팝업 테스트","width=900, height=800, top=10, left=10");
	    	openPop();
        }
	    
	    function fnEnrolByIdBtn(val1, val2){
	    	console.log("val1="+val1);
	    	console.log("val2="+val2);
	    	$.ajax({
                type: "POST",
                url: "/insertEnrolment",
                cache: false,
                data: {
                    STUDENT_ID: val1
                    ,PS_ID: val2
                },
                datatype: "JSON",
                success: function (obj) {
                    alert("obj="+JSON.stringify(obj));
                    //fnDraw(obj);
                    //var data = JSON.parse(obj);
                    //alert("data="+data);

                    //$.each(data, function (k, v) {
                    //    $('<option></option>').val(k).text(v).appendTo($('#exhibition_id'));
                    //});

                },
                error: function (xhr, status, error) {
                    console.log("ERROR!!!");
                },
                complete : function (xhr, status, error) {
                    console.log("complete!!!");
                }
            });
        }
	   
	    $(document).ready(function () {
	    	$("#fnEnrolBtn").click(function(){
	    		fnEnrolSub('12...');
            });
	    	
	    	$("#fnCloseBtn").click(function(){
	    		closePop();
            });
	    	//$("#fnEnrolBtn").click({param1: "Hello"}, fnEnrol);
	    });
	</script>
	
</body>

</html>