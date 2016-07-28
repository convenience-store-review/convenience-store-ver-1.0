<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="../include/header.jsp" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style type="text/css">
	#replyButton {
		float:right;
	}
	
	#wrapper_grade {
		float:left;
		width:140px;
		overflow:hidden;
	}
	#www {
		width:600px;
		text-align:center;
		position:relative;
		overflow:hidden;
		
	}
</style>



<form role="form" method="post">
	<input type='hidden' name="id" value="${collaboReview.id}">
	<input type='hidden' name="grade_id" value="${collaboReview.grade.id}">
</form> 


<h1>Collabo Review 상세보기</h1>




<section class="content">
	<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">Collabo Review</h3>
				</div>
				<div class="box-body">
					<table class="table table-bordered">
						<tr>
							<th>id</th>
							<th>title</th>
							<th>email</th>
							<th>user.nickname</th>
							<th>total_price</th>
							<th>like_count</th>
							<th>grade_total_count</th>
							<th>view_count</th>
							<th>regdate</th>
							<th>updatedate</th>
						</tr>

						<tr>
							<td>${collaboReview.id}</td>
							<td>${collaboReview.title}</td>
							<td>${collaboReview.user.email}</td>
							<td>${collaboReview.user.nickname}</td>
							<td>${collaboReview.total_price}</td>
							<td>${collaboReview.like_count}</td>
							<td>${collaboReview.grade_total_count}</td>
							<td>${collaboReview.view_count}</td>
							<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
									value="${collaboReview.regdate}" /></td>
							<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
									value="${collaboReview.updatedate}" /></td>
						</tr>
					
					</table>
					<br>
					<br>
					
					<table class="table table-bordered">
						<tr>
							<th>맛</th>
							<th>가성비</th>
							<th>칼로리</th>
						</tr>

						<tr>
							<td>${collaboReview.grade.taste}</td>
							<td>${collaboReview.grade.cost_ratio}</td>
							<td>${collaboReview.grade.calory}</td>
						</tr>

					</table>
					
					<br>
					<br>
					
					<div id="carousel-example-generic" class="carousel slide" data-ride="carousel" data-interval="false">
  					<!-- Indicators -->
					  <ol class="carousel-indicators">
					    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
					    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
					    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
					  </ol>
					
					  <!-- Wrapper for slides -->
					  <div class="carousel-inner" role="listbox">
					   	<div class="item active">
					   		<img width="100px" height="100px" src="/resources/img/IMG_0001.jpg">
					   	</div>
					   	<div class="item">
					   		<img width="100px" height="100px" src="/resources/img/IMG_0002.jpg">
					   	</div>
					   
						
						<c:forEach items="${photolist}" var="attachPhoto">
						<div class="item">
					      <img width="200px" height = "100px" src="${attachPhoto.attach_photo_fullname}">
					    </div>							
					   	</c:forEach>
					    
						
					  </div>
					
					  <!-- Controls -->
					  <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
					    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					    <span class="sr-only">Previous</span>
					  </a>
					  <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
					    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					    <span class="sr-only">Next</span>
					  </a>
					</div>
					
					<br>
					<br>
					<table class="table table-bordered">
						<tr>
							<th>recipe</th>
							<th>tips</th>
							<th>ispenalty</th>
						</tr>

						<tr>
							<td>${collaboReview.recipe}</td>
							<td>${collaboReview.tips}</td>
							<td>${collaboReview.ispenalty}</td>
						</tr>

					</table>
					
					
				</div>
				<!-- /.box-body -->
</div>

<button type="button" id="replyAddBtn" class="btn btn-primary">ADD REPLY</button>



<div class="box-footer">
	<button type="submit" class="btn btn-warning">Modify</button>
	<button type="submit" class="btn btn-danger">Remove</button>
	<button type="submit" id= 'goListall' class="btn btn-primary">List ALL</button>
</div>







<table id="replies" class="table table-bordered">
	

</table>



	<!-- <ul id="replies1">
	</ul> -->
	
	<ul class='pagination'>
	</ul>	



