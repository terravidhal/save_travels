<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Show Details travels : <c:out value="${travel.expense}"/></title>
        <!-- for Bootstrap CSS -->
        <link rel="stylesheet" type="text/css" href="/webjars/bootstrap/css/bootstrap.min.css"/> 
        <!-- YOUR own local CSS -->
        <link rel="stylesheet" href="/css/style.css"/>
    </head>
<body>
    
    <div class="container-fluid fs-2 ml-200"> 
        <h1 class="text-primary ml-30" style="padding-top: 100px;">
            <c:out value="${travel.expense}"/> Details :
        </h1>
		<ul>
			<li><span class="bold">Expense Name :</span> <c:out value="${travel.expense}"/></li>
			<li><span class="bold">Vendor :</span> <c:out value="${travel.vendor}"/></li>
			<li><span class="bold">Amount :</span> <c:out value="${travel.amount}"/></li>
			<li><span class="bold">Description :</span> <c:out value="${travel.description}"/></li> 
		</ul>
        <div class="back ml-30">
            <a href="/travels">Back to All travels</a>
        </div>
    </div>  
  
  <!-- link Js -->
  <script type="text/javascript" src="/js/main.js"></script> 
  <!-- For any Bootstrap that uses jquery -->
  <script src="/webjars/jquery/jquery.min.js"></script> 
  <!--For any Bootstrap that uses JS -->
  <script src="/webjars/bootstrap/js/bootstrap.min.js"></script> 
</body>
</html>
