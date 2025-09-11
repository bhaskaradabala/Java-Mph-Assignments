<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Customer List</title>
    <link href="<c:url value='/resources/css/bootstrap.min.css'/>" rel="stylesheet">
    <script src="<c:url value='/resources/js/jquery-1.11.1.min.js'/>"></script>
    <script src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>
</head>
<body>
    <div class="container">
        <h2>Customer List</h2>
        <a href="<c:url value='/customer/add'/>" class="btn btn-primary">Add New Customer</a>
        <table class="table table-bordered table-striped">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Contact No</th>
                    <th>Date of Birth</th>
                    <th>Login Email</th>
                    <th>Addresses</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="customer" items="${customers}">
                    <tr>
                        <td>${customer.userId}</td>
                        <td>${customer.name}</td>
                        <td>${customer.email}</td>
                        <td>${customer.contactNo}</td>
                        <td>${customer.dob}</td>
                        <td>${customer.login.email}</td>
                        <td>
                            <ul>
                                <c:forEach var="address" items="${customer.addrList}">
                                    <li>${address.doorNo}, ${address.street}, ${address.area}, ${address.city}, ${address.state} - ${address.pincode}</li>
                                </c:forEach>
                            </ul>
                        </td>
                        <td>
                            <a href="<c:url value='/customer/edit/${customer.userId}'/>" class="btn btn-warning">Edit</a>
                            <a href="<c:url value='/customer/delete/${customer.userId}'/>" class="btn btn-danger" onclick="return confirm('Are you sure you want to delete this customer?');">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
