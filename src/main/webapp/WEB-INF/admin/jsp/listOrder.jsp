<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page isELIgnored="false" %>
<%@ page import="util.FormatCurrency"%>
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
    <meta charset="utf-8" />
    <meta
            name="viewport"
            content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0"
    />

    <title>Tables - Basic Tables | Sneat - Bootstrap 5 HTML Admin Template - Pro</title>

    <meta name="description" content="" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/2.0.7/css/dataTables.bootstrap5.css">
    <script defer src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
    <script defer src="https://cdn.datatables.net/2.0.7/js/dataTables.js"></script>
    <script defer src="https://cdn.datatables.net/2.0.7/js/dataTables.bootstrap5.js"></script>
    <!-- Favicon -->

    <link rel="icon" type="image/x-icon" href="../assetsForAdmin/assets/img/favicon/favicon.ico" />

    <!-- Fonts -->

    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
            href="https://fonts.googleapis.com/css2?family=Public+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&display=swap"
            rel="stylesheet"
    />


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
    <script src="../assetsForAdmin/assets/vendor/js/helpers.js"></script>

    <script src="../assetsForAdmin/assets/js/config.js"></script>
    <link rel="stylesheet" href="https://cdn.datatables.net/2.0.5/css/dataTables.bootstrap5.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.0/css/bootstrap.min.css">
    <link href="/css/style.css" media="screen" rel="stylesheet">
    <script type="text/javascript" src="/js/Chart.min.js"></script>
</head>
<style>
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
    /*.bg-menu-theme.close .align-items-center.bg-navbar-theme{*/
    /*  padding-left: 100px;*/
    /*}*/
    .layout-navbar.container-xxl.navbar.navbar-expand-xl.navbar-detached.align-items-center.bg-navbar-theme.close{
        width:1212px;
        margin-left: -125px;
    }

    .content-wrapper.close{
        margin-left: -151px;
        width: 1263px;
    }
    /*.container-xxl.flex-grow-1.container-p-y .row.close .card-body{*/
    /*  !*margin-left: -10px;*!*/
    /*  !*width: 500px;*!*/
    /*}*/
    .fa-regular.fa-sun{
        font-size: 20px;

    }
    .fa-regular.fa-moon{
        font-size: 20px;

    }
    /*#content-wrapper{*/
    /*    width: 100%;*/
    /*}*/
.card{
    width: 100%;
}

</style>
<body>

