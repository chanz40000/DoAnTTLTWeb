<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page isELIgnored="false" %>

<!DOCTYPE html>


<html
        lang="en"
        class="light-style layout-menu-fixed"
        dir="ltr"
        data-theme="theme-default"
        data-assets-path="../assets/"
        data-template="vertical-menu-template-free"
>
<head>
  <meta charset="UTF-8">
  <meta
          name="viewport"
          content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0"
  />

  <title>Tables - Basic Tables | Sneat - Bootstrap 5 HTML Admin Template - Pro</title>

  <meta name="description" content="" />

  <!-- Favicon -->
  <link rel="icon" type="image/x-icon" href="../assetsForAdmin/assets/img/favicon/favicon.ico"/>

  <!-- Fonts -->
  <link rel="preconnect" href="https://fonts.googleapis.com" />
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
  <link
          href="https://fonts.googleapis.com/css2?family=Public+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&display=swap"
          rel="stylesheet"
  />
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
        integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />

  <!-- Icons. Uncomment required icon fonts -->
  <link rel="stylesheet" href="../assetsForAdmin/assets/vendor/fonts/boxicons.css" />

  <!-- Core CSS -->
  <link rel="stylesheet" href="../assetsForAdmin/assets/vendor/css/core.css" class="template-customizer-core-css" />
  <link rel="stylesheet" href="../assetsForAdmin/assets/vendor/css/theme-default.css" class="template-customizer-theme-css" />
  <link rel="stylesheet" href="../assetsForAdmin/assets/css/demo.css" />

  <!-- Vendors CSS -->
  <link rel="stylesheet" href="../assetsForAdmin/assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.css" />

  <!-- Page CSS -->

  <!-- Helpers -->
  <script src="https://kit.fontawesome.com/2b3abce4d1.js" crossorigin="anonymous"></script>
  <%--  <script src="../assetsForAdmin/assets/vendor/js/script.js"></script>--%>
  <script src="../assetsForAdmin/assets/vendor/js/helpers.js"></script>

  <!--! Template customizer & Theme config files MUST be included after core stylesheets and helpers.js in the <head> section -->
  <!--? Config:  Mandatory theme config file contain global vars & default theme options, Set your preferred theme option in this file.  -->
  <script src="../assetsForAdmin/assets/js/config.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>


  <style>
    .hide{
      display: none;
    }
    .table-responsive.text-nowrap {

    }
    #menu-icon{
      margin-left: 110px;

    }
    .bg-menu-theme #menu-icon-toggle{
      background-color: #696cff;
      border: 7px solid #f5f5f9;
      position: absolute;
      top: 28px;
      left: 230px;
      border-radius: 50%;
      z-index: 1;
      display: block !important;
    }
    #menu-icon-toggle i{
      width: 1.5rem;
      height: 1.5rem;
    }
    #menu-icon-toggle::before{
      color:white;
      content: "\ecb0";

    }
    aside#layout-menu.layout-menu.menu-vertical.menu.bg-menu-theme.close{
      width: 100px;
    }
    aside#layout-menu.layout-menu.menu-vertical.menu.bg-menu-theme.close .menu-item div, aside#layout-menu.layout-menu.menu-vertical.menu.bg-menu-theme.close .menu-sub div{
      opacity: 0;

    }
    .bg-menu-theme.close .menu-inner > .menu-item.active > .menu-link {

      /*background-color: rgba(105, 108, 255, 0.16) !important;*/
      /*color: black;*/
    }
    .menu-header-text{
      opacity: 0;
    }
    .bg-menu-theme.close .menu-header:before {
      display: none;
    }
    .bg-menu-theme.close .app-brand-text.demo.menu-text.fw-bolder.ms-2{
      display: none;
    }
    .bg-menu-theme.close{
      text-align: center;
      display: flex;
      justify-content: center;
      flex-direction: column;
    }
    .bg-menu-theme.close #menu-icon-toggle{
      background-color: #696cff;
      border: 7px solid #f5f5f9;
      position: absolute;
      top: 28px;
      left: 70px;
      border-radius: 50%;
      z-index: 1;
      display: block !important;
    }
    .bg-menu-theme.close #menu-icon-toggle{
      transform: rotate(180deg);

    }
  </style>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>

<body>


<!-- Layout wrapper -->
<div class="layout-wrapper layout-content-navbar">
  <div class="layout-container">



    <!-- Menu -->
    <jsp:include page="menu.jsp"/>

    <!-- Layout container -->
    <div class="layout-page">
->

      <div class="content-wrapper">

  <h1>Upload Excel File</h1>
  <form id="uploadForm" enctype="multipart/form-data" method="post">
    <input type="file" name="file" id="fileInput">
    <input type="submit" value="Upload">
  </form>
  <table>
    <thead>
    <tr>
      <th>Product Name</th>
      <th>categoryName</th>
      <th>unitPrice</th>
      <th>price</th>
      <th>product.quantity</th>
    </tr>
    </thead>
    <tbody id="tbody">
    <!-- Dữ liệu sẽ được hiển thị ở đây -->
    <c:forEach var="product" items="${products}">
      <tr>
        <td>${product.product_name}</td>
        <td>${product.unitPrice}</td>
        <td>${product.price}</td>
        <td>${product.quantity}</td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
      </div>

    </div>
    <!-- / Layout page -->
  </div>

  <!-- Overlay -->
  <div class="layout-overlay layout-menu-toggle"></div>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/xlsx/0.18.3/xlsx.full.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/gson/2.8.8/gson.min.js"></script>
<script>
  document.getElementById('fileInput').addEventListener('change', function(event) {
    var file = event.target.files[0];
    var reader = new FileReader();
    reader.onload = function(e) {
      var data = new Uint8Array(e.target.result);
      var workbook = XLSX.read(data, { type: 'array' });
      var sheetName = workbook.SheetNames[0];
      var sheet = workbook.Sheets[sheetName];
      var jsonData = XLSX.utils.sheet_to_json(sheet);

      var productNames = [];
      jsonData.forEach(function(row) {
        productNames.push(row['Product Name']);
      });

      $.ajax({
        url: '/Upload2',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({ productNames: productNames }),
        success: function(response) {
          var tbody = document.getElementById('tbody');
          tbody.innerHTML = '';
          response.forEach(function(product) {
            var tr = document.createElement('tr');
            var tdName = document.createElement('td');
            tdName.textContent = product.product_name;
            var unitPrice = document.createElement('td');
            unitPrice.textContent = product.unitPrice;
            var price = document.createElement('td');
            price.textContent = product.price;
            var quantity = document.createElement('td');
            quantity.textContent = product.quantity;
            tr.appendChild(tdName);
            tr.appendChild(unitPrice);
            tr.appendChild(price);
            tr.appendChild(quantity);
            tbody.appendChild(tr);
          });
        },
        error: function(xhr, status, error) {
          console.error('Error:', error);
        }
      });
    };
    reader.readAsArrayBuffer(file);
  });
</script>
</body>
</html>