<!-- 
<div id="addReplyModal" class="modal modal-primary" role="dialog">
  <div class="modal-dialog">
    Modal content
    <div class="modal-content">
    
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">로그인유저 닉네임</h4>
      </div>
      
      <div class="modal-body">
        <label for="exampleInputEmail1">추천이유</label>
        <p><textarea name='content1' id='content1' placeholder='추천이유!'></textarea></p>
        
        <label for="exampleInputEmail1">아쉬운점</label>
        <p><textarea name='content2' id='content2' placeholder='아쉬운점!'></textarea></p>
        
        <label for="exampleInputEmail1">하고싶은말!</label>
        <p><textarea name='content3' id='content3' placeholder='하고싶은말!'></textarea></p>
      </div>
      
      <div class="modal-footer">
        <button type="submit" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
      
    </div>
  </div>
</div> -->


<div class="modal fade bs-example-modal-lg" id="addReplyModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="exampleModalLabel">New message</h4>
      </div>
      <div class="modal-body">
        <form>
          <div class="form-group">
            <label for="recipient-name" class="control-label">Recipient:</label>
            <input type="text" class="form-control" id="recipient-name">
          </div>
          <div id="www">
          	<div id="wrapper_grade" class="form-group"><input type="text"  name='taste' class="form-control" placeholder="taste"></div>
          	<div id="wrapper_grade" class="form-group"><input type="text"  name='cost_ratio' class="form-control" placeholder="ratio"></div>
          	<div id="wrapper_grade" class="form-group"><input type="text"  name='calory' class="form-control" placeholder="calory"></div>
          	<div id="wrapper_grade" class="form-group"><input type="text"  name='total' readonly="true" class="form-control" placeholder="total"></div>
		</div>
		<br>
          <div class="form-group">
            <label for="message-text" class="control-label">추천이유</label>
            <textarea class="form-control" id="content1"></textarea>
          </div>
          <div class="form-group">
            <label for="message-text" class="control-label">아쉬운점</label>
            <textarea class="form-control" id="content2"></textarea>
          </div>
          <div class="form-group">
            <label for="message-text" class="control-label">하고싶은말</label>
            <textarea class="form-control" id="content3"></textarea>
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Send message</button>
      </div>
    </div>
  </div>
</div>







</section>

