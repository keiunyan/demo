<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="java.util.Date" %>

<div class="pageContent">
	
		<div class="pageFormContent" layoutH="58">
            <div>
                <span id="info" style="color:red"></span>
                time:<%=new Date().toString() %>
            </div>
			
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="button" id="ok">确认</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
			</ul>
		</div>
	
</div>
<table>
  <tr>
    <th>Column 1 Heading</th>
    <th>Column 2 Heading</th>
  </tr>
  <tr>
    <td>Row 1: Col 1</td>
    <td>Row 1: Col 2</td>
  </tr>
</table>

<script type="text/javascript">
  $(document).ready(function(){
	  $('#ok').click(function(){
		  $.post("test/Test_t",{"a":"1"},function(data){
			  $("div span#info").html(
					  "code:"+data.code+"<br/>"+
					  " msg:"+data.msg+"<br/>"+
					  "time:"+data.time+"<br/>"
					  );
	      },"json");
		  
	  });
  });
  
</script>