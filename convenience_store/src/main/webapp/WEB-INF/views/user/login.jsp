<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><spring:message code="login.title" /></title>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <!-- Bootstrap 3.3.4 -->
    <link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <!-- Font Awesome Icons -->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <!-- Theme style -->
    <link href="/resources/dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />
    
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    <style>
        .error {
            color: red; font-weight: bold;
        }
    </style>
</head>
<body class="login-page">
    
    <div class="login-box">
      <div class="login-logo">
        <a href='<c:url value="/user/home" />'>
            <b><spring:message code="common.cvs.review" /></b> <spring:message code="common.service" />
        </a>
      </div><!-- /.login-logo -->
      <div class="login-box-body">
        <p class="login-box-msg"><spring:message code="login.subtitle" /></p>
        
        <div class="loginForm">
            <form:form action="loginPost" commandName="loginDTO">
            <form:errors  cssClass="error" />
                <div class="form-group has-feedback">
                    <form:input path="email" class="form-control" value="user01@test.com" 
                        placeholder="your-mail@mail.com" required="required" />
                    <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
                    <form:errors path="email" cssClass="error"/>
                </div>
                <div class="form-group has-feedback">
                    <form:password path="password" class="form-control" value="user01"
                        placeholder="Password" required="required" />
                    <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                    <form:errors path="password" cssClass="error"/>
                </div>
                <div class="row">
                    <div class="col-xs-8">
                        <div class="ckeckbox icheck">
                          <label>
                              <input type="checkbox" name="useCookie"><spring:message code="login.remember.me" />
                          </label>
                        </div>
                    </div> <!-- /.col -->
                    <div class="col-xs-4">
                        <button type="submit" class="btn btn-primary btn-block btn-flat"><spring:message code="login.btn" /></button>
                    </div> <!-- /.col -->
                </div> <!-- /.row -->
            </form:form>        
        </div> <!-- /.loginForm -->
        
        <a href="#"><spring:message code="login.forgot.password" /></a><br>
        <a href="/user/register" class="text-center"><spring:message code="login.go.register" /></a>

      </div><!-- /.login-box-body -->
    </div><!-- /.login-box -->

    <!-- jQuery 2.1.4 -->
    <script src="/resources/plugins/jQuery/jQuery-2.1.4.min.js"></script>
    <!-- Bootstrap 3.3.2 JS -->
    <script src="/resources/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>