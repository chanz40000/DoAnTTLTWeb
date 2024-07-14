<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page isELIgnored="false" %>
<%@ page import="util.FormatCurrency"%>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Ogani Template">
    <meta name="keywords" content="Ogani, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Ogani | Template</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="css/style.css" type="text/css">
    <style>
        .submit-button {
            border: none;
            background: none;
            padding: 0;
            font-size: 0; /* Ẩn văn bản trong nút */
            cursor: pointer;
        }

        .submit-button .fa {
            font-size: 24px; /* Kích thước biểu tượng */
            color: #000; /* Màu của biểu tượng */
        }
        button#toggle-dark-mode{
            background: none;
            color: inherit;
            border: none;
            position: absolute;
            font: inherit;
            cursor: pointer;
            outline: inherit;
            top: 12px;
        }
        .fa-regular.fa-sun{
            font-size: 20px;
            color: #f5f56d;

        }
        .fa-regular.fa-moon{
            font-size: 20px;

        }
        .sss{
            background-color: #f1f1f1;
        }
        .content{
            padding-top: 20px;

        }
        .nav-pills{
            width: 100%;
            margin-left: 0;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .nav-item{
            display: flex;
            flex-direction: column;
            padding: 3px;
        }
        .nav-pills .nav-link{
            font-weight: bold;
            padding-top: 13px;
            text-align: center;
            background: #ffffff;
            color: #000000;
            border-radius: 30px;
            box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.2);
            height: 50px;
        }
        .nav-pills .nav-link.active{
            background: #8AC0DE;
            color: #ffffff;
            box-shadow: 0px 6px 6px rgba(0, 0, 0, 0.2);
        }
        .tab-content{
            width: auto;
            max-width: 700px;
            height: auto;
            /*background: #fff;*/
            color: #000;
            /*border-radius: 30px;*/
            /*box-shadow: 0px 10px 10px rgba(0, 0, 0, 0.4);*/
            /*padding: 30px;*/
            margin: 0 auto;
        }

        .fromOrder{
            margin-top: 20px;
            width: 100%;
            max-width: 1000px;
            /*background-color: white;*/
            /*box-shadow: 0px 5px 5px rgba(0, 0, 0, 0.4);*/
            border-radius: 10px;
            /*padding: 10px;*/
            margin-left: 0;
        }
        @media (max-width: 900px) {
            .fromOrder {
                margin-left: 0; /* Bỏ margin-left khi màn hình nhỏ */
            }
        }
        .orderDetailProduct{
            display: flex;
            flex-direction: row;
        }
        .productDetail{
            display: flex;
            flex-direction: column;
            margin-left: 20px;
            width: 100%;
            justify-content: space-between;
        }
        .priceDetail{
            display: flex;
            flex-direction: row;
            justify-content: space-between;
        }

        .fa-xmark{
            position: absolute;
            top: 3px;
            left: 5px;
        }
        .tabLef{
            padding-top: 20px;

        }
        .totalOrder{
            color: #a71d2a;
            font-size: 22px;
            font-weight: bold;
        }
        .information span{
            font-weight: bold;
            color: black;
        }
        .information div{
            font-size: 18px;
            padding-bottom: 10px;
        }
    </style>
</head>

<body>
<!-- Page Preloder -->
<div id="preloder">
    <div class="loader"></div>
