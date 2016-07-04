<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>

<%@include file="../include/header.jsp" %>

    <!-- Main content -->
    <section class="content">
      <div class="row">
      <!-- left column -->
      <div class="col-md-12">
        <!-- general form elements -->

        <div class="box">
            <div class="box-header with-border">
              <h3 class="box-title">USER HOME PAGE</h3>
            </div>
            <div class="box-body with-border">
                <c:if test="${not empty loginUser}">
                    <p>${loginUser.nickname}님, 환영합니다!!</p>
                </c:if>
                <c:if test="${empty loginUser}">
                    <p>로그인을 하시면 더 많은 서비스를 이용할 수 있습니다.</p>
                    <p>
                        <a href="/user/register">[회원 가입하기]</a>
                        <a href="/user/login">[로그인하기]</a>
                    </p>
                </c:if>
                <p>
                </p>
            </div>
        </div>
      </div><!--/.col (left) -->
      </div>   <!-- /.row -->
    </section><!-- /.content -->

    
<%@include file="../include/footer.jsp" %>
 