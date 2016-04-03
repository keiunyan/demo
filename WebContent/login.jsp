<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>demo - login</title>

<!--[if lt IE 9]><script src="js/jquery-1.12.2.min.js" type="text/javascript"></script><![endif]-->
<!--[if gte IE 9]><!--><script src="js/jquery-2.2.2.min.js" type="text/javascript"></script><!--<![endif]-->

<script type="text/javascript">
$(document).ready(function(){
	
  $('#userId').blur(function(){
	  if($("#userId").val()==""){
		  $('#info').empty();
	    $('span#userTip').text("请输入用户名");
		  return;		  
	  }
	  $.post("vu",{userId:$("#userId").val()},function(data){
		  $('#info').empty();
		  $('span#userTip').text(data.msg);
	  },"json");
	  
	  /*
    $.ajax({
    	type: "POST",
    	url: "vu",
    	data: {userId:$("#userId").val()},
    	dataType: "json",
    	success: function(data){
    		$('#info').empty();
    		$('span#userTip').text(data.msg); 
    	},
    	error: function (XMLHttpRequest, textStatus, errorThrown) { 
            alert(errorThrown); 
      } 
    });
	  */
  });
  
  $('#loginForm').submit(function(){
	  var p = true;
    if($.trim($("#userId").val())==""){
      $('#userTip').empty();
      $('span#userTip').text("请输入用户名");
      $("#userId").val("600743");
      p = false;     
    }
    if($.trim($("#password").val())==""){
      $('#passTip').empty();
      $('span#passTip').text("请输入密码");
      $("#password").val("600743");
      p = false;     
    }   
    return p;
  });

});
  
</script>

</head>
<body>
  <s:form action="Main" namespace="/" method="post" theme="simple" id="loginForm">
    <p>
      <label>username</label>
      <input type="text" name="userId" id="userId" value="${param.userId }" size="30" />
	    <span id="userTip" style="color:red;"></span>
    </p>
    <p>
      <label>password</label>
      <input type="password" name="password" id="password" size="30" />
      <span id="passTip" style="color:red;"></span>
    </p>
    <p>
      <input type="submit" id="submit" value="login" />
    </p>
  </s:form>
</body>
</html>