</div>
<jsp:include page="navbar.jsp"/>
<jsp:useBean id="orderDetailDAO" class="database.OrderDetailDAO"/>
<jsp:useBean id="orderDAO" class="database.OrderDAO"/>
<jsp:useBean id="userDAO" class="database.UserDAO"/>
<c:set var="id" value="${sessionScope.userC.userId}"/>
<c:set var="user" value="${userDAO.selectById(id)}"/>
<c:set var="Orders" value="${sessionScope.order.orderId}"/>
<!-- Breadcrumb Section Begin -->
<section class="breadcrumb-section set-bg" data-setbg="img/hinhnen.png">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <div class="breadcrumb__text">
                    <h2>Đơn hàng</h2>
                    <div class="breadcrumb__option">
                        <a href="Index">Trang chủ</a>
                        <span>Đơn hàng</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<section class="sss">
    <div class="d-flex justify-content-center" style="padding-top: 30px">
        <p style="font-size: 50px; font-weight: bold; color: black">Chi tiết đơn hàng</p>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-lg-5 left-tab">
                <div class="tabLef">
                    <div class="information">
                        <h4 style="color: #a71d2a; font-weight: bold">Thông tin người nhận</h4>
                        <hr>
                        <div class="name"><span>Tên:</span> ${order.nameConsignee}</div>
                        <div><span>Địa chỉ:</span> ${order.address}</div>
                        <div><span>Sđt:</span> ${order.phone}</div>
                        <div><span>email:</span> ${order.user.email}</div>
                        <div><span>Note:</span> ${order.note}</div>
                        <div><span>Thanh toán bằng:</span> ${order.payment.paymentName}</div>
                        <c:if test="${order.status.statusId == 1}">
                            <div style="color: #ef8640; font-weight: bold"><span>Trạng thái:</span> ${order.status.statusName} <i style="color: #ef8640" class="fa-solid fa-check"></i></div>
                        </c:if>
                        <c:if test="${order.status.statusId == 2}">
                            <div style="color: #b98d3c; font-weight: bold"><span>Trạng thái:</span> ${order.status.statusName} <i style="color: #b98d3c" class="fa-solid fa-boxes-packing"></i></div>
                        </c:if>
                        <c:if test="${order.status.statusId == 3 || order.status.statusId == 7}">
                            <div style="color: #1c67d7; font-weight: bold"><span>Trạng thái:</span> ${order.status.statusName} <i style="color: #1c67d7" class="fa-solid fa-truck-fast"></i></div>
                        </c:if>
                        <c:if test="${order.status.statusId == 4}">
                            <div style="color: #38bc10; font-weight: bold"><span>Trạng thái:</span> ${order.status.statusName} <i style="color: #38bc10" class="fa-solid fa-truck-ramp-box"></i></div>
                        </c:if>
                        <c:if test="${order.status.statusId == 5}">
                            <div style="color: #c31625; font-weight: bold"><span>Trạng thái:</span> ${order.status.statusName} <i style="color: #c31625" class="fa-solid fa-ban"></i></div>
                        </c:if>
                        <c:if test="${order.status.statusId == 6}">
                            <div style="color: #ff0018; font-weight: bold"><span>Trạng thái:</span> ${order.status.statusName}</div>
                        </c:if>
                        <c:if test="${order.status.statusId == 8}">
                            <div style="color: #c31625; font-weight: bold"><span>Trạng thái:</span> ${order.status.statusName} <i style="color: #c31625;" class="fa-solid fa-arrow-right-arrow-left"></i></div>
                        </c:if>
                        <c:if test="${order.status.statusId == 10}">
                            <div style="color: #c264ff; font-weight: bold"><span>Trạng thái:</span> ${order.status.statusName} <i style="color: #c264ff" class="fa-solid fa-box-open"></i></div>
                        </c:if>
                    </div>
                    <hr>
                    <div class="totalOrder">
                       Tổng tiền: ${FormatCurrency.formatCurrency(order.totalPrice)}
                    </div>
                    <hr>
                </div>

            </div>
            <div class="col-lg-7 ">
                <div class="order">
                    <div class="content">
                        <h3>Thông tin sản phẩm</h3>
                        <c:forEach var="orderDetail" items="${orderDetailList}">
                        <div class="fromOrder">

                            <div class="orderDetailProduct">
                                <div class="img">
                                    <img  width="80px" height="100px" src="/image/${orderDetail.product.image}" alt="">
                                </div>
                                <div class="productDetail">
                                    <div class="productName">
                                        <h3>${orderDetail.product.product_name} <span style="font-size: 20px">x ${orderDetail.quantity}</span></h3>
                                    </div>
                                    <div class="category">
                                        <p style="font-size: 15px">Thể loại: ${orderDetail.product.category.categoryName}</p>
                                    </div>
                                    <div class="priceDetail" style="display: flex" >
                                        <div class="productPrice">
                                            <h4>${FormatCurrency.formatCurrency(orderDetail.product.price)}</h4>
                                        </div>
                                        <div class="productPriceTotal">
                                            <c:set var="total" value="${orderDetail.quantity * orderDetail.product.price}"/>
                                            <h4 style="color: #ce0f21; font-weight: bold">Tổng: ${FormatCurrency.formatCurrency(total)}</h4>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <hr>
                        </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<%--</c:if>--%>


