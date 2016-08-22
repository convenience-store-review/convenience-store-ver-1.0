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
	
	/* 댓글에서 페이징 1번이랑 다른번들이 크기 차이가 생겨서 일단 고정값으로 만들어놨다. */
	/* 나중에 반응형 작업할때 고정크기 대신 %로 바꿔주는 작업을 해야할 것 같음!*/
	#thumbsize {
		width:183px;
	}
	
/* 	
	#re_modi {
		
	} */
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

<button type="button" id="replyOpenAddBtn" class="btn btn-primary">ADD REPLY</button>



<div class="box-footer">
	<button type="submit" class="btn btn-warning">Modify</button>
	<button type="submit" class="btn btn-danger">Remove</button>
	<button type="submit" id= 'goListall' class="btn btn-primary">List ALL</button>
</div>







<table id="replies" class="table table-bordered">
	

</table>



	<!-- <ul id="replies1">
	</ul> -->
	
	<div class='pagination pagination-small pagination-centered'>
		<ul id='pagination'>
		
		</ul>	
	</div>
	
	
		



<%@ include file="collaboModal.jsp" %>








</section>

<script>
		var c_id = ${collaboReview.id};
		
		getPageList(1);
		//getPageList때문에 getAllList의 로그
		
		
		//하나의 모달로 등록, 수정 같이 사용하기 위해서. 등록은 post로 값을 전달하고
		//수정은 먼저 값을 
		function getModal(rno) {
				console.log("모달토글!");
				$("#modReplyModal").modal('show');
				
				
				var formObj = $("form[role='form2']");
				var test = rno;
				console.log(rno);
				
				
				//수정에서 모달창 팝업했을때 기존 정보가 미리 등록 되어있게 json객체를 가져와 
				//정보를 나타나게 한다.! 
				
				$.getJSON("/collabo/replies/mod/"+rno, function(data) {
					document.getElementById("mod_content1").innerHTML=data.content1;
					document.getElementById("mod_content2").innerHTML=data.content2;
					document.getElementById("mod_content3").innerHTML=data.content3;
					
					document.getElementById("mod_reply_taste").value=data.grade.taste;
					document.getElementById("mod_reply_cost_ratio").value=data.grade.cost_ratio;
					document.getElementById("mod_reply_calory").value=data.grade.calory;
					document.getElementById("mod_reply_total").value=data.grade.total;
					
				});
				
				$("#mod_replyModBtn").on("click",function(){
					 
					var content1Obj = $("#mod_content1");
					var content2Obj = $("#mod_content2");
					var content3Obj = $("#mod_content3");
					var content1 = content1Obj.val();
					var content2 = content2Obj.val();
					var content3 = content3Obj.val();
					 
					 
					var taste = document.getElementsByName("mod_re_taste")[0].value;
					var cost_ratio = document.getElementsByName("mod_re_cost_ratio")[0].value;
					var calory = document.getElementsByName("mod_re_calory")[0].value;
					
					var total = document.getElementsByName("mod_re_total")[0].value;
					 
					console.log("콜라보id"+c_id +content1 + content2 + content3 + taste + cost_ratio + calory + "   total : " + total + "  user_id:"+ user_id);
					 
			 		
					  
					  $.ajax({
							type:'put',
							url:'/collabo/replies/mod/'+rno,
							headers: { 
							      "Content-Type": "application/json",
							      "X-HTTP-Method-Override": "PUT" },
							dataType:'text',
							data: JSON.stringify(
								{content1:content1, content2:content2, content3:content3, grade : {taste:taste, cost_ratio:cost_ratio, calory:calory, total:total}}),
							success:function(result){
								console.log("result: " + result);
								if(result == 'SUCCESS'){
									alert("수정 되었습니다.");
									self.location = "/collabo/read?id="+c_id;
									/* getPage("/collabo/read?id="+c_id); */
								}
						}}); 
					}); 
				
			
			}
		function getRemove(rno) {
			if(confirm("정말 삭제할꺼야??")==true) {
				console.log("삭제할꺼야? 창 출력");
				$.ajax({
					type:'delete',
					url:'/collabo/replies/remove/'+rno,
					headers: { 
					      "Content-Type": "application/json",
					      "X-HTTP-Method-Override": "DELETE" },
					dataType:'text', 
					success:function(result){
						console.log("result: " + result);
						if(result == 'SUCCESS'){
							alert("삭제 되었습니다.");
							self.location = "/collabo/read?id="+c_id;
						}
				}});
				
				
				
				

			} else {
				return;
			}
			
		}

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
				  	+"<td id='thumbsize'>"
				  		+"<div class="+"thumbnail"+">"
						  +"<img width="+ "100px" + " height=" + "100px" + " src=" + this.user.photo + " class=" + "img-circle" + ">"
						+"</div>"	  
					+"</td>"
					+"<td>"
						  + "<div id = 'replyButton' class='btn-group'>"
							+  "<button type='button' class='btn btn-default dropdown-toggle' data-toggle='dropdown' aria-label='Right Align' aria-expanded='false'>"
								+   "<span class='glyphicon glyphicon-align-justify' aria-hidden='true'></span>"
							+  "</button>"
						  	+ "<ul class='dropdown-menu' role='menu'>"
