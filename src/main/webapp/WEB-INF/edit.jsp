<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!-- New line below to use the JSP Standard Tag Library -->
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!-- New line below to use the JSP Standard Tag Library : Form -->
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <!-- gestion ds erreurs -->
    <%@ page isErrorPage="true" %> 
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>Edit Travels : 
                <c:out value="${travelObj.id}" /></h1>
            </title>
            <!-- for Bootstrap CSS -->
            <link rel="stylesheet" type="text/css" href="/webjars/bootstrap/css/bootstrap.min.css" />
            <!-- YOUR own local CSS -->
            <link rel="stylesheet" href="/css/style.css" />
        </head>

        <body>
            <div class="container-fluid text-center p-5" style="justify-content: center;width: 50%;">
                <h1 class="text-center text-primary" style="padding-top: 100px;">
                    Edit Travels : 
                    <c:out value="${travelObj.id}"/></h1></h1>
               <div class="omikuji border-1">
                        <form:form action="/process_update/travels/${travelObj.id}" method="POST" modelAttribute="travelObj" class="form_this">

                            <input type="hidden" name="_method" value="put"> <!--important !-->

                            <div class="form-group">
                                <form:label path="expense">Expense Name  : </form:label>
                                <form:errors path="expense"/>
                                <form:input class="form-control" path="expense"/>
                            </div>
                            <div class="form-group">
                                <form:label path="vendor">Vendor :</form:label>
                                <form:errors path="vendor"/>
                                <form:input class="form-control"  path="vendor"/> 
                            </div>
                            <div class="form-group">
                                <form:label path="amount">Amount :</form:label>
                                <form:errors path="amount"/>
                                <form:input class="form-control"  type="number" path="amount"/>
                            </div>
                            <div class="form-group">
                                <form:label path="description">Description :</form:label>
                                <form:errors path="description"/>
                                <form:textarea class="form-control" rows="3" path="description"/> 
                            </div>
                            <button type="submit" class="btn btn-primary my-2">Submit</button>
                        </form:form>
                </div> 
                
            </div>
            <div class="back st">
                <a href="/travels">Back to All travels</a>
            </div>

            <!-- link Js -->
            <script type="text/javascript" src="/js/main.js"></script>
            <!-- For any Bootstrap that uses jquery -->
            <script src="/webjars/jquery/jquery.min.js"></script>
            <!--For any Bootstrap that uses JS -->
            <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
        </body>

        </html>