<!-- Layout wrapper -->
<div class="layout-wrapper layout-content-navbar">
    <div class="layout-container">
        <!-- Menu -->
        <jsp:include page="menu.jsp"/>

        <!-- / Menu -->

        <!-- Layout container -->
        <div class="layout-page">
            <!-- Navbar -->
            <jsp:include page="navbar.jsp"/>
            <!-- / Navbar -->
            <!-- Content wrapper -->
            <div class="content-wrapper" id="content-wrapper">
                <!-- Content -->

                <div class="container-xxl flex-grow-1 container-p-y" id="content-big-section">
                    <h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light">Đơn hàng /</span> Danh sách đơn hàng</h4>

                    <!-- Basic Bootstrap Table -->
                    <div class="card">
                        <jsp:useBean id="orderDAO" class="database.OrderDAO"/>
                        <jsp:useBean id="orderHistoryDAO" class="database.OrderHistoryDAO"/>
                        <div class="col-xl-12">
                            <div class="nav-align-top mb-4">
                                <ul class="nav nav-tabs nav-fill" role="tablist">
                                    <li class="nav-item">
                                        <button
                                                type="button"
                                                class="nav-link active"
                                                role="tab"
                                                data-bs-toggle="tab"
                                                data-bs-target="#navs-justified-home"
                                                aria-controls="navs-justified-home"
                                                aria-selected="true"
                                        >
                                            <i class="tf-icons bx bx-home"></i> Cần xác nhận
                                            <span class="badge rounded-pill badge-center h-px-20 w-px-20 bg-label-danger">3</span>
                                        </button>
                                    </li>
                                    <li class="nav-item">
                                        <button
                                                type="button"
                                                class="nav-link"
                                                role="tab"
                                                data-bs-toggle="tab"
                                                data-bs-target="#navs-justified-profile"
                                                aria-controls="navs-justified-profile"
                                                aria-selected="false"
                                        >
                                            <i class="tf-icons bx bx-user"></i> Giao thành công
                                        </button>
                                    </li>
                                    <li class="nav-item">
                                        <button
                                                type="button"
                                                class="nav-link"
                                                role="tab"
                                                data-bs-toggle="tab"
                                                data-bs-target="#navs-justified-messages"
                                                aria-controls="navs-justified-messages"
                                                aria-selected="false"
                                        >
                                            <i class="tf-icons bx bx-message-square"></i> Hủy/Hoàn
                                        </button>
                                    </li>
                                </ul>
                                <div class="tab-content">
                                    <div class="tab-pane fade show active" id="navs-justified-home" role="tabpanel">
                                        <h5 class="card-header">Danh sách đơn hàng cần xác nhận </h5>
                                        <div class="table-responsive text-nowrap">
                                            <table id="example" class="table table-striped" style="width:100%">
                                                <thead>
                                                <tr>
                                                    <th>ID</th>
                                                    <th>Mã User</th>
                                                    <th>Ngày đặt</th>
                                                    <th>Trạng thái</th>
                                                    <th>Actions</th>
                                                    <th>Người sửa</th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                <c:set var="ChoXacNhan" value="1"/>
                                                <c:set var="DangDongGoi" value="2"/>
                                                <c:set var="DangGiao" value="3"/>
                                                <c:set var="YeuCauHuy" value="5"/>
                                                <c:set var="YeuCauTraHang" value="7"/>
                                                <c:forEach var="order" items="${orderDAO.selectByStatusIds(ChoXacNhan, DangDongGoi, YeuCauHuy, YeuCauTraHang, DangGiao)}">
                                                    <tr>
                                                        <td><i class="fab fa-angular fa-lg text-danger me-3"></i> <strong>${order.orderId}</strong></td>
                                                        <td>${order.user.userId}</td>
                                                        <td>${order.bookingDate}</td>
                                                        <td><span class="badge bg-label-primary me-1 order-status">${order.status.statusName}</span></td>
                                                        <td>
                                                            <c:if test="${order.status.statusId == 1}">
                                                                <button class="badge bg-success me-1 change-status" data-orderid="${order.orderId}" data-action="AcceptOrder">Xác nhận</button>
                                                                <button class="badge bg-danger me-1 change-status" data-orderid="${order.orderId}" data-action="RejectOrder">Hủy</button>
                                                            </c:if>
                                                            <c:if test="${order.status.statusId == 2}">
                                                                <button class="badge bg-success me-1 change-status" data-orderid="${order.orderId}" data-action="Packed">Xong</button>
                                                            </c:if>
                                                            <c:if test="${order.status.statusId == 5}">
                                                                <button class="badge bg-success me-1 change-status" data-orderid="${order.orderId}" data-action="Cancel">Chấp nhận</button>
                                                                <button class="badge bg-danger me-1 change-status" data-orderid="${order.orderId}" data-action="RejectCancelOrder">Từ chối</button>
                                                            </c:if>
                                                            <c:if test="${order.status.statusId == 7}">
                                                                <button class="badge bg-success me-1 change-status" data-orderid="${order.orderId}" data-action="AcceptReturnOrder">Chấp nhận</button>
                                                                <button class="badge bg-danger me-1 change-status" data-orderid="${order.orderId}" data-action="RejectReturnOrder">Từ chối</button>
                                                            </c:if>
                                                        </td>
                                                        <td>
                                                            <c:set var="latestHistory" value="${orderHistoryDAO.selectLatestByOrderId(order.orderId)}"/>
                                                            <c:if test="${latestHistory ne null}">
                                                                <c:if test="${not empty latestHistory.user}">
                                                                    <c:choose>
                                                                        <c:when test="${latestHistory.user.role == 2}">
                                                                            ID User: ${latestHistory.user.userId}
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            ID Admin: ${latestHistory.user.userId}
                                                                        </c:otherwise>
                                                                    </c:choose>
                                                                </c:if>
                                                            </c:if>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                                </tbody>
                                                <tfoot>
                                                <tr>
                                                    <th>ID</th>
                                                    <th>Mã User</th>
                                                    <th>Ngày đặt</th>
                                                    <th>Trạng thái</th>
                                                    <th>Actions</th>
                                                    <th>Người sửa</th>
                                                </tr>
                                                </tfoot>
                                            </table>
                                        </div>
                                    </div>
                                    <div class="tab-pane fade" id="navs-justified-profile" role="tabpanel">
                                        <h5 class="card-header">Danh sách đơn hàng giao thành công  </h5>
                                        <div class="table-responsive text-nowrap">
                                            <table id="example1" class="table table-striped" style="width:100%">

                                                <thead>
                                                <tr>
                                                    <th>ID</th>
                                                    <th>Mã User</th>
                                                    <th>Ngày đặt</th>
                                                    <th>Trạng thái</th>
                                                    <th>Người sửa</th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                <c:set var="GiaoThanhCong" value="4"/>
                                                <c:set var="DaNhan" value="10"/>
                                                <%--                                <c:forEach var="order" items="${orderDAO.selectOrderByStatus(1)}">--%>
                                                <c:forEach var="order" items="${orderDAO.selectByStatusIds(GiaoThanhCong, DaNhan)}">
                                                    <%-- <li><a href="#">${order.categoryName}</a></li>--%>
                                                    <tr>
                                                        <td><i class="fab fa-angular fa-lg text-danger me-3"></i> <strong>${order.orderId}</strong></td>

                                                        <td>${order.user.userId}</td>
                                                        <td>${order.bookingDate}</td>
                                                            <%--                                        <c:set var="rawDate" value="${order.bookingDate}" />--%>
                                                            <%--                                        <fmt:parseDate var="formattedDate" value="${rawDate}" pattern="yyyy-MM-dd'T'HH:mm:ss" />--%>
                                                            <%--                                        <fmt:formatDate value="${formattedDate}" pattern="dd-MM-yyyy HH:mm:ss" var="formattedTime" />--%>
                                                            <%--                                        <td>${formattedTime}</td>--%>
                                                        <td><span class="badge bg-label-primary me-1">${order.status.statusName}</span></td>
                                                        <td>
                                                            <c:set var="latestHistory" value="${orderHistoryDAO.selectLatestByOrderId(order.orderId)}"/>
                                                            <c:if test="${latestHistory ne null}">
                                                                <c:if test="${not empty latestHistory.user}">
                                                                    <c:choose>
                                                                        <c:when test="${latestHistory.user.role == 2}">
                                                                            ID User: ${latestHistory.user.userId}
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            ID Admin: ${latestHistory.user.userId}
                                                                        </c:otherwise>
                                                                    </c:choose>
                                                                </c:if>
                                                            </c:if>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                                </tbody>
                                                <tfoot>
                                                <tr>
                                                    <th>ID</th>
                                                    <th>Mã User</th>
                                                    <th>Ngày đặt</th>
                                                    <th>Trạng thái</th>
                                                    <th>Người sửa</th>
                                                </tr>
                                                </tfoot>
                                            </table>
                                        </div>
                                    </div>
                                    <div class="tab-pane fade" id="navs-justified-messages" role="tabpanel">
                                        <h5 class="card-header">Danh sách đã hủy/Hoàn </h5>
                                        <div class="table-responsive text-nowrap">
                                            <table id="example2" class="table table-striped" style="width:100%">

                                                <thead>
                                                <tr>
                                                    <th>ID</th>
                                                    <th>Mã User</th>
                                                    <th>Ngày đặt</th>
                                                    <th>Trạng thái</th>
                                                    <th>Actions</th>
                                                    <th>Người sửa</th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                <c:set var="DaHuy" value="6"/>
                                                <c:set var="DaHoan" value="8"/>
                                                <%--                                <c:forEach var="order" items="${orderDAO.selectOrderByStatus(1)}">--%>
                                                <c:forEach var="order" items="${orderDAO.selectByStatusIds(DaHuy, DaHoan)}">
                                                    <%-- <li><a href="#">${order.categoryName}</a></li>--%>
                                                    <tr>
                                                        <td><i class="fab fa-angular fa-lg text-danger me-3"></i> <strong>${order.orderId}</strong></td>

                                                        <td>${order.user.userId}</td>
                                                        <td>${order.bookingDate}</td>
                                                            <%--                                        <c:set var="rawDate" value="${order.bookingDate}" />--%>
                                                            <%--                                        <fmt:parseDate var="formattedDate" value="${rawDate}" pattern="yyyy-MM-dd'T'HH:mm:ss" />--%>
                                                            <%--                                        <fmt:formatDate value="${formattedDate}" pattern="dd-MM-yyyy HH:mm:ss" var="formattedTime" />--%>
                                                            <%--                                        <td>${formattedTime}</td>--%>
                                                        <td><span class="badge bg-label-primary me-1">${order.status.statusName}</span></td>
                                                        <td>
                                                            <c:if test="${order.status.statusId == 1}">
                                                                <form action="ChangeStatusOrder" method="post" style="display:inline;">
                                                                    <input type="hidden" name="orderId" value="${order.orderId}" />
                                                                    <input type="hidden" name="action" value="AcceptOrder" />
                                                                    <button type="submit" class="badge bg-success me-1">Xác nhận</button>
                                                                </form>
                                                                <form action="ChangeStatusOrder" method="post" style="display:inline;">
                                                                    <input type="hidden" name="orderId" value="${order.orderId}" />
                                                                    <input type="hidden" name="action" value="RejectOrder" />
                                                                    <button type="submit" class="badge bg-danger me-1">Hủy</button>
                                                                </form>
                                                            </c:if>
                                                            <c:if test="${order.status.statusId == 2}">
                                                                <form action="ChangeStatusOrder" method="post" style="display:inline;">
                                                                    <input type="hidden" name="orderId" value="${order.orderId}" />
                                                                    <input type="hidden" name="action" value="Packed" />
                                                                    <button type="submit" class="badge bg-success me-1">Xong</button>
                                                                </form>
                                                            </c:if>
                                                            <c:if test="${order.status.statusId == 5}">
                                                                <form action="ChangeStatusOrder" method="post" style="display:inline;">
                                                                    <input type="hidden" name="orderId" value="${order.orderId}" />
                                                                    <input type="hidden" name="action" value="Cancel" />
                                                                    <button type="submit" class="badge bg-success me-1">Chấp nhận</button>
                                                                </form>
                                                                <form action="ChangeStatusOrder" method="post" style="display:inline;">
                                                                    <input type="hidden" name="orderId" value="${order.orderId}" />
                                                                    <input type="hidden" name="action" value="RejectCancelOrder" />
                                                                    <button type="submit" class="badge bg-danger me-1">Từ chối</button>
                                                                </form>
                                                            </c:if>
                                                            <c:if test="${order.status.statusId == 7}">
                                                                <form action="ChangeStatusOrder" method="post" style="display:inline;">
                                                                    <input type="hidden" name="orderId" value="${order.orderId}" />
                                                                    <input type="hidden" name="action" value="AcceptReturnOrder" />
                                                                    <button type="submit" class="badge bg-success me-1">Chấp nhận</button>
                                                                </form>
                                                                <form action="ChangeStatusOrder" method="post" style="display:inline;">
                                                                    <input type="hidden" name="orderId" value="${order.orderId}" />
                                                                    <input type="hidden" name="action" value="RejectReturnOrder" />
                                                                    <button type="submit" class="badge bg-danger me-1">Từ chối</button>
                                                                </form>
                                                            </c:if>
                                                        </td>
                                                        <td>
                                                            <c:set var="latestHistory" value="${orderHistoryDAO.selectLatestByOrderId(order.orderId)}"/>
                                                            <c:if test="${latestHistory ne null}">
                                                                <c:if test="${not empty latestHistory.user}">
                                                                    <c:choose>
                                                                        <c:when test="${latestHistory.user.role == 2}">
                                                                            ID User: ${latestHistory.user.userId}
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            ID Admin: ${latestHistory.user.userId}
                                                                        </c:otherwise>
                                                                    </c:choose>
                                                                </c:if>
                                                            </c:if>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                                </tbody>
                                                <tfoot>
                                                <tr>
                                                    <th>ID</th>
                                                    <th>Mã User</th>
                                                    <th>Ngày đặt</th>
                                                    <th>Trạng thái</th>
                                                    <th>Actions</th>
                                                    <th>Người sửa</th>
                                                </tr>
                                                </tfoot>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                    <!--/ Basic Bootstrap Table -->

                    <hr class="my-5" />

                    <!-- Bootstrap Dark Table -->

                    <!--/ Striped Rows -->


                </div>
                <!-- / Content -->

                <!-- Footer -->
                <footer class="content-footer footer bg-footer-theme">
                    <div class="container-xxl d-flex flex-wrap justify-content-between py-2 flex-md-row flex-column">
                        <div class="mb-2 mb-md-0">
                            ©
                            <script>
                                document.write(new Date().getFullYear());
                            </script>
                            , made with ❤️ by
                            <a href="https://themeselection.com" target="_blank" class="footer-link fw-bolder">ThemeSelection</a>
                        </div>
                        <div>
                            <a href="https://themeselection.com/license/" class="footer-link me-4" target="_blank">License</a>
                            <a href="https://themeselection.com/" target="_blank" class="footer-link me-4">More Themes</a>

                            <a
                                    href="https://themeselection.com/demo/sneat-bootstrap-html-admin-template/documentation/"
                                    target="_blank"
                                    class="footer-link me-4"
                            >Documentation</a
                            >

                            <a
                                    href="https://github.com/themeselection/sneat-html-admin-template-free/issues"
                                    target="_blank"
                                    class="footer-link me-4"
                            >Support</a
                            >
                        </div>
                    </div>
                </footer>
                <!-- / Footer -->

                <div class="content-backdrop fade"></div>
            </div>
            <!-- Content wrapper -->
        </div>
        <!-- / Layout page -->
    </div>
    <!-- Overlay -->
    <div class="layout-overlay layout-menu-toggle"></div>
