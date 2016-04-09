<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.Date"%>

<div class="pageContent">

	<div class="pageFormContent" layoutH="56">
        <table id="maninf" class="list" layoutH="156">
            <thead>
            <tr>
                <th>Column 1 </th>
                <th>Column 2 </th>
                <th>Column 3 </th>
            </tr>
            </thead>
            <tbody></tbody>
        </table>
		<div>
			<span id="info1" style="color: red"></span> time:<%=new Date().toString() %>
		</div>
        <span id="info2" style="color: red"></span>
        
	</div>
	
	<div class="formBar">
		<ul>
			<li><div class="buttonActive">
					<div class="buttonContent">
						<button type="button" id="ok1">确认1</button>
					</div>
				</div></li>

			<li><div class="button">
					<div class="buttonContent">
						<button type="button" id="ok2">确认2</button>
					</div>
				</div></li>

            <li><div class="button">
                    <div class="buttonContent">
                        <button type="button" id="ok3">确认3</button>
                    </div>
                </div></li>

			<li><div class="button">
					<div class="buttonContent">
						<button type="button" class="close">取消</button>
					</div>
				</div></li>

		</ul>
	</div>

</div>

<script type="text/javascript">
  $(document).ready(function(){
	  $('#ok1').click(function(){
		  $.post("test/Test_t",{"a":"1"},function(data){
			  $("div span#info1").html(
					  "code: "+data.code+"<br/>"+
					  " msg: "+data.msg+"<br/>"+
					  "time: "+data.time+"<br/>"
					  );
	      },"json");
		  
	  });
	  
      $('#ok2').click(function(){
          $.ajax({
        	  url:"test/Test_t2",
        	  type:"post",
        	  data:{"a":"1"},
        	  dataType:"json",
        	  success:function(data){
        		  var html="";
        		  $.each(data, function(idx, item){
        			  html += ("<tr><td>"+item.name + "</td><td>"+item.age+ "</td><td>"+item.hasChild + "</td></tr>");
        		  });
        		  $("div span#info2").html(html);
        		  $("table#maninf>tbody").html(html);
        	  },
        	  error:function(XMLHttpRequest, textStatus, errorThrown){
        		  var html="";
        		  html+=("    XMLHttpRequest.status : " + XMLHttpRequest.status + "<br>" +
        				 "XMLHttpRequest.readyState : " + XMLHttpRequest.readyState + "<br>" +
        				 "               textStatus : " +textStatus 
        		  );
        		  $("div span#info2").html(html);
        	  }
          });
          
      });
      
      $('#ok3').click(function(){
          $.post("test/Test_add",{"user":'{"name":"张{三}","age":22,"hasChild":"1"}'},function(data){
              $("div span#info1").html(
                      "code: "+data.code+"<br/>"+
                      " msg: "+data.msg+"<br/>"+
                      "time: "+data.time+"<br/>"
                      );
          },"json");
          
      });
      
	  
  });
  
</script>