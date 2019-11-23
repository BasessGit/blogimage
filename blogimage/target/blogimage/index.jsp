<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
    <script>
        $(function(){
            $("#but").click(function () {
                $("#div1").html("jquery修改了内容");
            });
        });
    </script>
    <script>
        $(function () {
           $("#submit").click(function () {
              var user =  $("#user").val();
              alert(user);
           });
        });
    </script>
</head>


<body>
<h2>Hello World!</h2>
<div>
<div id="div1">
    会修改的内容修改div内容
</div>
    <input type="button" id="but" value="这是个按钮">
<div>
    <form id="input">
        <input  type="text" name="user" id="user"><input type="submit" value="Submit" id="submit">
    </form>
</div>
</div>
</body>
</html>