<!-- Product Section Begin -->


<!-- Product Section End -->

<!-- Footer Section Begin -->
<footer class="footer spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-3 col-md-6 col-sm-6">
                <div class="footer__about">
                    <div class="footer__about__logo">
                        <a href="./index.jsp"><img src="img/logo.png" alt=""></a>
                    </div>
                    <ul>
                        <li>Address: 60-49 Road 11378 New York</li>
                        <li>Phone: +65 11.188.888</li>
                        <li>Email: hello@colorlib.com</li>
                    </ul>
                </div>
            </div>
            <div class="col-lg-4 col-md-6 col-sm-6 offset-lg-1">
                <div class="footer__widget">
                    <h6>Useful Links</h6>
                    <ul>
                        <li><a href="#">About Us</a></li>
                        <li><a href="#">About Our Shop</a></li>
                        <li><a href="#">Secure Shopping</a></li>
                        <li><a href="#">Delivery infomation</a></li>
                        <li><a href="#">Privacy Policy</a></li>
                        <li><a href="#">Our Sitemap</a></li>
                    </ul>
                    <ul>
                        <li><a href="#">Who We Are</a></li>
                        <li><a href="#">Our Services</a></li>
                        <li><a href="#">Projects</a></li>
                        <li><a href="#">Contact</a></li>
                        <li><a href="#">Innovation</a></li>
                        <li><a href="#">Testimonials</a></li>
                    </ul>
                </div>
            </div>
            <div class="col-lg-4 col-md-12">
                <div class="footer__widget">
                    <h6>Join Our Newsletter Now</h6>
                    <p>Get E-mail updates about our latest shop and special offers.</p>
                    <form action="#">
                        <input type="text" placeholder="Enter your mail">
                        <button type="submit" class="site-btn">Subscribe</button>
                    </form>
                    <div class="footer__widget__social">
                        <a href="#"><i class="fa fa-facebook"></i></a>
                        <a href="#"><i class="fa fa-instagram"></i></a>
                        <a href="#"><i class="fa fa-twitter"></i></a>
                        <a href="#"><i class="fa fa-pinterest"></i></a>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="footer__copyright">
                    <div class="footer__copyright__text"><p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                        Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p></div>
                    <div class="footer__copyright__payment"><img src="img/payment-item.png" alt=""></div>
                </div>
            </div>
        </div>
    </div>
</footer>
<!-- Footer Section End -->

<!-- Js Plugins -->
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.nice-select.min.js"></script>
<script src="js/jquery-ui.min.js"></script>
<script src="js/jquery.slicknav.js"></script>
<script src="js/mixitup.min.js"></script>
<script src="js/owl.carousel.min.js"></script>
<script src="js/main.js"></script>
<script src="https://cdn.jsdelivr.net/npm/darkreader@4.9.80/darkreader.min.js"></script>

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

</script>
<script>
    $(document).ready(function (){
        // Chọn tất cả các phần tử có class CancelOrderBt
        let cancelOrderButtons = document.querySelectorAll('.CancelOrderBt');

        // Duyệt qua từng phần tử và thêm sự kiện click
        cancelOrderButtons.forEach(function(cancelOrderButton) {
            cancelOrderButton.addEventListener("click", function (){
                // Lấy phần tử cha của nút hiện tại
                let parentElement = cancelOrderButton.closest('.fromOrder');
                // Chọn các phần tử overlay và reasonCancel từ phần tử cha
                let overlay = parentElement.querySelector('.overlay');
                let reasonCancel = parentElement.querySelector('.reasonCancel');
                let closeReason = reasonCancel.querySelector('.closeReason');

                // Hiển thị các phần tử
                overlay.style.display = "block";
                reasonCancel.style.display = "block";
                closeReason.style.display = "block";

                // Thêm sự kiện click cho nút đóng
                closeReason.addEventListener("click", function (){
                    overlay.style.display = "none";
                    reasonCancel.style.display = "none";
                    closeReason.style.display = "none";
                });
            });
        });
    });

</script>
<script src="https://cdn.botpress.cloud/webchat/v2/inject.js"></script>
<script src="https://mediafiles.botpress.cloud/1d0997ec-87ba-4ea8-8a5c-c2fba00d5019/webchat/v2/config.js"></script>
</body>

</html>