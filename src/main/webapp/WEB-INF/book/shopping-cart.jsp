<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="util.FormatCurrency"%>
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
                                            <img src="img/cart/cart-1.jpg" alt="">
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
            <div class="col-lg-6">
                <div class="shoping__continue">
                    <div class="shoping__discount">
                        <h5>Discount Codes</h5>
                        <form action="#">
                            <input type="text" placeholder="Enter your coupon code">
                            <button type="submit" class="site-btn">APPLY COUPON</button>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-lg-6">
                <div class="shoping__checkout">
                    <h5>Tổng tiền</h5>
                    <ul>
                        <li>Subtotal <span class="subtotal">${FormatCurrency.formatCurrency(subtotal)}</span></li>
                        <li>Total <span class="total">${FormatCurrency.formatCurrency(total)}</span></li>
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
    $(document).ready(function(){
        $('#checkout-btn').click(function(e){
            e.preventDefault(); // Ngăn chặn hành động mặc định của thẻ a
            let cartItems = "${sessionScope.cart.cart_items}"; // Lấy danh sách mục trong giỏ hàng
            let cartItemsLength = parseInt(cartItems.length);
            console.log(cartItemsLength);
            if (cartItemsLength === 0) {
                alert('Giỏ hàng của bạn đang trống!'); // Thông báo nếu giỏ hàng trống
            } else {
                window.location.href = "/Checkout"; // Chuyển hướng tới trang thanh toán nếu giỏ hàng không trống
            }
        });

        function formatCurrency(number) {
            return new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(number);
        }

        function updateCartItemCount() {
            let totalCount = 0;
            $(".valueQuantity").each(function() {
                totalCount += parseInt($(this).val(), 10);
            });
            $(".cart-item-count").text(totalCount);
        }

        $(document).ready(function (){
            $(".updateQuantityIncrease").on("submit", function (event){
                event.preventDefault();
                let form = $(this);
                let currentQuantityInput = form.closest("tr").find(".valueQuantity");
                let pricePerItem = parseFloat(form.data("price")); // Lấy giá của một sản phẩm
                let newQuantity = parseInt(currentQuantityInput.val(), 10) + 1;

                // Cập nhật giá trị 'quantity' trong form trước khi gửi
                form.find("input[name='quantity']").val(newQuantity);

                $.ajax({
                    type: "POST",
                    url: form.attr("action"),
                    data: form.serialize(),
                    success: function (data){
                        currentQuantityInput.val(newQuantity);

                        // Tính toán và cập nhật giá tiền mới
                        let newTotalPrice = pricePerItem * newQuantity;
                        let formattedTotalPrice = formatCurrency(newTotalPrice); // Sử dụng hàm JavaScript để định dạng giá tiền
                        form.closest("tr").find(".shoping__cart__total").text(formattedTotalPrice);

                        // Cập nhật lại subtotal và total trên giao diện
                        updateSubtotalAndTotal();
                        updateCartItemCount();
                    },
                    error: function (error){
                        console.log("Error: ", error);
                        alert("Có lỗi xảy ra");
                    }
                });
            });
        });

        // Hàm cập nhật subtotal và total
        function updateSubtotalAndTotal() {
            let subtotal = 0;
            $(".shoping__cart__total").each(function() {
                subtotal += parseFloat($(this).text().replace(/\D/g, ""));
            });

            let formattedSubtotal = formatCurrency(subtotal);
            $(".subtotal").text(formattedSubtotal);

            let total = subtotal; // Đây có thể là nơi bạn tính total nếu có chi phí vận chuyển hoặc thuế khác
            let formattedTotal = formatCurrency(total);
            $(".total").text(formattedTotal);
        }

        $(document).ready(function (){
            $(".updateQuantityDecrease").on("submit", function (event){
                event.preventDefault();
                let form = $(this);
                let currentQuantityInput = form.closest("tr").find(".valueQuantity");
                let pricePerItem = parseFloat(form.data("price")); // Lấy giá của một sản phẩm
                let currentQuantity = parseInt(currentQuantityInput.val(), 10);

                if(currentQuantity > 1) {
                    let newQuantity = parseInt(currentQuantityInput.val(), 10) - 1;
                    // Cập nhật giá trị 'quantity' trong form trước khi gửi
                    form.find("input[name='quantity']").val(newQuantity);

                    $.ajax({
                        type: "POST",
                        url: form.attr("action"),
                        data: form.serialize(),
                        success: function (data) {
                            currentQuantityInput.val(newQuantity);

                            // Tính toán và cập nhật giá tiền mới
                            let newTotalPrice = pricePerItem * newQuantity;
                            let formattedTotalPrice = formatCurrency(newTotalPrice); // Sử dụng hàm JavaScript để định dạng giá tiền
                            form.closest("tr").find(".shoping__cart__total").text(formattedTotalPrice);

                            // Cập nhật lại subtotal và total trên giao diện
                            updateSubtotalAndTotal();
                            updateCartItemCount();
                        },
                        error: function (error) {
                            console.log("Error: ", error);
                            alert("Có lỗi xảy ra");
                        }
                    });
                } else{
                    console.log("Không thể giảm xuống 1")
                }
            });
        });

        $(document).ready(function (){
            $(".shoping__cart__item__close form").on("submit", function (event){
                event.preventDefault();
                let form = $(this);
                let productId = form.find("input[name='productId']").val();
                if (confirm("Bạn có chắc muốn xóa không?")) {
                    $.ajax({
                        type: "POST",
                        url: form.attr("action"),
                        data: {productId: productId},
                        success: function (data) {

                            // Xóa hàng từ bảng giỏ hàng
                            form.closest("tr").remove();

                            // Cập nhật subtotal và total sau khi xóa sản phẩm
                            updateSubtotalAndTotal();
                            updateCartItemCount();
                        },
                        error: function (error) {
                            console.log("Error: ", error);
                            alert("Có lỗi xảy ra khi xóa sản phẩm");
                        }
                    });
                } else {
                    console.log("Huy xoa")
                }
            });
        });
    });


</script>


</body>

</html>