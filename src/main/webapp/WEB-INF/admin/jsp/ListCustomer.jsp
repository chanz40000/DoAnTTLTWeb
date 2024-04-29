<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="description" content="Ogani Template">
    <meta name="keywords" content="Ogani, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Ogani | Template</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="src/main/webapp/css/bootstrap.min.css">
    <link rel="stylesheet" href="src/main/webapp/css/font-awesome.min.css">
    <link rel="stylesheet" href="src/main/webapp/css/jquery-ui.min.css">
    <link rel="stylesheet" href="src/main/webapp/css/nice-select.css">
    <link rel="stylesheet" href="src/main/webapp/css/owl.carousel.min.css">
    <link rel="stylesheet" href="src/main/webapp/css/slicknav.min.css">
    <link rel="stylesheet" href="src/main/webapp/css/style.css">
    <link rel="stylesheet" href="src/main/webapp/css/styleforbankaccount.css">

    <link rel="stylesheet" href="https://cdn.datatables.net/2.0.5/css/dataTables.bootstrap5.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.0/css/bootstrap.min.css">
</head>
<body>
<table id="example" class="table table-striped" style="width:100%">

    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Username</th>
        <th>Password</th>
        <th>Email</th>
        <th>Gender</th>
        <th>chuc nang</th>

    </tr>
    <jsp:useBean id="customerDao" class="Test.CustomerDAO"/>
    <c:forEach var="customer" items="${customerDao.selectAll()}">
        <tr>
            <td id="id_customer">${customer.id}</td>
            <td>${customer.name}</td>
            <td>${customer.username}</td>
            <td>${customer.email}</td>
            <td>${customer.password}</td>
            <td>${customer.gender}</td>
            <td>
                <button onclick="deleteItem(event)"> xoa</button>
            </td>
        </tr>

    </c:forEach>
</table>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
    function deleteItem(event){
        var row = event.target.closest('tr');
        if (!row) return;
        var id_cus=row.querySelector('td[id="id_customer"]').textContent;
        var confirmation = confirm("ban co chac muon xoa khong");
        if(confirmation){
            $.ajax({
               url: "/deleteCustomer",
               type:"get",
                data:{id: id_cus},
            //     success: function(response){
            //        console.log("da xoa thanh cong")
            //         row.remove();
            // },
            //     error: function(xhr, status, error) {
            //         // Handle error response
            //         console.error("Failed to delete item", error);
            //     }
                success: function (response) {
                    row.remove();
                    console.log("da xoa thanh cong")
                },
                error: function (xhr, status, error) {
                    console.error("fail", error)
                }
            });
        }

    }
</script>
</body>
</html>