</div>
<!-- / Layout wrapper -->

<div class="buy-now">
    <a
            href="Index"
            target="_blank"
            class="btn btn-danger btn-buy-now"
    >Quay lại trang shopping</a
    >
</div>

<!-- Core JS -->
<!-- build:js assets/vendor/js/core.js -->

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript" charset="UTF-8" src="https://cdn.datatables.net/2.0.6/js/dataTables.js"></script>

<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>

<script src="../assetsForAdmin/assets/vendor/libs/jquery/jquery.js"></script>
<script src="../assetsForAdmin/assets/vendor/libs/popper/popper.js"></script>
<script src="../assetsForAdmin/assets/vendor/js/bootstrap.js"></script>
<script src="../assetsForAdmin/assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.js"></script>

<script src="../assetsForAdmin/assets/vendor/js/menu.js"></script>
<!-- endbuild -->
`
<script src="../assetsForAdmin/assets/js/main.js"></script>

<!-- Page JS -->

<!-- Place this tag in your head or just before your close body tag. -->
<script async defer src="https://buttons.github.io/buttons.js"></script>
<script>
    document.addEventListener("DOMContentLoaded", function () {
        var toggle = document.getElementById("menu-icon-toggle");
        var sidebar = document.getElementById("layout-menu");
        var searchbar = document.getElementById("layout-navbar");
        var contentnew = document.getElementById("content-wrapper");
        // bigcontent = document.getElementById('content-big-section');

        toggle.addEventListener("click", function () {
            sidebar.classList.toggle("close");
            searchbar.classList.toggle("close");
            contentnew.classList.toggle("close");
            // bigcontent.classList.toggle("close");
        });
    });
</script>
<script src="https://cdn.jsdelivr.net/npm/darkreader@4.9.80/darkreader.min.js"></script>
<script src="${pageContext.request.contextPath}/js/Chart.min.js"></script>

<script>
    $(document).ready(function() {
        // Gắn sự kiện click ban đầu
        attachClickEvent();

        // Hàm để gắn sự kiện click
        function attachClickEvent() {
            $(".change-status").off("click").on("click", function(event) {
                event.preventDefault();

                let button = $(this);
                let orderId = button.data("orderid");
                let action = button.data("action");

                console.log("Button clicked. Order ID: " + orderId + ", Action: " + action);

                // Disable the button to prevent multiple clicks
                button.prop("disabled", true);

                $.ajax({
                    type: "POST",
                    url: "ChangeStatusOrder",
                    data: {
                        orderId: orderId,
                        action: action
                    },
                    success: function(response) {
                        console.log("AJAX success response: ", response);
                        if (response.success) {
                            let newStatus = response.newStatus;

                            // Cập nhật trạng thái
                            button.closest("tr").find(".order-status").text(newStatus);

                            // Cập nhật các nút hành động
                            updateActionButtons(button.closest("tr"), newStatus);
                        } else {
                            alert("Cập nhật trạng thái thất bại.");
                        }
                        button.prop("disabled", false); // Re-enable the button
                    },
                    error: function(error) {
                        console.error("AJAX error response: ", error);
                        alert("Đã xảy ra lỗi khi cập nhật trạng thái.");
                        button.prop("disabled", false); // Re-enable the button if there's an error
                    }
                });
            });
        }

        function updateActionButtons(row, newStatus) {
            let actionsCell = row.find("td:eq(4)");
            actionsCell.empty();

            if (newStatus === "Đang chờ xác nhận") {
                actionsCell.append(`
                <button class="badge bg-success me-1 change-status" data-orderid="${row.find("td:eq(0)").text()}" data-action="AcceptOrder">Xác nhận</button>
                <button class="badge bg-danger me-1 change-status" data-orderid="${row.find("td:eq(0)").text()}" data-action="RejectOrder">Hủy</button>
            `);
            } else if (newStatus === "Đang được đóng gói") {
                actionsCell.append(`
                <button class="badge bg-success me-1 change-status" data-orderid="${row.find("td:eq(0)").text()}" data-action="Packed">Xong</button>
            `);
            } else if (newStatus === "Yêu cầu hủy") {
                actionsCell.append(`
                <button class="badge bg-success me-1 change-status" data-orderid="${row.find("td:eq(0)").text()}" data-action="Cancel">Chấp nhận</button>
                <button class="badge bg-danger me-1 change-status" data-orderid="${row.find("td:eq(0)").text()}" data-action="RejectCancelOrder">Từ chối</button>
            `);
            } else if (newStatus === "Yêu cầu trả hàng") {
                actionsCell.append(`
                <button class="badge bg-success me-1 change-status" data-orderid="${row.find("td:eq(0)").text()}" data-action="AcceptReturnOrder">Chấp nhận</button>
                <button class="badge bg-danger me-1 change-status" data-orderid="${row.find("td:eq(0)").text()}" data-action="RejectReturnOrder">Từ chối</button>
            `);
            }

            // Gắn lại sự kiện click cho các nút mới
            attachClickEvent();
        }
    });

</script>




<script>
    const toggleDarkModeButton = document.getElementById("toggle-dark-mode");
    const icondarklight = document.getElementById('icontype');

    // Initially disable Dark Reader
    DarkReader.disable();

    toggleDarkModeButton.addEventListener("click", () => {
        if (DarkReader.isEnabled()) {
            DarkReader.disable();
            icondarklight.classList.replace("fa-sun", "fa-moon");
        } else {
            DarkReader.enable({
                brightness: 100,
                contrast: 90,
                sepia: 10
            });
            icondarklight.classList.replace("fa-moon", "fa-sun");
        }
    });
    $(document).ready(function() {
        $('#example').DataTable();
    });


</script>
</body>
</html>
