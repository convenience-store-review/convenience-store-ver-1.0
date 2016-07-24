<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="../include/header.jsp" %>

<%-- <form role="form" method="post">
	<input type='hidden' name="id" value="${collaboReview.id}">
	<input type='hidden' name="grade_id" value="${collaboReview.grade.id}">
</form> --%>


<h1>Register Page</h1>

<form role="form" method="post">
	<div class="box-body">
			<label>자동으로 입력되어야 하는 것들 (ID,EMAIL ... 등등) 기본 : user.id=9</label>
			<table class="table table-bordered">
				<tr>
					<th>Photo</th>
					<th>E-mail</th>
					<th>Nickname</th>
				</tr>
				<tr>
					<td><img width="100px" height = "100px" src="${pageContext.request.contextPath}${user.photo}"></td>
					<td>${user.email}</td>
					<td>${user.nickname}</td>
				</tr>
			</table>
			<br>
			<br>
			
			<div class="form-group">
						<label>Title</label>
						<input type="text" name='title' class="form-control" placeholder="title">
					</div>
					<div class="form-group">
						<label>Total_price</label>
						<input type="text" name='total_price' class="form-control" placeholder="total_price">
					</div>
					<div class="form-group">
						<label>Recipe</label>
						<textarea name='recipe' class="form-control" placeholder="recipe"></textarea>
					</div>
					<div class="form-group">
						<label>Tips</label>
						<textarea name='tips' class="form-control" placeholder="tips"></textarea>
					</div>
			
			
			
			<br>
			<br>
			<table class="table table-bordered">
				<tr>
					<th>맛</th>
					<th>가성비</th>
					<th>칼로리</th>
					<th>total</th>
				</tr>

				<tr>
					<div class="form-group"><td><input type="text"  name='taste' class="form-control" placeholder="taste"></td></div>
					<div class="form-group"><td><input type="text"  name='cost_ratio' class="form-control" placeholder="ratio"></td></div>
					<div class="form-group"><td><input type="text"  name='calory' class="form-control" placeholder="calory"></td></div>
					<div class="form-group"><td><input type="text"  name='total' readonly="true" class="form-control" placeholder="total"></td></div>
											
				</tr>

			</table>
	
	</div> 
	<!-- box body 끝 -->
	
	<div class="box-footer">
		<button type="submit" class="btn btn-primary">Submit</button>
	</div>
	
	
</form>
<script type="text/javascript">
				$("input").on("input", function() {
					var taste = document.getElementsByName("taste")[0].value;
					var cost_ratio = document.getElementsByName("cost_ratio")[0].value;
					var calory = document.getElementsByName("calory")[0].value;
					
					var total = document.getElementsByName("total")[0];
					
					taste = Number(taste);
					cost_ratio = Number(cost_ratio);
					calory = Number(calory);
					
					//나중에 고쳐야함.
					total.value = ((taste + cost_ratio + calory) / 3).toFixed(1);

				});
				
	</script>

<script type="text/javascript">
	$(document).ready(function() {
		var formObj = $("form[role='form']");
		console.log(formObj);  //출력 안된다!!!!?????
		
		$(".btn-primary").on("click", function() {
			self.location = "/collabo/listall";
		});
	});
</script> 

x





<%@ include file="../include/footer.jsp" %>