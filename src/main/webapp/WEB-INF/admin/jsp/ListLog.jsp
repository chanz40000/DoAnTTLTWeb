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
    <script defer src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
    <script defer src="https://cdn.datatables.net/2.0.8/js/dataTables.js"></script>
    <script defer src="https://cdn.datatables.net/2.0.8/js/dataTables.bootstrap5.js"></script>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.0/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="https://cdn.datatables.net/2.0.8/css/dataTables.bootstrap5.css"/>
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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script type="text/javascript" charset="UTF-8" src="https://cdn.datatables.net/2.0.6/js/dataTables.js"></script>
    <style>
        .INFO {
            width: 200px;
            background-color: lightskyblue;
            padding: 10px 20px;
        }

        .ALERT {
            width: 200px;
            background-color: darkorange;
            padding: 10px 20px;
        }

        .DANGER {
            width: 200px;
            background-color: orangered;
            padding: 10px 20px;
        }

        .WARNING {
            width: auto;
            background-color: peachpuff;
            padding: 10px 20px;
        }
    </style>
</head>
<body>
<table id="log" class="table table-striped" style="width:100%">
    <thead>
    <tr>
        <th>id</th>
        <th>level</th>
        <th>value</th>
        <th>create at</th>
    </tr>
    </thead>
    <jsp:useBean id="logDAO" class="database.LogDAO"/>
    <tbody>
    <c:forEach var="log" items="${logDAO.selectAll()}">
        <tr>
            <td id="id_customer">${log.id}</td>
            <td>
                   <div class="${log.level}">
                           ${log.level}
                   </div></td>
            <td>${log.value}</td>
            <td>${log.createAt}</td>
        </tr>
    </c:forEach>
    </tbody>
    <tfoot>
    <tr>
        <th>id</th>
        <th>level</th>
        <th>value</th>
        <th>create at</th>
    </tr>
    </tfoot>
</table>
<script>
    $(document).ready(function() {
        $('#log').DataTable();
    });
</script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript" charset="UTF-8" src="https://cdn.datatables.net/2.0.6/js/dataTables.js"></script>
</body>
</html>
