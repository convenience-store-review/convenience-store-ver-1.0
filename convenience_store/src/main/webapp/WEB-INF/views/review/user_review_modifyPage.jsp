<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../include/header.jsp"%>

<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">MODIFY USER_REVIEW</h3>
				</div>
				<!-- /.box-header -->

				<form role="form" action="user_review_modify" method="post">

					<input type='hidden' name='product.id' value ="${userReview.productReview.id}">
					<input type='hidden' name='grade.id' value ="${userReview.grade.id}">
					<input type="hidden" name ='productReview.id' value ="${userReview.productReview.id}">

					<div class="box-body">

						<div class="form-group">
							<label for="exampleInputEmail1">No</label> <input type="text"
								name='id' class="form-control" value="${userReview.id}"
								readonly="readonly">
						</div>

						<div class="form-group">
							<label for="exampleInputEmail1">Taste</label> <input type="text"
								name='taste' class="form-control" value="${userReview.grade.taste}"
								id = "taste">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Cost_ratio</label> <input type="text"
								name='cost_ratio' class="form-control" value="${userReview.grade.cost_ratio}">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Calory</label><input type="text"
								name='calory' class="form-control" value="${userReview.grade.calory}">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Total</label> <input type="text"
								name='total' class="form-control" value="${userReview.grade.total}"
								readonly="readonly">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Content1</label>
							<textarea class="form-control" name="content1" rows="3">${userReview.content1}</textarea>
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Content2</label>
							<textarea class="form-control" name="content2" rows="3">${userReview.content2}</textarea>
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Content3</label>
							<textarea class="form-control" name="content3" rows="3">${userReview.content3}</textarea>
						</div>
					</div>
					<!-- /.box-body -->
				</form>
				<div class="box-footer">
					<button type="submit" class="btn btn-primary">SAVE</button>
					<button type="submit" class="btn btn-warning">CANCEL</button>
				</div>
				
				<script type="text/javascript">
				$("input").on("input", function() {
					var taste = document.getElementsByName("taste")[0].value;
					var cost_ratio = document.getElementsByName("cost_ratio")[0].value;
					var calory = document.getElementsByName("calory")[0].value;
					
					var total = document.getElementsByName("total")[0];
					
					taste = Number(taste);
					cost_ratio = Number(cost_ratio);
					calory = Number(calory);
					
					total.value = ((taste + cost_ratio + calory) / 3).toFixed(1);
				});
				
				</script>

				<script>
				
					$(document)
							.ready(
									function() {

										var formObj = $("form[role='form']");
			
										console.log(formObj);

										$(".btn-warning")
												.on(
														"click",
														function() {
															self.location = "/review/user_review_list?id=${userReview.productReview.id}";
														});

										$(".btn-primary").on("click",
												function() {
													formObj.submit();
												});

									});
				</script>




			</div>
			<!-- /.box -->
		</div>
		<!--/.col (left) -->

	</div>
	<!-- /.row -->
</section>
<!-- /.content -->
</div>
<!-- /.content-wrapper -->

<%@include file="../include/footer.jsp"%>
