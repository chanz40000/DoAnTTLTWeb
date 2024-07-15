<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="util.FormatCurrency"%>
<%@ page import="util.DateFormatter"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
          integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
          crossorigin="anonymous" referrerpolicy="no-referrer" />
    <!-- Css Styles -->
    <link rel="stylesheet" href="/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="/css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="/css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="/css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="/css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="/css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="/css/style.css" type="text/css">
    <style>
        .cart-btn, .primary-btn{
            border-radius: 15px;
            transition: transform 0.3s ease;
            background-color: #ffa97d;
        }

        .cart-btn:hover {
            background-color: #f86e21;
            color: white;
            transform: scale(1.1);
        }
        .primary-btn:hover{
            background-color: #f86e21;
            color: white;
            transform: scale(1.1);
        }
    </style>
</head>
<style>
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
    .choose__coupon{
        display: flex;
        width: 100%;
        max-width: 400px;
        height: 50px;
        border: 1px solid #bebebe;
        margin-bottom: 10px;
        padding-left: 10px;
        align-items: center;
        box-sizing: border-box;
        transition: background-color 0.5s ease, border-color 0.3s ease;
    }
    @media (max-width: 600px) {
        .choose__coupon {
            width: 100%;
        }
    }
    .choose__coupon:hover {
        background-color: #f0f0f0;
        border-color: #a0a0a0;
        transform: scale(1.1);
    }
    .title__choose_coupon{
        padding-left: 10px;
        font-size: 23px;
    }
    .icon__choose_coupon{
        padding-left: 140px;
    }
    .shoping__discount__choose{
        display: flex;
        /*justify-content: center;*/

        position: fixed;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
        z-index: 9999;
        width: 450px;
        height: auto;
        background-color: #ffffff;
        border-radius: 10px;
        box-shadow: 0 4px 20px rgba(0, 0, 0, 0.7);

        /*display: none;*/
    }
    .close__choose_discount{
        position: absolute;
        display: flex;
        top: -15px;
        right: -15px;
        justify-content: center;
        align-items: center;
        width: 35px;
        height: 35px;
        background-color: rgb(255, 255, 255);
        color: #ff0018;
        font-weight: bold;
        border-radius: 50%;
        box-shadow: 0 4px 20px rgba(0, 0, 0, 0.7);
        font-size: 25px;
        transition: transform 0.3s ease;
    }
    .close__choose_discount:hover {
        transform: translateY(-5px);
    }
    .shoping__discount{
        padding-left: 20px;
    }
    .input-wrapper {
        position: relative;
        display: inline-block;
    }

    .input-wrapper input {
        padding-right: 30px; /* Để để chỗ cho nút x */
    }

    #remove-coupon-btn {
        position: absolute;
        left: 200px;
        top: 88px;
        background: none;
        border: none;
        cursor: pointer;
        font-size: 18px;
        color: #999;
        z-index: 1000;
        /*display: none; !* Ban đầu ẩn nút x đi *!*/
    }
    .coupon_form{
        height: 350px;
        overflow-y: auto;
        max-width: 420px;
        padding-left: 20px;
    }
    .coupon_form_show{
        height: 150px;
        overflow-y: auto;
        max-width: 420px;
        padding-left: 20px;
    }
    .container_coupon{
        position: relative;
        display: flex;
        flex-direction: row;
        align-items: center;
        margin-top: 20px;
        height: auto;
        min-height: 108px;
        max-height: 120px;
        background-color: white;
        border: 1px solid #a4a4a4;
        padding: 5px;
        border-radius: 10px;
    }
    .quantity_coupon{
        position: absolute;
        top: 5px;
        right: 0;
        width: 50px;
        font-weight: bold;
        color: #e50e20;
        font-size: 17px;
        background-color: rgba(255, 0, 24, 0.29);
        padding: 2px;
        text-align: right;
        border-top-left-radius: 20px;
        border-bottom-left-radius: 20px;
    }
    .title_coupon {
        padding: 2px;
        height: 100%;
        width: 100px;
        border-right: 5px dotted #a4a4a4;
        left: 40%;
    }
    .img_title_coupon{
        padding-left: 10px;
    }
    .content_coupon{
        display: flex;
        flex-direction: column;
        padding-left: 15px;
        height: 100%;
        width: 250px;
    }
    .content_title_coupon{
        font-size: 20px;
        font-weight: bold;
    }
    .content_date_coupon{
        font-size: 12px;
    }
    .button_choose {
        display: flex;
        align-items: center;
        justify-content: center;
        margin-top: 10px;
    }

    .choose-coupon-circle {
        width: 40px; /* Đặt kích thước nút */
        height: 40px; /* Đặt kích thước nút */
        border-radius: 50%; /* Đặt bo tròn để tạo hình tròn */
        border: 1px solid #787878; /* Đặt đường viền cho nút */
        background-color: #f8f8f8; /* Đặt màu nền cho nút */
        cursor: pointer;
        display: flex;
        align-items: center;
        justify-content: center;
        font-size: 14px; /* Đặt kích thước font */
        color: #333; /* Đặt màu chữ */
        transition: background-color 0.3s ease; /* Thêm hiệu ứng chuyển màu nền */
    }

    .choose-coupon-circle:hover {
        background-color: #e0e0e0; /* Màu nền khi hover */
    }

    .total_coupon{
        height: 60px;
        display: flex;
        flex-direction: row;
        justify-content: space-between;
        color: #a71d2a;
        font-size: 25px;
        font-weight: bold;
    }
    .choose_coupon_success{
        height: 50px;
        width: 100%;
        background-color: #0093f3;
        margin-bottom: 10px;
        font-weight: bold;
        font-size: 30px;
        display: flex;
        justify-content: center;
        align-items: center;
        border: none;
        border-radius: 10px;
    }
    .choose_discount_coupon{
        display: none;
        z-index: 999;
    }
    .overlay {
        position: fixed;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        background: rgba(0, 0, 0, 0.5); /* Màu sắc và độ mờ */
        z-index: 998; /* Đặt lớp phủ trên các phần tử khác */
        display: none; /* Mặc định ẩn */
    }
    .remove-coupon-btn-choose{
        background-color: white;
        border: 1px solid #848484;
        color: #848484;
        width: 30px;
        height: 30px;
        border-radius: 50%;
        display: flex;
        justify-content: center;
        align-items: center;
        font-size: 20px;
        font-weight: bold;
    }
    .remove-coupon-btn-choose:hover{
        background-color: #c31625;
        border: 1px solid #c31625;
        color: #ffffff;

    }
    #remove-coupon-btn:hover{
        color: #c31625;

    }
    .choose-coupon-circle i {
        display: none; /* Ẩn icon theo mặc định */
        color: white; /* Màu icon */
        font-size: 20px;
    }
    .choose-coupon-circle.check i {
        display: inline;
    }
    .choose-coupon-circle.check {
        background-color: #c31625; /* Màu nền khi được chọn */
        border-color: #c31625; /* Màu viền khi được chọn */
    }
    .disabled_coupon {
        background-color: #f0f0f0; /* Light gray background */
        pointer-events: none; /* Disable all interactions */
        opacity: 0.5; /* Make it semi-transparent */
    }

    .disabled_coupon .choose-coupon-circle {
        cursor: not-allowed; /* Change cursor to indicate disabled */
    }

