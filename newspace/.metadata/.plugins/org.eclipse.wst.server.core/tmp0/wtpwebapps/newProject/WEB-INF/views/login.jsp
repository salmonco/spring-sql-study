<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
	<title>Login</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
    <div style="max-width: 800px; margin: 0 auto">
        <h2>로그인</h2>
        <div style="display: flex; flex-direction: column; align-items: center">
            <input type="text" id="studentId" placeholder="학번" style="width: 250px; margin-bottom: 10px;">
            <button type="button" id="fnLoginBtn" style="width: 250px;">로그인</button>
        </div>
    </div>
    
    <script>
        //로그인 버튼 클릭
        function fnLogin() {
             $.ajax({
                type: "POST",
                url: "/loginProc",
                cache: false,
                data: {
                    STUDENT_ID: $("#studentId").val()
                },
                datatype: "JSON",
                success: function (obj) {
                    //alert("obj="+JSON.stringify(obj));
                    fnLoginSuccess();
                },
                error: function (xhr, status, error) {
                    console.log("ERROR!!!");
                },
                complete : function (xhr, status, error) {
                    console.log("complete!!!");
                }
            });
        }
    
        function fnLoginSuccess() {
        	location.href = "/enrolmentList"; 
       }
       
        $(document).ready(function () {
            $("#fnLoginBtn").click(function(){
            	fnLogin();
            });
        });
    </script>
</body>
</html>
