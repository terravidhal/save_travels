<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!-- New line below to use the JSP Standard Tag Library -->
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>Show Travels :</title>
            <!-- for Bootstrap CSS -->
            <link rel="stylesheet" type="text/css" href="/webjars/bootstrap/css/bootstrap.min.css" />
            <!-- YOUR own local CSS -->
            <link rel="stylesheet" href="/css/style.css" />
        </head>

        <body>

            <div class="container-fluid">
                <h1 class="text-center text-primary" style="padding-top: 100px;">
                    All Travels</h1>
                <table class="table table-striped border border-5 w-m">
                    <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Expense Name</th>
                            <th scope="col">Vendor</th>
                             <th scope="col">Amount</th>
                             <th scope="col">Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="elt" items="${travels}">
                            <tr>
                                <td>
                                    <c:out value="${elt.id}" />
                                </td>
                                <td>
                                    <a href="/travels/${elt.id}">
                                        <c:out value="${elt.expense}" />
                                    </a>
                                </td>
                                <td>
                                    <c:out value="${elt.vendor}" />
                                </td>
                                <td>
                                    <c:out value="${elt.amount}" />
                                </td>
                                <td>
                                    <a href="/travels/<c:out value="${elt.id}"/>/edit">Edit</a>
                                 </td>
                                <td>
                                    <form action="/travels/<c:out value="${elt.id}"/>/delete" method="POST">
                                          <input type="hidden" name="_method" value="delete"> <!--important, permet de use le 'delete' avc method="POST"-->
                                          <button type="submit" class="btn btn-danger box-shadow pd-0-10 shadow-custom">Delete</button>
                                    </form>
                                 </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table> 
                <div class="create ml-30">
                    <a href="/travel/new">Create New Travel</a>
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