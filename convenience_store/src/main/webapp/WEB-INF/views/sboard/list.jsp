<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 화면</title>
<script type="text/javascript" src="/resources/js/jQuery-2.1.4.min.js"></script>
<script type="text/javascript" src="/resources/js/collabo.js"></script>
<style type="text/css">
/* 
	.collabo{
		display: none;
	} */
</style>
</head>
<body>

	<!-- Main content -->
	<section class="content">
		<div class="row">
			<!-- left column -->


			<div class="col-md-12">
				<!-- general form elements -->
				<div class='box'>
					<div class="box-header with-border">
						<h3 class="box-title">Board List</h3>
					</div>


					<div class='box-body'>

						<select name="searchType" class="selectbox">
							<option value="n"
								<c:out value="${cri.searchType == null?'selected':''}"/>>
								---</option>
							<option value="t"
								<c:out value="${cri.searchType eq 't' ?'selected':''}"/>>
								전체</option>
							<option value="p"
								<c:out value="${cri.searchType eq 'p'?'selected':''}"/>>
								상품명</option>
							<option value="c"
								<c:out value="${cri.searchType eq 'c'?'selected':''}"/>>
								제조사</option>
							<option value="l" class="collaboSel"
								<c:out value="${cri.searchType eq 'l'?'selected':''}"/>>
								콜라보</option>

						</select> 
						<input type="text" name='keyword' id="keywordInput"
							value='${cri.keyword }'>
						<button id='searchBtn'>Search</button>
						<button id='newBtn'>New Board</button>

					</div>
				</div>


				<div class="box">
					<div class="box-header with-border">
						<h3 class="box-title">LIST PAGING</h3>
					</div>
					<div class="box-body">
						<table class="table table-bordered">
							<tr class="product_one">
								<!-- <th style="width: 45px">번호</th> -->
								<!-- <th>번호</th> -->
								<th>상품명</th>
								<th>제조사</th>
								<th>등록일</th>
								<!-- <th style="width: 60px">조회수</th> -->
							</tr>
						
						<h2>상품명</h2>
							<c:forEach items="${list}" var="Product" varStatus="status">
								<c:if test="null"></c:if>
								<tr class="product_one">
									<%-- <td>${status.index + 1}</td> --%>
									<td><a
										href='/sboard/readPage${pageMaker.makeSearch(pageMaker.cri.page)}&id=${Product.id}'>
											${Product.name} </a></td>
									<th>${Product.company}</th>
									<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
											value="${Product.regdate}" /></td>
									<!-- <td><span class="badge bg-red">${boardVO.viewcnt }</span></td> -->
								</tr>

							</c:forEach>

							<tr class="collabo_one">
								<!-- <th style="width: 45px">번호</th> -->
								<th>제목</th>
								<th>아이디</th>
								<th>등록일</th>
								<!-- <th style="width: 60px">조회수</th> -->
							</tr>


							<c:forEach items="${cList}" var="CollaboReview"
								varStatus="status">
								<tr class="collabo_one">
									<%-- <td>${status.index + 1}</td> --%>
									<td><a
										href='/sboard/readPage${pageMaker.makeSearch(pageMaker.cri.page)}&id=${CollaboReview.id}'>
											${CollaboReview.title} </a></td>
									<td>${CollaboReview.user}</td>
									<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
											value="${CollaboReview.regdate}" /></td>
									<!-- <td><span class="badge bg-red">${boardVO.viewcnt }</span></td> -->
								</tr>

							</c:forEach>


							<tr class="product_two">
								<!-- <th style="width: 45px">번호</th> -->
								<th>상품명</th>
								<th>제조사</th>
								<th>등록일</th>
								<!-- <th style="width: 60px">조회수</th> -->
							</tr>


							<c:forEach items="${plist}" var="p" varStatus="status">
								<tr class="product_two">
									<%-- <td>${status.index + 1}</td> --%>
									<td><a
										href='/sboard/readPage${pageMaker.makeSearch(pageMaker.cri.page)}&id=${CollaboReview.id}'>
											${p.name} </a></td>
									<td>${p.company}</td>
									<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
											value="${p.regdate}" /></td>
									<!-- <td><span class="badge bg-red">${boardVO.viewcnt }</span></td> -->
								</tr>

							</c:forEach>


							<tr class="collabo_two">
								<!-- <th style="width: 45px">번호</th> -->
								<th>제목</th>
								<th>가격</th>
								<th>등록일</th>
								<!-- <th style="width: 60px">조회수</th> -->
							</tr>


							<c:forEach items="${clist}" var="c" varStatus="status">
								<tr class="collabo_two">
									<%-- <td>${status.index + 1}</td> --%>
									<td><a
										href='/sboard/readPage${pageMaker.makeSearch(pageMaker.cri.page)}&id=${CollaboReview.id}'>
											${c.title} </a></td>
									<td>${c.total_price}</td>
									<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
											value="${c.regdate}" /></td>
									<!-- <td><span class="badge bg-red">${boardVO.viewcnt }</span></td> -->
								</tr>

							</c:forEach>


							<tr class="user_reivew">
								<!-- <th style="width: 45px">번호</th> -->
								<th>추천이유</th>
								<th>아쉬운점</th>
								<th>더 하고 싶은말</th>
								<th>등록일</th>
								<!-- <th style="width: 60px">조회수</th> -->
								<div class="searchFailed" style="display: none;">
									<p>검색 조건이 없습니다.</p>
								</div>
							</tr>


							<c:forEach items="${ulist}" var="u" varStatus="status">
								<tr class="user_reivew">
									<%-- <td>${status.index + 1}</td> --%>
									<td><a
										href='/sboard/readPage${pageMaker.makeSearch(pageMaker.cri.page)}&id=${CollaboReview.id}'>
											${u.content1} </a></td>
									<td>${u.content2}</td>
									<td>${u.content3}</td>
									<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
											value="${u.regdate}" /></td>
									<!-- <td><span class="badge bg-red">${boardVO.viewcnt }</span></td> -->
								</tr>

							</c:forEach>

						</table>
					</div>
					<!-- /.box-body -->


					<div class="box-footer">

						<div class="text-center">
							<ul class="pagination">

								<c:if test="${pageMaker.prev}">
									<li><a
										href="list${pageMaker.makeSearch(pageMaker.startPage - 1) }">&laquo;</a></li>
								</c:if>

								<c:forEach begin="${pageMaker.startPage }"
									end="${pageMaker.endPage }" var="idx">
									<li
										<c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
										<a href="list${pageMaker.makeSearch(idx)}">${idx}</a>
									</li>
								</c:forEach>

								<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
									<li><a
										href="list${pageMaker.makeSearch(pageMaker.endPage +1) }">&raquo;</a></li>
								</c:if>

							</ul>
						</div>

					</div>
					<!-- /.box-footer-->
				</div>
			</div>
			<!--/.col (left) -->

		</div>
		<!-- /.row -->
	</section>
	<!-- /.content -->
</body>

<script>
	var result = '${msg}';

	if (result == 'SUCCESS') {
		alert("처리가 완료되었습니다.");
	}

	var searchResult = '${failed}';
	if (searchResult == 'searchFailed') {
		$('.searchFailed').css('display', 'block');
	} else {
		$('.searchFailed').css('display', 'none');
	}
</script>

<script>
	$(document).ready(
			function() {

				$('#searchBtn').on(
						"click",
						function(event) {

							self.location = "list"
									+ '${pageMaker.makeQuery(1)}'
									+ "&searchType="
									+ $("select option:selected").val()
									+ "&keyword=" + $('#keywordInput').val();

						});

				$('#newBtn').on("click", function(evt) {

					self.location = "register";

				});
			

			});
</script>

</html>