//						  		+ "<form role='form2' method='post'>"
//						  			+"<input type='hidden' name='rno' value='" + this.id + "= '>"
//						    		+ "<li><a data-toggle='modal' href='#addReplyModal'>Modify</a></li>"
								+ "<li><a data-toggle='modal' href='#' onClick='getModal("+ this.id +"); return false;'>Modify</a></li>"
//						    	+ "</form>"
						    	+ "<li><a href='#' onClick='getRemove("+ this.id +"); return false;'>Remove</a></li>"
						    	+ "<li class='divider'></li>"
						    	+ "<li>" + this.user.email + "</li>"
						  	+ "</ul>"
						 + "</div>"
						  
						  +"<div class="+"caption"+">"
						  	+ "Reply Modify TEST - id =" + this.id
						  	+ "<h4>" +this.user.email+" , "+ this.user.nickname + "</h4>"
						  	+ "<p>" + "1.total : "+this.grade.total + " 2.taste : "+ this.grade.taste + "  3.cost_ratio : "+ this.grade.cost_ratio + " 4.calory :" + this.grade.calory + "</p>"
						  	+ "<p>" + "1.추천이유 : "+this.content1 + "  2.아쉬운점 : "+ this.content2 + "  3.하고싶은말 : "+ this.content3 + "</p>"
						 +"</div>"
						 +"</td>"
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
			$('#pagination').html(str);				
		}
		
		var replyPage = 1;
		
		$("#pagination").on("click", "li a", function(event){
			
			//a href의 기본동작인 페이지 전환을 막는 역할을 한다.
			event.preventDefault();
			
			replyPage = $(this).attr("href");
			
			getPageList(replyPage);
			
		});
		
	</script>
	
	<!-- 수정, 삭제 , 리스트 버튼 관련 초기버튼 설정 스크립트 -->
	<script>
		$(document).ready(function() {
			var formObj = $("form[role='form']");
			console.log(formObj);
			
//			document.getElementById("#replyModBtn").style.visibility='hidden';
			
			
			
			$("#replyOpenAddBtn").on("click", function() {
				console.log("모달토글!");
				$("#addReplyModal").modal('show');
				
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
	
	<!--  -->
	<script type="text/javascript">
				$("input").on("input", function() {
					var taste = document.getElementsByName("re_taste")[0].value;
					var cost_ratio = document.getElementsByName("re_cost_ratio")[0].value;
					var calory = document.getElementsByName("re_calory")[0].value;
					
					var total = document.getElementsByName("re_total")[0];
					
					taste = Number(taste);
					cost_ratio = Number(cost_ratio);
					calory = Number(calory);
					
					//나중에 고쳐야함.
					
					total.value = ((taste + cost_ratio + calory) / 3).toFixed(1);
					


				});
				
	</script>
	
	
	
	
<script>
	
</script>
<script>
	var c_id = ${collaboReview.id};
	var user_id=9;
//registerGET!! 댓글등록창에서 유저의 정보를 나타내줄때 사용하는 것! 나중에 유저사진 추가!!
	//$.getJSON("/collabo/replies/"+user_id , function(data){
	  $.getJSON("/collabo/replies/9" , function(data){
		  
		  console.log(data.nickname);
		  var nickname = data.nickname+"님이 글을 작성하십니다.";
		  document.getElementById("reply_register_nick").innerHTML=nickname;
		
	  });
	  
	  $("#replyAddBtn").on("click",function(){
			 
			var content1Obj = $("#content1");
			var content2Obj = $("#content2");
			var content3Obj = $("#content3");
			var content1 = content1Obj.val();
			var content2 = content2Obj.val();
			var content3 = content3Obj.val();
			 
			 
			var taste = document.getElementsByName("re_taste")[0].value;
			var cost_ratio = document.getElementsByName("re_cost_ratio")[0].value;
			var calory = document.getElementsByName("re_calory")[0].value;
			
			var total = document.getElementsByName("re_total")[0].value;
			 
			console.log("콜라보id"+c_id +content1 + content2 + content3 + taste + cost_ratio + calory + "   total : " + total + "  user_id:"+ user_id);
			 
	 		
			  
			  $.ajax({
					type:'post',
					url:'/collabo/replies/regi',
					headers: { 
					      "Content-Type": "application/json",
					      "X-HTTP-Method-Override": "POST" },
					dataType:'text',
					data: JSON.stringify(
						{collaboReview : {id : c_id}, content1:content1, content2:content2, content3:content3, grade : {taste:taste, cost_ratio:cost_ratio, calory:calory, total:total}}),
					success:function(result){
						console.log("result: " + result);
						if(result == 'SUCCESS'){
							alert("등록 되었습니다.");
							self.location = "/collabo/read?id="+c_id;
							/* getPage("/collabo/read?id="+c_id); */
						}
				}}); 
			}); 

	  
		
	</script>



<%@ include file="../include/footer.jsp" %>