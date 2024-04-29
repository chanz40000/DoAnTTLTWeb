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

<div class="container
 align-content-center mt-4">
    <div >
        <form action="register" method="post">
            <div class="mb-3">
                <label class="bg-label-info"> ID: </label>
                <input type="number" id="id" name="id" required="required">
            </div>
            <div class="mb-3">
                <label class="bg-label-info"> Name: </label>
                <input type="text" id="name" name="name" required="required">
            </div>
            <div class="mb-3">
                <label class="bg-label-info"> Username: </label>
                <input type="text" id="username" name="username" required="required">
            </div>
            <div class="mb-3">
                <label class="bg-label-info"> Email: </label>
                <input type="email" id="email" name="email" required="required">
            </div>
            <div class="mb-3">
                <label class="bg-label-info"> Password: </label>
                <input type="text" id="password" name="password" required="required">
            </div>
            <div class="mb-3">
                <label class="bg-label-info"> Gender: </label>
                <div class="col-md-10">
                    <label>Nam</label>
                    <input type="radio" value="nam" name="gender" id="nam" required="required">
                </div>
                <div class="col-md-10">
                    <label>Nu</label>
                    <input type="radio" name="gender" value="nu" id="nu" required="required">
                </div>
                <div class="col-md-10">
                    <label>Khac</label>
                    <input type="radio" name="gender" value="khac" id="khac" required="required">
                </div>

            </div>

            <button class="btn-success" type="submit" >Create</button>



        </form>
    </div>
</div>

<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.nice-select.min.js"></script>
<script src="js/jquery-ui.min.js"></script>
<script src="js/jquery.slicknav.js"></script>
<script src="js/mixitup.min.js"></script>
<script src="js/owl.carousel.min.js"></script>
<script src="js/main.js"></script>




<script
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
<script src="js/google-map.js"></script>
<script src="js/main.js"></script>
</body>
</html>