</style>
<body>
<!-- Page Preloder -->
<div id="preloder">
    <div class="loader"></div>
</div>


<jsp:include page="navbar.jsp"/>


<!-- Breadcrumb Section Begin -->
<section class="breadcrumb-section set-bg" data-setbg="img/hinhnen.png">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <div class="breadcrumb__text">
                    <h2>Giỏ hàng</h2>
                    <div class="breadcrumb__option">
                        <a href="./index.html">Nhà</a>
                        <span>Giỏ hàng</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Breadcrumb Section End -->

<!-- Shoping Cart Section Begin -->
<section class="shoping-cart spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="shoping__cart__table">
                    <c:choose>
                        <c:when test="${not empty sessionScope.cart.cart_items}">
                            <table>
                                <thead>
                                <tr>
                                    <th class="shoping__product">Tên sản phẩm</th>
                                    <th>Giá</th>
                                    <th>Số lượng</th>
                                    <th>Tổng tiền</th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="item" items="${sessionScope.cart.cart_items}">
                                    <tr>
                                        <td class="shoping__cart__item">
                                            <img src="/image/${item.product.image}" alt="" width="50px" height="70px">
                                            <h5>${item.product.product_name}</h5>
                                        </td>
                                        <td class="shoping__cart__price">
                                                ${FormatCurrency.formatCurrency(item.product.price)}
                                        </td>
                                        <td>
                                            <div class="input-group mb-3 d-flex align-items-center quantity-container" style="max-width: 120px; margin-left: 70px;width: 340px;
	height: 50px;display: inline-block;
	position: relative;
	text-align: center;
	background: #f5f5f5;">
                                                <div class="input-group-prepend">
                                                    <form class="updateQuantityDecrease" action="UpdateQuantity" method="post" data-price="${item.product.price}">
                                                        <input type="hidden" name="idproduct" value="${item.product.productId}">
                                                        <input type="hidden" name="quantity" value="${item.quantity - 1}">
                                                        <button type="submit" class="btn btn-outline-black">-</button>
                                                    </form>
                                                </div>
                                                <input type="text" class="form-control valueQuantity" style="text-align: center" value="${item.quantity}" readonly>
                                                <div class="input-group-appendd">
                                                    <form class="updateQuantityIncrease" action="UpdateQuantity" method="post" data-price="${item.product.price}">
                                                        <input type="hidden" name="idproduct" value="${item.product.productId}">
                                                        <input type="hidden" name="quantity" value="${item.quantity + 1}">
                                                        <button type="submit" class="btn btn-outline-black">+</button>
                                                    </form>
                                                </div>

                                            </div>
                                        </td>
                                        <td class="shoping__cart__total">
                                                ${FormatCurrency.formatCurrency(item.product.price * item.quantity)}
                                        </td>
                                        <td class="shoping__cart__item__close">
                                            <form action="RemoveItemCart" method="post">
                                                <input type="hidden" name="productId" value="${item.product.productId}">
                                                <button type="submit" class="icon_close" style="border: none; background-color: transparent;"></button>
                                            </form>
                                        </td>

                                    </tr>
                                    <c:set var="subtotal" value="${subtotal + (item.product.price * item.quantity)}" />
                                    <c:set var="total" value="${total + (item.product.price * item.quantity)}" />
                                </c:forEach>
                                </tbody>
                            </table>
                        </c:when>
                        <c:otherwise>
                            <div style="display: flex; justify-content: center; align-items: center">
                                <img src="img/emptyCart.png" alt="Empty Cart">
                            </div>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="shoping__cart__btns">
                    <a href="Shopgrid" class="primary-btn cart-btn">Tiếp tục mua sắm</a>
                    <a href="Shoppingcart" class="primary-btn cart-btn cart-btn-right"><span class="icon_loading"></span>
                        Cập nhật giỏ hàng</a>
                </div>
            </div>
            <jsp:useBean id="CouponOfUserDAO" class="database.CouponOfUserDAO"/>
            <jsp:useBean id="couponDAO" class="database.CouponDAO"/>
            <c:set var="id" value="${sessionScope.userC.userId}"/>
            <c:set var="couponChoose" value="${sessionScope.selectedCouponId}"/>
            <c:set var="couponCodeInput" value="${sessionScope.appliedCouponCode}"/>
            <div class="col-lg-6">
                <div class="overlay"></div>
                <div class="shoping__continue">
                    <div class="shoping__discount">
                        <h5>Mã giảm giá</h5>
                        <div class="choose__coupon">
                            <div class="img__choose_coupon">
                                <img height="40px" width="45px" src="/img/couponIcon.png">
                            </div>
                            <div class="title__choose_coupon">
                                Chọn mã giảm giá
                            </div>
                            <div class="icon__choose_coupon">
                                >
                            </div>
                        </div>

                    </div>
                    <div id="coupon-display">
                        <c:choose>
                            <c:when test="${not empty couponChoose}">
                                <div class="show_coupon">
                                    <div class="coupon_form_show">
                                        <c:set var="c" value="${couponDAO.selectById(couponChoose)}"/>

                                        <div class="container_coupon">
                                            <div class="quantity_coupon">x ${c.maxQuantityUseOfUser}</div>
                                            <div class="title_coupon">
                                                <img class="img_title_coupon" height="70px" src="/img/coupon1.png">
                                            </div>
                                            <div class="content_coupon">
                                                <c:if test="${c.discountType.couponTypeId == 1}">
                                                    <div class="content_title_coupon">Giảm giá ${c.discountValue} %</div>
                                                </c:if>
                                                <c:if test="${c.discountType.couponTypeId == 2}">
                                                    <div class="content_title_coupon">Giảm giá ${FormatCurrency.formatCurrency(c.discountValue)} </div>
                                                </c:if>

                                                <c:if test="${c.discountType.couponTypeId == 1}">
                                                    <div class="content_minPrice_coupon">Giảm tối đa ${FormatCurrency.formatCurrency(c.maxTotalPrice)}</div>
                                                    <c:if test="${c.minTotalPrice != 0}">
                                                        <div class="content_minPrice_coupon">Đơn tối thiểu ${FormatCurrency.formatCurrency(c.minTotalPrice)}</div>
                                                    </c:if>
                                                </c:if>
                                                <c:if test="${c.discountType.couponTypeId == 2}">
                                                    <div class="content_minPrice_coupon">Đơn tối thiểu ${FormatCurrency.formatCurrency(c.minTotalPrice)}</div>
                                                </c:if>
                                                <div class="content_date_coupon">Còn ${c.maxUseOfCoupon}. Hết hạn ${DateFormatter.formatDate(c.endDate)}</div>
                                            </div>
                                            <button class="remove-coupon-btn-choose"><i class="fa-solid fa-xmark"></i></button>
                                        </div>
                                    </div>
                                </div>
                            </c:when>
                            <c:when test="${not empty couponCodeInput}">
                                <div class="show_coupon">
                                    <div class="coupon_form_show">
                                        <c:set var="c" value="${couponDAO.selectByCode(couponCodeInput)}"/>

                                        <div class="container_coupon">
                                            <div class="quantity_coupon">x ${c.maxQuantityUseOfUser}</div>
                                            <div class="title_coupon">
                                                <img class="img_title_coupon" height="70px" src="/img/coupon1.png">
                                            </div>
                                            <div class="content_coupon">
                                                <c:if test="${c.discountType.couponTypeId == 1}">
                                                    <div class="content_title_coupon">Giảm giá ${c.discountValue} %</div>
                                                </c:if>
                                                <c:if test="${c.discountType.couponTypeId == 2}">
                                                    <div class="content_title_coupon">Giảm giá ${FormatCurrency.formatCurrency(c.discountValue)} </div>
                                                </c:if>

                                                <c:if test="${c.discountType.couponTypeId == 1}">
                                                    <div class="content_minPrice_coupon">Giảm tối đa ${FormatCurrency.formatCurrency(c.maxTotalPrice)}</div>
                                                    <c:if test="${c.minTotalPrice != 0}">
                                                        <div class="content_minPrice_coupon">Đơn tối thiểu ${FormatCurrency.formatCurrency(c.minTotalPrice)}</div>
                                                    </c:if>
                                                </c:if>
                                                <c:if test="${c.discountType.couponTypeId == 2}">
                                                    <div class="content_minPrice_coupon">Đơn tối thiểu ${FormatCurrency.formatCurrency(c.minTotalPrice)}</div>
                                                </c:if>
                                                <div class="content_date_coupon">Còn ${c.maxUseOfCoupon}. Hết hạn ${DateFormatter.formatDate(c.endDate)}</div>
                                            </div>
                                            <button class="remove-coupon-btn-choose"><i class="fa-solid fa-xmark"></i></button>
                                        </div>
                                    </div>
                                </div>
                            </c:when>
                            <c:otherwise>

                            </c:otherwise>
                        </c:choose>
                    </div>
                    <div class="choose_discount_coupon">
                        <div class="shoping__discount__choose">
                            <div class="close__choose_discount"><i class="fa-solid fa-xmark"></i></div>

                            <div class="shoping__discount">
                                <h5>Chọn mã giảm giá</h5>
                                <form class="CouponApply" action="ApplyCoupon" method="post">
                                    <div class="input-wrapper">
                                        <input type="text" name="couponCode" id="couponCodeInput" placeholder="Nhập mã giảm giá" value="${sessionScope.appliedCouponCode}">
                                        <button type="submit" class="site-btn">ÁP DỤNG</button>
                                    </div>
                                    <button id="remove-coupon-btn"><i class="fa-solid fa-xmark"></i></button>
                                </form>
                                <br>
                                <div class="alert alert-danger" style="display:none;"></div>
                                <div class="alert alert-success" style="display:none;"></div>
                                <hr>
                                <form class="CouponApply_choose" method="post">
                                    <div class="coupon_form">
                                        <!-- Loop for enabled coupons -->
                                        <c:forEach var="CouponOfUser" items="${CouponOfUserDAO.selectByUserId(id)}">
                                            <c:if test="${CouponOfUser.coupon.maxQuantityUseOfUser != 0 && CouponOfUser.coupon.maxUseOfCoupon != 0}">
                                                <div class="container_coupon">
                                                    <div class="quantity_coupon">x ${CouponOfUser.coupon.maxQuantityUseOfUser}</div>
                                                    <div class="title_coupon">
                                                        <img class="img_title_coupon" height="70px" src="/img/coupon1.png">
                                                    </div>
                                                    <div class="content_coupon">
                                                        <c:if test="${CouponOfUser.coupon.discountType.couponTypeId == 1}">
                                                            <div class="content_title_coupon">Giảm giá ${CouponOfUser.coupon.discountValue} %</div>
                                                        </c:if>
                                                        <c:if test="${CouponOfUser.coupon.discountType.couponTypeId == 2}">
                                                            <div class="content_title_coupon">Giảm giá ${FormatCurrency.formatCurrency(CouponOfUser.coupon.discountValue)} </div>
                                                        </c:if>
                                                        <c:if test="${CouponOfUser.coupon.discountType.couponTypeId == 1}">
                                                            <div class="content_minPrice_coupon">Giảm tối đa ${FormatCurrency.formatCurrency(CouponOfUser.coupon.maxTotalPrice)}</div>
                                                            <c:if test="${CouponOfUser.coupon.minTotalPrice != 0}">
                                                                <div class="content_minPrice_coupon">Đơn tối thiểu ${FormatCurrency.formatCurrency(CouponOfUser.coupon.minTotalPrice)}</div>
                                                            </c:if>
                                                        </c:if>
                                                        <c:if test="${CouponOfUser.coupon.discountType.couponTypeId == 2}">
                                                            <div class="content_minPrice_coupon">Đơn tối thiểu ${FormatCurrency.formatCurrency(CouponOfUser.coupon.minTotalPrice)}</div>
                                                        </c:if>
                                                        <div class="content_date_coupon">Còn ${CouponOfUser.coupon.maxUseOfCoupon}. Hết hạn ${DateFormatter.formatDate(CouponOfUser.coupon.endDate)}</div>
                                                    </div>
                                                    <div class="button_choose">
                                                        <div class="choose-coupon-circle"
                                                             data-coupon-id="${CouponOfUser.coupon.couponId}"
                                                             data-discount-type="${CouponOfUser.coupon.discountType.couponTypeId}"
                                                             data-discount-value="${CouponOfUser.coupon.discountValue}"
                                                             onclick="chooseCoupon(${CouponOfUser.coupon.couponId}, this)">
                                                            <i class="fa-solid fa-check" style="display: none;"></i>
                                                        </div>
                                                    </div>
                                                </div>
                                            </c:if>
                                        </c:forEach>

                                        <!-- Loop for disabled coupons -->
                                        <c:forEach var="CouponOfUser" items="${CouponOfUserDAO.selectByUserId(id)}">
                                            <c:if test="${CouponOfUser.coupon.maxQuantityUseOfUser == 0 || CouponOfUser.coupon.maxUseOfCoupon == 0}">
                                                <div class="container_coupon disabled_coupon">
                                                    <div class="quantity_coupon">x ${CouponOfUser.coupon.maxQuantityUseOfUser}</div>
                                                    <div class="title_coupon">
                                                        <img class="img_title_coupon" height="70px" src="/img/coupon1.png">
                                                    </div>
                                                    <div class="content_coupon">
                                                        <c:if test="${CouponOfUser.coupon.discountType.couponTypeId == 1}">
                                                            <div class="content_title_coupon">Giảm giá ${CouponOfUser.coupon.discountValue} %</div>
                                                        </c:if>
                                                        <c:if test="${CouponOfUser.coupon.discountType.couponTypeId == 2}">
                                                            <div class="content_title_coupon">Giảm giá ${FormatCurrency.formatCurrency(CouponOfUser.coupon.discountValue)} </div>
                                                        </c:if>
                                                        <c:if test="${CouponOfUser.coupon.discountType.couponTypeId == 1}">
                                                            <div class="content_minPrice_coupon">Giảm tối đa ${FormatCurrency.formatCurrency(CouponOfUser.coupon.maxTotalPrice)}</div>
                                                            <c:if test="${CouponOfUser.coupon.minTotalPrice != 0}">
                                                                <div class="content_minPrice_coupon">Đơn tối thiểu ${FormatCurrency.formatCurrency(CouponOfUser.coupon.minTotalPrice)}</div>
                                                            </c:if>
                                                        </c:if>
                                                        <c:if test="${CouponOfUser.coupon.discountType.couponTypeId == 2}">
                                                            <div class="content_minPrice_coupon">Đơn tối thiểu ${FormatCurrency.formatCurrency(CouponOfUser.coupon.minTotalPrice)}</div>
                                                        </c:if>
                                                        <div class="content_date_coupon">Còn ${CouponOfUser.coupon.maxUseOfCoupon}. Hết hạn ${DateFormatter.formatDate(CouponOfUser.coupon.endDate)}</div>
                                                    </div>
                                                    <div class="button_choose">
                                                        <div class="choose-coupon-circle"
                                                             data-coupon-id="${CouponOfUser.coupon.couponId}"
                                                             data-discount-type="${CouponOfUser.coupon.discountType.couponTypeId}"
                                                             data-discount-value="${CouponOfUser.coupon.discountValue}"
                                                             onclick="return false;">
                                                            <i class="fa-solid fa-check" style="display: none;"></i>
                                                        </div>
                                                    </div>
                                                </div>
                                            </c:if>
                                        </c:forEach>
                                    </div>

                                    <input type="hidden" name="couponId" id="selectedCouponId" value="">
                                </form>
                                <hr>
                                <div class="total_coupon">
                                    <div class="total_coupon">Giảm:  <span class="discount"> ${FormatCurrency.formatCurrency(sessionScope.discount)}</span></div>
                                    <div class="total_coupon">Tổng: <span class="total">  ${FormatCurrency.formatCurrency(total)}</span></div>
                                </div>
                                <button class="choose_coupon_success">Đồng ý</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-6">
                <input type="hidden" id="discount-type" value="${sessionScope.discountType}">
                <input type="hidden" id="discount-value" value="${sessionScope.discountValue}">
                <input type="hidden" id="minTotalPrice" value="${sessionScope.minTotalPrice}">
                <input type="hidden" id="maxTotalPrice" value="${sessionScope.maxTotalPrice}">
                <div class="shoping__checkout">
                    <h5>Tổng tiền</h5>
                    <ul>
                        <li>Tổng tiền <span class="subtotal">${FormatCurrency.formatCurrency(subtotal)}</span></li>
                        <li class="discount-container" style="display:none;">Giảm giá <span class="discount">- ${FormatCurrency.formatCurrency(sessionScope.discount)}</span></li>
                        <li>Tổng thanh toán <span class="total">${FormatCurrency.formatCurrency(total)}</span></li>
                    </ul>
                    <a href="/Checkout" class="primary-btn" id="checkout-btn">Thanh toán</a>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Shoping Cart Section End -->