<script>
		var c_id = ${collaboReview.id};
		
		getPageList(1);
		//getPageList때문에 getAllList의 로그

		function getPageList(page){
			
			 // 아래 c_id에 id를 가져와야 하는데 . 위에 html코드에서 스크립트로 어떻게 이동하지?? 그냥 변수 쓰면된다.
		  $.getJSON("/collabo/replies/"+c_id+"/"+page , function(data){
			  
			  console.log(data.list.length);
			  
			  var str ="";
			  $(data.list).each(function(){
				  if(this.user.photo==null) {
					  this.user.photo="/resources/img/IMG-0009.JPG";
				  }
				  str+=  
				  "<tr data-id='"+this.id+"' class='replyLi'>"
				  	+"<td>"
				  		+"<div class="+"thumbnail"+">"
						  +"<img width="+ "100px" + " height=" + "100px" + " src=" + this.user.photo + " class=" + "img-circle" + ">"
						  +"<td>"
						  + "<div id = 'replyButton' class='btn-group'>"
							+  "<button type='button' class='btn btn-default dropdown-toggle' data-toggle='dropdown' aria-label='Right Align' aria-expanded='false'>"
								+   "<span class='glyphicon glyphicon-align-justify' aria-hidden='true'></span>"
							+  "</button>"
						  	+ "<ul class='dropdown-menu' role='menu'>"
						    	+ "<li><a href='#'>Modify</a></li>"
						    	+ "<li><a href='#'>Remove</a></li>"
						    	+ "<li class='divider'></li>"
						    	+ "<li>" + this.user.email + "</li>"
						  	+ "</ul>"
						 + "</div>"
						  
						  +"<div class="+"caption"+">"
						  	+ "<h4>" +this.user.email+" , "+ this.user.nickname + "</h4>"
						  	+ "<p>" + "1.total : "+this.grade.total + " 2.taste : "+ this.grade.taste + "  3.cost_ratio : "+ this.grade.cost_ratio + " 4.calory :" + this.grade.calory + "</p>"
						  	+ "<p>" + "1.추천이유 : "+this.content1 + "  2.아쉬운점 : "+ this.content2 + "  3.하고싶은말 : "+ this.content3 + "</p>"
						 +"</div>"
						 +"</td>"
						+"</div>"
						+  "</td>"
					+"</tr>";
			  });
			  
			  
			  
			  /* $(data.list).each(function(){
				  str+=  
				  "<div class="+"row"+">"
				  	+"<div class="+"col-sm-8 col-md-3"+">"
				  		+"<li data-id='"+this.id+"' class='replyLi'>"
				  		+"<div class="+"thumbnail"+">"
						  +"<img width="+ "100px" + " height=" + "100px" + " src=" + this.user.photo + " class=" + "img-circle" + ">"
						  +"<div class="+"caption"+">"
						  	+ "<h4>" +this.user.email+" , "+ this.user.nickname + "</h4>"  
						  	+ "<p>" + this.content1 + " : "+ this.content2 + " : "+ this.content3 + "</p>"
						 +"</div>"
						+"</div>"
						+  "</li>"
					+"</div>"
				+ "</div>";
			  }); */
			  
			  
			  $("#replies").html(str);
			  
			  printPaging(data.pageMaker);
			  
		  });
	  }		
		
		  
		function printPaging(pageMaker){
			
			var str = "";
			
			if(pageMaker.prev){
				str += "<li><a href='"+(pageMaker.startPage-1)+"'> << </a></li>";
			}
			
			for(var i=pageMaker.startPage, len = pageMaker.endPage; i <= len; i++){				
					var strClass= pageMaker.cri.page == i?'class=active':'';
				  str += "<li "+strClass+"><a href='"+i+"'>"+i+"</a></li>";
			}
			
			if(pageMaker.next){
				str += "<li><a href='"+(pageMaker.endPage + 1)+"'> >> </a></li>";
			}
			$('.pagination').html(str);				
		}
		
		var replyPage = 1;
		
		$(".pagination").on("click", "li a", function(event){
			
			//a href의 기본동작인 페이지 전환을 막는 역할을 한다.
			event.preventDefault();
			
			replyPage = $(this).attr("href");
			
			getPageList(replyPage);
			
		});
		
	</script>
	
	<!-- 수정, 삭제 , 리스트 버튼 관련 스크립트 -->
	<script>
		$(document).ready(function() {
			var formObj = $("form[role='form']");
			console.log(formObj);
			
			$("#replyAddBtn").on("click", function() {
				console.log("모달토글!");
				$("#addReplyModal").modal('toggle');
			});
			
			$(".btn-warning").on("click", function() {
				formObj.attr("action", "/collabo/modify");
				formObj.attr("method", "get");
				formObj.submit();
			});
			
			$(".btn-danger").on("click", function() {
				if(confirm("정말 삭제할꺼야??")==true) {
					formObj.attr("action", "/collabo/remove");
					formObj.submit();	
				} else {
					return;
				}
				
			});
			
			$("#goListall").on("click", function() {
				console.log("리스트올로가자!!");
				self.location = "/collabo/listall";
			});
			
		});
	</script>
	
	<!-- <script>
	$("#replyAddBtn").on("click",function(){
		
		 
		 var replyerObj = $("#newReplyWriter");
		 var replytextObj = $("#newReplyText");
		 var replyer = replyerObj.val();
		 var replytext = replytextObj.val();
		
		  
		  $.ajax({
				type:'post',
				url:'/replies/',
				headers: { 
				      "Content-Type": "application/json",
				      "X-HTTP-Method-Override": "POST" },
				dataType:'text',
				data: JSON.stringify({bno:bno, replyer:replyer, replytext:replytext}),
				success:function(result){
					console.log("result: " + result);
					if(result == 'SUCCESS'){
						alert("등록 되었습니다.");
						replyPage = 1;
						getPage("/replies/"+bno+"/"+replyPage );
						replyerObj.val("");
						replytextObj.val("");
					}
			}});
	});
	</script>
 -->




<%@ include file="../include/footer.jsp" %>