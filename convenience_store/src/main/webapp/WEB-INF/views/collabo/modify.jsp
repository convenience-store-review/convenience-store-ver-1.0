<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="../include/header.jsp" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<h1>Collabo Review 수정하기</h1>
<!-- <script>
	var ch = ${collaboReview.grade.taste};
	$(document).ready(function() {
		console.log("웰컴"); //왜 출력이 안되냐!!!!!!!!!!!????????
	});
</script> -->


<section class="content">
<form role="form" method="post">
	<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">Collabo Review</h3>
				</div>
				<div class="box-body">
					<table class="table table-bordered">
						<tr>
							<th>id</th>
							<th>email</th>
							<th>user.nickname</th>
							<th>like_count</th>
							<th>view_count</th>
							<th>regdate</th>
							<th>updatedate</th>
						</tr>
					<div class="form-group">	
						<tr>
							<td>${collaboReview.id}</td>
							<td>${collaboReview.user.email}</td>
							<td>${collaboReview.user.nickname}</td>
							<td>${collaboReview.like_count}</td>
							<td>${collaboReview.view_count}</td>
							<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
									value="${collaboReview.regdate}" /></td>
							<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
									value="${collaboReview.updatedate}" /></td>
						</tr>
					</div>
					</table>
					<br>
					<br>
					<div class="form-group">
						<label>Title</label>
						<input type="text" name='title' class="form-control" value="${collaboReview.title}">
					</div>
					<div class="form-group">
						<label>Total_price</label>
						<input type="text" name='total_price' class="form-control" value="${collaboReview.total_price}">
					</div>
					<div class="form-group">
						<label>Recipe</label>
						<textarea name='recipe' class="form-control" >${collaboReview.recipe}</textarea>
					</div>
					<div class="form-group">
						<label>Tips</label>
						<textarea name='tips' class="form-control">${collaboReview.tips}</textarea>
					</div>
					
					
					<table class="table table-bordered">
						<tr>
							<th>맛</th>
							<th>가성비</th>
							<th>칼로리</th>
							<th>합계</th>
						</tr>

						<tr>
							<div class="form-group"><td><input type="number" step="0.1" name='grade.taste' class="form-control" value="${collaboReview.grade.taste}"></td></div>
							<div class="form-group"><td><input type="number" step="0.1" name='grade.cost_ratio' class="form-control" value="${collaboReview.grade.cost_ratio}"></td></div>
							<div class="form-group"><td><input type="number" step="0.1" name='grade.calory' class="form-control" value="${collaboReview.grade.calory}"></td></div>
							<div class="form-group"><td><input type="number" readonly="true" name='grade.total' class="form-control" value="${collaboReview.grade.total}"></td></div>
													
						</tr>

					</table>
					
					<br>
					<br>
					
										
					
					
				</div>
				<!-- /.box-body -->
</div>
</form> 

<div class="box-footer">
	<button type="submit" class="btn btn-primary">SAVE</button>
	<button type="submit" class="btn btn-warning">CANCEL</button>
</div>

</section>


<script type="text/javascript">
				$("input").on("input", function() {
					var taste = document.getElementsByName("grade.taste")[0].value;
					var cost_ratio = document.getElementsByName("grade.cost_ratio")[0].value;
					var calory = document.getElementsByName("grade.calory")[0].value;
					
					var total = document.getElementsByName("grade.total")[0];
					
					taste = Number(taste);
					cost_ratio = Number(cost_ratio);
					calory = Number(calory);
					
					//나중에 고쳐야함.
					total.value = ((taste + cost_ratio + calory) / 3).toFixed(1);

				});
				
	</script>




<script>
	$(document).ready(function() {
		var formObj = $("form[role='form']");
		console.log(formObj);  //출력 안된다!!!!?????
		
		$(".btn-warning").on("click", function() {
			self.location = "/collabo/listall";
		});
		
		$(".btn-primary").on("click", function() {
			formObj.submit();
		});
	});
</script>


<%@ include file="../include/footer.jsp" %>