<!-- Footer Section Begin -->
<footer class="footer spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-3 col-md-6 col-sm-6">
                <div class="footer__about">
                    <div class="footer__about__logo">
                        <a href="./index.html"><img src="img/logo.png" alt=""></a>
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
<script src="/js/jquery-3.3.1.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/jquery.nice-select.min.js"></script>
<script src="/js/jquery-ui.min.js"></script>
<script src="/js/jquery.slicknav.js"></script>
<script src="/js/mixitup.min.js"></script>
<script src="/js/owl.carousel.min.js"></script>
<script src="/js/main.js"></script>
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
// Set the initial button text and Font Awesome icon


// Enable Dark Reader when the page loads

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
    $(document).ready(function() {
        // hiển thị màn ngăn và cái bảng chọn mã giảm
        function showOverlay() {
            $(".overlay, .choose_discount_coupon").show();
        }
        // ẩn màn ngăn và cái bảng chọn mã giảm
        function hideOverlay() {
            $(".overlay, .choose_discount_coupon").hide();
        }
        // hiển thị thông báo áp mã và ẩn đi sau 5s
        function showAlert(message, type) {
            $(`.alert-${type}`).text(message).show();
            setTimeout(() => $(`.alert-${type}`).hide(), 5000);
        }

        // Hiển thị mã giảm giá đã chọn
        function updateCouponDisplay(response) {
            $('#discount-value').val(response.discountValue);
            $('#discount-type').val(response.discountType);
            $('#minTotalPrice').val(response.minTotalPrice);
            $('#maxTotalPrice').val(response.maxTotalPrice);
            // số tiền được giảm giá
            $('.discount').text('-' + formatCurrency(response.discount));
            // số tiền sau khi giảm giá
            $('.total').text(formatCurrency(response.newTotal));
            $(".show_coupon").show();
            $('#coupon-display').load(' #coupon-display > *', function() {
                $(".show_coupon").show();
            });
            // cập nhật lại giá tổng
            updateSubtotalAndTotal();
            showAlert(response.message, "success"); // thông báo thành công
        }

        // mã giảm khong hợp lệ
        function handleInvalidCoupon(message) {
            updateCartReset(); // reset cac giá trị của coupon để xóa mã
            showAlert(message, "danger");
        }

        // định dạng tiền việt nam
        function formatCurrency(number) {
            return new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(number);
        }

        // Cập nhật lại tôổng tiền của giỏ hàng
        function updateSubtotalAndTotal() {
            let subtotal = $(".shoping__cart__total").toArray().reduce((sum, el) => sum + parseFloat($(el).text().replace(/\D/g, "")), 0);
            let discountType = parseInt($("#discount-type").val()) || 0;
            let discountValue = parseFloat($("#discount-value").val()) || 0;
            let maxTotalPrice = parseFloat($("#maxTotalPrice").val()) || 0;
            let discount = discountType === 1 ? subtotal * (discountValue / 100) : discountType === 2 ? discountValue : 0;
            discount = maxTotalPrice > 0 && discount > maxTotalPrice ? maxTotalPrice : discount;
            $(".subtotal").text(formatCurrency(subtotal));
            $(".discount").text(" -" + formatCurrency(discount));
            $(".total").text(formatCurrency(subtotal - discount));
            discount > 0 ? $(".discount-container, .show_coupon").show() : $(".discount-container, .show_coupon").hide();
            if (subtotal < parseFloat($("#minTotalPrice").val())) updateCartReset();
        }

        // Hàm xóa mã đã chọn
        function updateCartReset() {
            $.post("UpdateCart").done(function(data) {
                if (data.success) {
                    $("#discount-type, #discount-value, #couponCodeInput, #selectedCouponId").val(0);
                    updateSubtotalAndTotal();
                    $(".show_coupon, .discount-container").hide();
                    $('.choose-coupon-circle').removeClass('check').find('i').hide();
                } else console.log("Có lỗi xảy ra khi cập nhật giỏ hàng");
            }).fail(function(error) {
                console.log("Error: ", error);
                alert("Có lỗi xảy ra");
            });
        }

        // Hàm câp nhật và hiển thị mã đã chọn
        function updateShowCoupon(couponId) {
            $.post('SaveDiscount', { couponId: couponId }, function(response) {
                if (response.success) {
                    updateCouponDisplay(response);
                } else {
                    handleInvalidCoupon(response.message);
                }
            }).fail(function(xhr, status, error) {
                console.error('Lỗi:', error);
                handleInvalidCoupon("Có lỗi xảy ra khi áp dụng mã giảm giá");
            });
        }

        $(".shoping__discount").click(showOverlay);
        $(document).on('click', '.close__choose_discount, .choose_coupon_success', hideOverlay);


        // Baams vào chọn ma giảm
        $(document).on('click', '.choose-coupon-circle', function() {
            let couponId = $(this).data('coupon-id');
            $('#selectedCouponId').val(couponId);
            sessionStorage.setItem('selectedCouponId', couponId);
            $('.choose-coupon-circle').removeClass('check').find('i').hide();
            $(this).addClass('check').find('i').show();
            updateShowCoupon(couponId);
            $("input[name='couponCode']").val("");
        });

        // bâấm vào để xóa ma giảm
        $(document).on('click', '.remove-coupon-btn-choose, #remove-coupon-btn', function(e) {
            e.preventDefault();
            sessionStorage.removeItem('selectedCouponId');
            updateCartReset();
        });

        // bấm vào để kiểm tra va chuyen qua trang thanh toan
        $('#checkout-btn').click(function(e) {
            e.preventDefault();
            let cartItemsLength = parseInt("${sessionScope.cart.cart_items}".length);
            let couponCode = $("input[name='couponCode']").val();
            let couponId = $('#selectedCouponId').val();

            if (cartItemsLength === 0) {
                alert('Giỏ hàng của bạn đang trống!');
            } else if (couponCode) {
                $.post("ApplyCoupon", { couponCode: couponCode }).done(function(data) {
                    if (data.success) {
                        window.location.href = "/Checkout";
                    } else {
                        showAlert(data.message, "danger");
                    }
                }).fail(function(error) {
                    console.log("Error: ", error);
                    alert("Có lỗi xảy ra");
                });
            } else if (couponId) {
                updateShowCoupon(couponId);
                sessionStorage.setItem('selectedCouponId', couponId);
                window.location.href = "/Checkout";
            } else {
                window.location.href = "/Checkout";
            }
        });

        // Tăng giảm số lượng
        $(".updateQuantityIncrease, .updateQuantityDecrease").on("submit", function(event) {
            event.preventDefault();
            let form = $(this);
            let currentQuantityInput = form.closest("tr").find(".valueQuantity");
            let pricePerItem = parseFloat(form.data("price"));
            let newQuantity = form.hasClass("updateQuantityIncrease") ? parseInt(currentQuantityInput.val(), 10) + 1 : parseInt(currentQuantityInput.val(), 10) - 1;

            if (newQuantity > 0) {
                form.find("input[name='quantity']").val(newQuantity);
                $.post(form.attr("action"), form.serialize(), function(data) {
                    currentQuantityInput.val(newQuantity);
                    form.closest("tr").find(".shoping__cart__total").text(formatCurrency(pricePerItem * newQuantity));
                    updateSubtotalAndTotal();

                    // Cập nhật số lượng mặt hàng trong giỏ hàng và thông báo đặt hàng thành công
                    var currentCartItemCount = parseInt($(".cart-item-count").text(), 10);
                    var newCartItemCount = form.hasClass("updateQuantityIncrease") ? currentCartItemCount + 1 : currentCartItemCount - 1;
                    $(".cart-item-count").text(newCartItemCount);
                }).fail(function(error) {
                    console.log("Error: ", error);
                    alert("Có lỗi xảy ra");
                });
            } else {
                console.log("Không thể giảm xuống dưới 1");
            }
        });

        // xóa sản phẩm khỏi giỏ hàng
        $(".shoping__cart__item__close form").on("submit", function(event) {
            event.preventDefault();
            let form = $(this);
            let currentQuantityInput = form.closest("tr").find(".valueQuantity");
            if (confirm("Bạn có chắc muốn xóa không?")) {
                $.post(form.attr("action"), { productId: form.find("input[name='productId']").val() }).done(function(data) {
                    form.closest("tr").remove();
                    updateSubtotalAndTotal();

                    // Cập nhật số lượng mặt hàng trong giỏ hàng và thông báo đặt hàng thành công
                    var currentCartItemCount = parseInt($(".cart-item-count").text(), 10);
                    var newCartItemCount = currentCartItemCount - parseInt(currentQuantityInput.val(), 10);
                    // Đảm bảo số lượng không bị âm
                    if (newCartItemCount === null) {
                        newCartItemCount = 0;
                    }

                    $(".cart-item-count").text(newCartItemCount);
                }).fail(function(error) {
                    console.log("Error: ", error);
                    alert("Có lỗi xảy ra khi xóa sản phẩm");
                });
            }
        });

        // Lấy mã giảm từ form nhập
        $(".CouponApply").on("submit", function(event) {
            event.preventDefault();
            let form = $(this);
            let couponCode = form.find("input[name='couponCode']").val();
            if (couponCode.trim() !== "") {
                $.post(form.attr("action"), { couponCode: couponCode }).done(function(data) {
                    if (data.success) {
                        updateCouponDisplay(data);
                        sessionStorage.removeItem('selectedCouponId');
                    } else {
                        showAlert(data.message, "danger");
                    }
                }).fail(function(error) {
                    console.log("Error: ", error);
                    alert("Có lỗi xảy ra");
                });
            }
        });
        // Lấy mã giảm giá đã chọn từ sessionStorage nếu có và cập nhật hiển thị
        let storedCouponId = sessionStorage.getItem('selectedCouponId');
        if (storedCouponId) {
            $('#selectedCouponId').val(storedCouponId);
            updateShowCoupon(storedCouponId);
        }
        updateSubtotalAndTotal();
    });
</script>

<script src="https://cdn.botpress.cloud/webchat/v2/inject.js"></script>
<script src="https://mediafiles.botpress.cloud/1d0997ec-87ba-4ea8-8a5c-c2fba00d5019/webchat/v2/config.js"></script>

</body>

</html>