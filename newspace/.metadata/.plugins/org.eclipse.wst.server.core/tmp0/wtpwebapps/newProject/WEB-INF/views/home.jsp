<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
	<title>Home</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.form/4.3.0/jquery.form.min.js"></script>
</head>
<body>
    <form id="frm" name="frm" method="post" action="/register/action" enctype="multipart/form-data">
        <input type="file" name="file1"/>
        <button type="button" onclick="fnSumbit()">전송</button>
    </form>
    
    <script>
	    function fnSumbit() {
	    	
	    	var option = {
                //dataType : 'json', //JSON형태로 전달도 가능합니다.
                url: "/register/action",
                type: "POST", 
                success: function(res){
                    alert("success");
                	alert(res); //res Object안에 msg에는 결과 메시지가 담겨있습니다.
                },
                error: function(res){
                    alert("에러가 발생했습니다.")
                }
            }
	    	
	        $("#frm").ajaxSubmit(option);
                       
	    }
		
	 </script> 
</body>
</html>
