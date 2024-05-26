<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="css/style.css" type="text/css">
</head>
<style>
    .commentarea{
        width: 500px;
        height: 300px;
    }
    .textareacomment{
        margin-right:150px;
        margin-top:10px;
        width: 500px;
        height: 100px;
    }
    .textareacomment:focus{
        box-shadow: 0px 0px 5px 2px rgba(85,160,224,0.75);

    ;

    }
    .btn-send{
        margin-right: 200px;
        font-size: 14px;
        color: #ffffff;
        font-weight: 800;
        text-transform: uppercase;
        display: inline-block;
        padding: 5px 25px 5px;
        background: #7fad39;
        border: none;
    }
    .product__details__pic__item--large{
        border: 1px solid grey;
        padding: 20px;
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
    .product__details__text p {
        margin-bottom: 0;
    }
    .danhgiasanpham b{
        float: left;
    }
    #rating{
        border:none;
        float:left;
        margin-top:10px;
        margin-right: 250px;

    }
    #rating>input{
        display:none;
    }
    /*ẩn input radio - vì chúng ta đã có label là GUI*/
    #rating>label:before{
        margin:5px;
        font-size:1.25em;
        font-family:FontAwesome;
        display:inline-block;
        content:"\f005";
    }
    /*1 ngôi sao*/
    /*#rating>.half:before{*/
    /*    content:"\f089";*/
    /*    position:absolute;*/
    /*}*/
    /*0.5 ngôi sao*/
    #rating>label{
        color:#ddd;
        float:right;
    }
    /*float:right để lật ngược các ngôi sao lại đúng theo thứ tự trong thực tế*/
    /*thêm màu cho sao đã chọn và các ngôi sao phía trước*/
    #rating>input:checked~label, #rating:not(:checked)>label:hover, #rating:not(:checked)>label:hover~label{
        color:#FFD700;
    }
    /* Hover vào các sao phía trước ngôi sao đã chọn*/
    #rating>input:checked+label:hover, #rating>input:checked~label:hover, #rating>label:hover~input:checked~label, #rating>input:checked~label:hover~label{
        color:#FFED85;
    }
    .product__details__rating{
        display:flex;
        align-items: center;
    }
    .Tongquan{
        width: 320px;
        height: 200px;
    }
    .Tongquan > div{
        /*position: absolute;*/
        /*left: 0px;*/
        /*top: 0px;*/
        /*bottom: 0px;*/
        /*background-color: rgb(10, 104, 255);*/
        /*border-radius: 99em;*/

    }
    .chitiettongquan{
        display: flex;
        flex-direction: row;
        height: 20px;
        margin-top: 10px;
    }
    .saodanhgia{
        display: flex;
        flex-direction: row;
    }.thanhdanhgia{
         width: 138px;
         height: 6px;
         background-color: rgb(245, 245, 250);
         position: relative;
         z-index: 1;
         margin-left: 40px;
         margin-right: 10px;
         margin-top: 5px;
         border-radius: 99em;
     }
    .thanhdanhgia > div{
        position: absolute;
        left: 0px;
        top: 0px;
        bottom: 0px;
        /*background-color: rgb(10, 104, 255);*/
        background-color: #7fad39;
        border-radius: 99em;
        width: 50%;
    }
    #personrate{
        margin-top: -2px;
    }
    .reply-comment__input{
        border: 1px solid rgb(238, 238, 238);
        padding: 10px 40px 10px 12px;
        border-radius: 12px;
        width: 90%;
        outline: 0px;
        font-size: 13px;
        line-height: 20px;
        resize: none;
        overflow: hidden;
    }
    .reply-comment__submit{
        z-index: 1;
        width: 17px;
        cursor: pointer;
        margin-bottom: 30px;
        margin-left: -24px;

    }
    /*[class*="reply-comment__wrappe"] {*/
    /*    display: none;*/
    /*}*/

    /*[class*=".reply-comment__wrapper.show"] {*/
    /*    display: block;*/
    /*}*/
    [id*="buttoncomment"]{
        background-color: white;
        border: none;
    }
    .custom-button {
        background-image: url('https://salt.tikicdn.com/ts/upload/1e/49/2d/92f01c5a743f7c8c1c7433a0a7090191.png');
        background-color: white;
        width: 17px; /* Thiết lập chiều rộng phù hợp với kích thước của hình ảnh */
        height: 17px; /* Thiết lập chiều cao phù hợp với kích thước của hình ảnh */
        border: none; /* Loại bỏ border của button */
        background-size: cover; /* Đảm bảo hình ảnh nền đầy đủ */
        background-repeat: no-repeat; /* Ngăn lặp lại hình ảnh nền */
        margin-left: -24px;
        position: relative;
        top: -12px;
        padding-left: 10px;
        padding-right: 10px;

    }

</style>
<body>
<!-- Page Preloder -->
<%--<div id="preloder">--%>
<%--    <div class="loader"></div>--%>
<%--</div>--%>


<jsp:include page="navbar.jsp"/>
<jsp:useBean id="userdao" class="database.UserDAO"></jsp:useBean>

<!-- Breadcrumb Section Begin -->
<section class="breadcrumb-section set-bg" data-setbg="img/hinhnen.png">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <div class="breadcrumb__text">
                    <h2></h2>
                    <div class="breadcrumb__option">

                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Breadcrumb Section End -->

<!-- Product Details Section Begin -->
<section class="product-details spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-6 col-md-6" id="picturearea">
                <div class="product__details__pic">
                    <div class="product__details__pic__item">

                        <img height="650px" width="100px" class="product__details__pic__item--large"
                             src="/image/${detail.image}" alt="">

                    </div>
<%--                    <div class="product__details__pic__slider owl-carousel">--%>
<%--                        <c:forEach items="${Products}" var="pca">--%>
<%--                            <img src="/image/${pca.image}"--%>
<%--                        </c:forEach>--%>
<%--                    </div>--%>
                </div>
            </div>
            <div class="col-lg-6 col-md-6">
                <div class="product__details__text">
<%--<<<<<<< HEAD--%>
<%--                    <h3>${detail.getProduct_name()}</h3>--%>
<%--                    <div class="product__details__rating">--%>
<%--                        <i class="fa fa-star"></i>--%>
<%--                        <i class="fa fa-star"></i>--%>
<%--                        <i class="fa fa-star"></i>--%>
<%--                        <i class="fa fa-star"></i>--%>
<%--                        <i class="fa fa-star-half-o"></i>--%>
<%--                        <span>(18 reviews)</span>--%>
<%--                    </div>--%>
<%--                    <div class="product__details__price">${detail.getPrice()}</div>--%>
<%--                    <p>${detail.getDescription()}</p>--%>
<%--                    <div class="product__details__quantity">--%>
<%--                        <div class="quantity">--%>
<%--                            <div class="pro-qty">--%>
<%--                                <input type="text" value="1">--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <a href="#" class="primary-btn">ADD TO CARD</a>--%>
<%--                    <a href="#" class="heart-icon"><span class="icon_heart_alt"></span></a>--%>
<%--                    <br>--%>
<%--                    <b>Ý kiến sản phẩm</b>--%>
<%--=======--%>
                    <form action="RatingProduct" method="post">
                        <input type="hidden" name="pid" value=${detail.productId}>
                        <h3>${detail.getProduct_name()}</h3>
                        <c:set var="digitImages" value="${{
    '0': 'img/image/number.0 rating.png',
    '1': 'img/image/number.1 rating.png',
    '2': 'img/image/number.2 rating.png',
    '3': 'img/image/number.3 rating.png',
    '4': 'img/image/number.4 rating.png',
    '5': 'img/image/number.5 rating.png',
    '6': 'img/image/number.6 rating.png',
    '7': 'img/image/number.7 rating.png',
    '8': 'img/image/number.8 rating.png',
    '9': 'img/image/number.9 rating.png'
}}" />

                        <div class="product__details__rating">
                            <c:set var="integerPart" value="${average.intValue()}" />
                            <c:set var="decimalPart" value="${average - integerPart}" />

                            <c:choose>
                                <c:when test="${average == 0}">
                                    <c:forEach var="digit" begin="1" end="5">
                                        <img src="img/image/number not rating.png"  width="26px" height="26px" alt="">
                                    </c:forEach>
                                </c:when>
                                <c:otherwise>
                                    <c:if test="${integerPart >= 1 && integerPart <= 5 && decimalPart == 0}">
                                        <c:forEach var="digit" begin="1" end="${integerPart}">
                                            <img src="img/image/number.0 rating.png"  width="26px" height="26px" alt="">
                                        </c:forEach>
                                        <c:forEach var="digit" begin="${integerPart + 1}" end="5">
                                            <img src="img/image/number not rating.png"  width="26px" height="26px" alt="">
                                        </c:forEach>
                                    </c:if>
                                    <c:if test="${integerPart >= 1 && integerPart <= 5 && decimalPart != 0}">
                                        <c:forEach var="digit" begin="1" end="${integerPart}">
                                            <img src="img/image/number.0 rating.png"  width="26px" height="26px" alt="">
                                        </c:forEach>
                                        <c:set var="decimalPartRounded" value="${Math.round(decimalPart * 10)}" />
                                        <img src="img/image/number.${decimalPartRounded} rating.png" width="26px" height="26px" alt="">
                                        <c:forEach var="digit" begin="${integerPart + 2}" end="5">
                                            <img src="img/image/number not rating.png"  width="26px" height="26px" alt="">
                                        </c:forEach>
                                    </c:if>
                                </c:otherwise>







                            </c:choose>
                            <span>${average}/5</span>
                            <span>(${sumrating} lượt đánh giá)</span>
                        </div>
                        <div class="product__details__price">${detail.getUnitPrice()}</div>
                        <p>${detail.getDescription()}</p>
                        <br>
                        <div class="Tongquan">
                            <b>Tổng quan</b>
                            <br>
                            <div class="chitiettongquan">
                                <div class="saodanhgia">
                                    <c:forEach var="digit" begin="1" end="5">
                                        <img src="img/image/number.0 rating.png"  width="18px" height="18px" alt="">
                                    </c:forEach>
                                </div>
                                <div class="thanhdanhgia" style="width: 100%;height: 10px">
                                    <div class="phantramdanhgia" style="width: ${sumrating !=0 ? (five/sumrating * 100) : 0}%"></div>
                                </div>
                                <span>${five}</span>
                            </div>
                            <div class="chitiettongquan">
                                <div class="saodanhgia">
                                    <c:forEach var="digit" begin="1" end="4">
                                        <img src="img/image/number.0 rating.png"  width="18px" height="18px" alt="">
                                    </c:forEach>
                                    <img src="img/image/number not rating.png"  width="18px" alt="" height="18px">
                                </div>
                                <div class="thanhdanhgia" style="width: 100%;height: 10px">
                                    <div class="phantramdanhgia" style="width: ${sumrating!=0?(four/sumrating * 100):0}%" ></div>

                                </div>
                                <span>${four}</span>
                            </div>

                            <div class="chitiettongquan">
                                <div class="saodanhgia">
                                    <c:forEach var="digit" begin="1" end="3">
                                        <img src="img/image/number.0 rating.png"  width="18px" height="18px" alt="">
                                    </c:forEach>
                                    <c:forEach var="digit" begin="4" end="5">
                                        <img src="img/image/number not rating.png"  width="18px" height="18px" alt="">
                                    </c:forEach>
                                </div>
                                <div class="thanhdanhgia" style="width: 100%;height: 10px">
                                    <div class="phantramdanhgia" style="width: ${sumrating != 0 ? (three/sumrating * 100) : 0}%;" ></div>
                                </div>
                                <span>${three}</span>
                            </div>
                            <div class="chitiettongquan">
                                <div class="saodanhgia">
                                    <c:forEach var="digit" begin="1" end="2">
                                        <img src="img/image/number.0 rating.png"  width="18px" height="18px" alt="">
                                    </c:forEach>
                                    <c:forEach var="digit" begin="3" end="5">
                                        <img src="img/image/number not rating.png"  width="18px" height="18px" alt="">
                                    </c:forEach>
                                </div>
                                <div class="thanhdanhgia" style="width: 100%;height: 10px">
                                    <div class="phantramdanhgia" style="width: ${sumrating != 0 ? (two/sumrating * 100) : 0}%"></div>
                                </div>
                                <span>${two}</span>
                            </div>
                            <div class="chitiettongquan">
                                <div class="saodanhgia">

                                    <img src="img/image/number.0 rating.png"  width="18px" height="18px" alt="">

                                    <c:forEach var="digit" begin="2" end="5">
                                        <img src="img/image/number not rating.png"  width="18px" height="18px" alt="">
                                    </c:forEach>
                                </div>
                                <div class="thanhdanhgia" style="width: 100%;height: 10px">
                                    <div class="phantramdanhgia" style="width: ${sumrating != 0 ? (one/sumrating * 100) : 0}%"></div>
                                </div>
                                <span>${one}</span>
                            </div>
                        </div>
                        <div class="danhgiasanpham">
                            <b >1 Đánh giá sản phẩm</b>
                            <div id="rating">
                                <input type="radio" id="star5" name="rating" value="5" />
                                <label class = "full" for="star5" title="Qúa tuyệt vời - 5 stars" data-content="Qúa tuyệt vời"></label>

                                <%--                        <input type="radio" id="star4half" name="rating" value="4.5" />--%>
                                <%--                        <label class="half" for="star4half" title="Trên cả tuyệt vời - 4.5 stars"></label>--%>

                                <input type="radio" id="star4" name="rating" value="4" />
                                <label class = "full" for="star4" title="Tuyệt vời - 4 stars"></label>

                                <%--                        <input type="radio" id="star3half" name="rating" value="3.5" />--%>
                                <%--                        <label class="half" for="star3half" title="Qúa tốt - 3.5 stars"></label>--%>

                                <input type="radio" id="star3" name="rating" value="3" />
                                <label class = "full" for="star3" title="Tốt - 3 stars"></label>

                                <%--                        <input type="radio" id="star2half" name="rating" value="2.5" />--%>
                                <%--                        <label class="half" for="star2half" title="Khá tốt - 2.5 stars"></label>--%>

                                <input type="radio" id="star2" name="rating" value="2" />
                                <label class = "full" for="star2" title="Tạm được - 2 stars"></label>

                                <%--                        <input type="radio" id="star1half" name="rating" value="1.5" />--%>
                                <%--                        <label class="half" for="star1half" title="Hơi tệ - 1.5 stars"></label>--%>

                                <input type="radio" id="star1" name="rating" value="1" />
                                <label class = "full" for="star1" title="Tệ - 1 star"></label>

                                <%--                        <input type="radio" id="starhalf" name="rating" value="0.5" />--%>
                                <%--                        <label class="half" for="starhalf" title="Qúa tệ - 0.5 stars"></label>--%>
                            </div>
                        </div>

                        <br>
                        <br><br><br>
                        <div>
                            <b>2 Nhận xét sản phẩm</b>

                            <div class="commentarea">
                                <textarea placeholder="Your message" class="textareacomment"  name="textarearating"></textarea>
                                <br>
                                <button type="submit" class="btn-send">SEND MESSAGE</button>
                            </div>
                        </div>
                        <%--                    <div class="col-lg-12">--%>



                        <%--                        <div class="product__details__tab">--%>
                        <%--                            <ul class="nav nav-tabs" role="tablist">--%>
                        <%--                                <li class="nav-item">--%>
                        <%--                                    <a class="nav-link active" data-toggle="tab" href="#tabs-1" role="tab"--%>
                        <%--                                       aria-selected="true">Description</a>--%>
                        <%--                                </li>--%>
                        <%--                                <li class="nav-item">--%>
                        <%--                                    <a class="nav-link" data-toggle="tab" href="#tabs-2" role="tab"--%>
                        <%--                                       aria-selected="false">Information</a>--%>
                        <%--                                </li>--%>
                        <%--                                <li class="nav-item">--%>
                        <%--                                    <a class="nav-link" data-toggle="tab" href="#tabs-3" role="tab"--%>
                        <%--                                       aria-selected="false">Reviews <span>(1)</span></a>--%>
                        <%--                                </li>--%>
                        <%--                            </ul>--%>
                        <%--                            <div class="tab-content">--%>
                        <%--                                <div class="tab-pane active" id="tabs-1" role="tabpanel">--%>
                        <%--                                    <div class="product__details__tab__desc">--%>
                        <%--                                        <h6>Products Infomation</h6>--%>
                        <%--                                        <p>Vestibulum ac diam sit amet quam vehicula elementum sed sit amet dui.--%>
                        <%--                                            Pellentesque in ipsum id orci porta dapibus. Proin eget tortor risus. Vivamus--%>
                        <%--                                            suscipit tortor eget felis porttitor volutpat. Vestibulum ac diam sit amet quam--%>
                        <%--                                            vehicula elementum sed sit amet dui. Donec rutrum congue leo eget malesuada.--%>
                        <%--                                            Vivamus suscipit tortor eget felis porttitor volutpat. Curabitur arcu erat,--%>
                        <%--                                            accumsan id imperdiet et, porttitor at sem. Praesent sapien massa, convallis a--%>
                        <%--                                            pellentesque nec, egestas non nisi. Vestibulum ac diam sit amet quam vehicula--%>
                        <%--                                            elementum sed sit amet dui. Vestibulum ante ipsum primis in faucibus orci luctus--%>
                        <%--                                            et ultrices posuere cubilia Curae; Donec velit neque, auctor sit amet aliquam--%>
                        <%--                                            vel, ullamcorper sit amet ligula. Proin eget tortor risus.</p>--%>
                        <%--                                        <p>Praesent sapien massa, convallis a pellentesque nec, egestas non nisi. Lorem--%>
                        <%--                                            ipsum dolor sit amet, consectetur adipiscing elit. Mauris blandit aliquet--%>
                        <%--                                            elit, eget tincidunt nibh pulvinar a. Cras ultricies ligula sed magna dictum--%>
                        <%--                                            porta. Cras ultricies ligula sed magna dictum porta. Sed porttitor lectus--%>
                        <%--                                            nibh. Mauris blandit aliquet elit, eget tincidunt nibh pulvinar a.--%>
                        <%--                                            Vestibulum ac diam sit amet quam vehicula elementum sed sit amet dui. Sed--%>
                        <%--                                            porttitor lectus nibh. Vestibulum ac diam sit amet quam vehicula elementum--%>
                        <%--                                            sed sit amet dui. Proin eget tortor risus.</p>--%>
                        <%--                                    </div>--%>
                        <%--                                </div>--%>
                        <%--                                <div class="tab-pane" id="tabs-2" role="tabpanel">--%>
                        <%--                                    <div class="product__details__tab__desc">--%>
                        <%--                                        <h6>Products Infomation</h6>--%>
                        <%--                                        <p>Vestibulum ac diam sit amet quam vehicula elementum sed sit amet dui.--%>
                        <%--                                            Pellentesque in ipsum id orci porta dapibus. Proin eget tortor risus.--%>
                        <%--                                            Vivamus suscipit tortor eget felis porttitor volutpat. Vestibulum ac diam--%>
                        <%--                                            sit amet quam vehicula elementum sed sit amet dui. Donec rutrum congue leo--%>
                        <%--                                            eget malesuada. Vivamus suscipit tortor eget felis porttitor volutpat.--%>
                        <%--                                            Curabitur arcu erat, accumsan id imperdiet et, porttitor at sem. Praesent--%>
                        <%--                                            sapien massa, convallis a pellentesque nec, egestas non nisi. Vestibulum ac--%>
                        <%--                                            diam sit amet quam vehicula elementum sed sit amet dui. Vestibulum ante--%>
                        <%--                                            ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae;--%>
                        <%--                                            Donec velit neque, auctor sit amet aliquam vel, ullamcorper sit amet ligula.--%>
                        <%--                                            Proin eget tortor risus.</p>--%>
                        <%--                                        <p>Praesent sapien massa, convallis a pellentesque nec, egestas non nisi. Lorem--%>
                        <%--                                            ipsum dolor sit amet, consectetur adipiscing elit. Mauris blandit aliquet--%>
                        <%--                                            elit, eget tincidunt nibh pulvinar a. Cras ultricies ligula sed magna dictum--%>
                        <%--                                            porta. Cras ultricies ligula sed magna dictum porta. Sed porttitor lectus--%>
                        <%--                                            nibh. Mauris blandit aliquet elit, eget tincidunt nibh pulvinar a.</p>--%>
                        <%--                                    </div>--%>
                        <%--                                </div>--%>
                        <%--                                <div class="tab-pane" id="tabs-3" role="tabpanel">--%>
                        <%--                                    <div class="product__details__tab__desc">--%>
                        <%--                                        <h6>Products Infomation</h6>--%>
                        <%--                                        <p>Vestibulum ac diam sit amet quam vehicula elementum sed sit amet dui.--%>
                        <%--                                            Pellentesque in ipsum id orci porta dapibus. Proin eget tortor risus.--%>
                        <%--                                            Vivamus suscipit tortor eget felis porttitor volutpat. Vestibulum ac diam--%>
                        <%--                                            sit amet quam vehicula elementum sed sit amet dui. Donec rutrum congue leo--%>
                        <%--                                            eget malesuada. Vivamus suscipit tortor eget felis porttitor volutpat.--%>
                        <%--                                            Curabitur arcu erat, accumsan id imperdiet et, porttitor at sem. Praesent--%>
                        <%--                                            sapien massa, convallis a pellentesque nec, egestas non nisi. Vestibulum ac--%>
                        <%--                                            diam sit amet quam vehicula elementum sed sit amet dui. Vestibulum ante--%>
                        <%--                                            ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae;--%>
                        <%--                                            Donec velit neque, auctor sit amet aliquam vel, ullamcorper sit amet ligula.--%>
                        <%--                                            Proin eget tortor risus.</p>--%>
                        <%--                                    </div>--%>
                        <%--                                </div>--%>
                        <%--                            </div>--%>
                        <%--                        </div>--%>
                        <%--                    </div>--%>
                    </form>

                </div>
            </div>
            <hr style="width: 1000px;border: 0.5px solid #dcdcdc">

        </div>
        <div class="phanbinhluan">
            <c:set var="counter" value="0" />

            <c:forEach var="usera" items="${userating}" varStatus="loopStatus">
                <div class="khungbinhluan">
                    <span>${usera.user.name}</span>
                    <span>Đánh giá vào
                <c:choose>
                    <c:when test="${usera.dateRating < 60}">
                        <fmt:formatNumber value="${Math.floor(usera.dateRating)}" type="number" maxFractionDigits="0" /> giây trước
                    </c:when>
                    <c:when test="${usera.dateRating >= 60 and usera.dateRating < 3600}">
                        <fmt:formatNumber value="${Math.floor(usera.dateRating / 60)}" type="number" maxFractionDigits="0" /> phút trước
                    </c:when>
                    <c:when test="${usera.dateRating >= 3600 and usera.dateRating < 3600 * 24}">
                        <fmt:formatNumber value="${Math.floor(usera.dateRating / 3600)}" type="number" maxFractionDigits="0" /> giờ trước
                    </c:when>
                    <c:when test="${usera.dateRating >= 3600 * 24 and usera.dateRating < 3600 * 24 * 31}">
                        <fmt:formatNumber value="${Math.floor(usera.dateRating / (3600 * 24))}" type="number" maxFractionDigits="0" /> ngày trước
                    </c:when>
                    <c:when test="${usera.dateRating >= 3600 * 24 * 31 and usera.dateRating < 3600 * 24 * 31 * 12}">
                        <fmt:formatNumber value="${Math.floor(usera.dateRating / (3600 * 24 * 31))}" type="number" maxFractionDigits="0" /> tháng trước
                    </c:when>
                    <c:when test="${ usera.dateRating >= 3600 * 24 * 31 * 12}">
                        <fmt:formatNumber value="${Math.floor(usera.dateRating / (3600 * 24 * 31 * 12))}" type="number" maxFractionDigits="0" /> năm trước
                    </c:when>
                </c:choose>
            </span>
                    <c:forEach var="digit" begin="1" end="${Math.round(usera.ratingstar)}">
                        <img id="personrate" src="img/image/number.0 rating.png"  width="14px" height="14px" alt="">
                    </c:forEach>
                    <br>
                    <c:if test="${not empty usera.ratingtext}">
                        <span>${usera.ratingtext}</span><br>
                        <button id="buttoncomment${loopStatus.index}"><i class="fa-regular fa-comment"></i> Bình luận</button>
                        <div class="reply-comment__wrapper${loopStatus.index}">
                            <form action="" method="">
                                <div style="min-height: 40px;">
                                    <input type="hidden" name="productid" value="${usera.product.productId}">
                                    <input type="hidden" name="ratingid" value="${usera.ratingId}">
                                    <textarea placeholder="Viết bình luận" class="reply-comment__input" name="detailcomment" rows="1" style="height: 40px;"></textarea>
                                    <button type="submit" class="custom-button"></button>

                                </div>
                            </form>
                        </div>
                        <hr>
                    </c:if>
                    <c:if test="${empty usera.ratingtext}">
                        <button id="buttoncomment${loopStatus.index}"><i class="fa-regular fa-comment"></i> Bình luận</button>
                        <div class="reply-comment__wrapper${loopStatus.index}">

                            <form action="" method="">
                                <div style="min-height: 40px;">
                                    <input type="hidden" name="productid" value="${usera.product.productId}">
                                    <input type="hidden" name="ratingid" value="${usera.ratingId}">
                                    <textarea placeholder="Viết bình luận" class="reply-comment__input" name="detailcomment" rows="1" style="height: 40px;"></textarea>
                                    <button type="submit" class="custom-button"></button>

                                </div>
                            </form>
                        </div>

                        <hr>
                    </c:if>
                </div>
            </c:forEach>
        </div>
    </div>
    <c:set var="pageR" value="${sessionScope.pageR}" />
    <c:set var="numR" value="${sessionScope.numR}" />


</section>
<!-- Product Details Section End -->
<div class="product__pagination" style="padding-left: 680px;gap:100px;margin-top:-100px">
    <c:choose>
        <c:when test="${not empty param.productName}">
            <%-- Handle pagination for filtered ratings if needed --%>
        </c:when>
        <c:otherwise>
            <c:forEach begin="1" end="${numR}" var="i">
                <c:url value="/Shopdetails" var="pageUrl">
                    <c:param name="id" value="${productid}" />
                    <c:param name="pageR" value="${i}" />
                </c:url>
                <a href="${pageUrl}" <c:if test="${i == pageR}">class="active"</c:if>>${i}</a>
            </c:forEach>
        </c:otherwise>
    </c:choose>
</div>

<!-- Related Product Section Begin -->
<section class="related-product" style="margin-top: 50px">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="section-title related__product__title">
                    <h2>Related Product</h2>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-3 col-md-4 col-sm-6">
                <div class="product__item">
                    <div class="product__item__pic set-bg" data-setbg="img/product/product-1.jpg">
                        <ul class="product__item__pic__hover">
                            <li><a href="#"><i class="fa fa-heart"></i></a></li>
                            <li><a href="#"><i class="fa fa-retweet"></i></a></li>
                            <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                        </ul>
                    </div>
                    <div class="product__item__text">
                        <h6><a href="#">Crab Pool Security</a></h6>
                        <h5>$30.00</h5>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 col-md-4 col-sm-6">
                <div class="product__item">
                    <div class="product__item__pic set-bg" data-setbg="img/product/product-2.jpg">
                        <ul class="product__item__pic__hover">
                            <li><a href="#"><i class="fa fa-heart"></i></a></li>
                            <li><a href="#"><i class="fa fa-retweet"></i></a></li>
                            <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                        </ul>
                    </div>
                    <div class="product__item__text">
                        <h6><a href="#">Crab Pool Security</a></h6>
                        <h5>$30.00</h5>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 col-md-4 col-sm-6">
                <div class="product__item">
                    <div class="product__item__pic set-bg" data-setbg="img/product/product-3.jpg">
                        <ul class="product__item__pic__hover">
                            <li><a href="#"><i class="fa fa-heart"></i></a></li>
                            <li><a href="#"><i class="fa fa-retweet"></i></a></li>
                            <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                        </ul>
                    </div>
                    <div class="product__item__text">
                        <h6><a href="#">Crab Pool Security</a></h6>
                        <h5>$30.00</h5>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 col-md-4 col-sm-6">
                <div class="product__item">
                    <div class="product__item__pic set-bg" data-setbg="img/product/product-7.jpg">
                        <ul class="product__item__pic__hover">
                            <li><a href="#"><i class="fa fa-heart"></i></a></li>
                            <li><a href="#"><i class="fa fa-retweet"></i></a></li>
                            <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                        </ul>
                    </div>
                    <div class="product__item__text">
                        <h6><a href="#">Crab Pool Security</a></h6>
                        <h5>$30.00</h5>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Related Product Section End -->

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
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.nice-select.min.js"></script>
<script src="js/jquery-ui.min.js"></script>
<script src="js/jquery.slicknav.js"></script>
<script src="js/mixitup.min.js"></script>
<script src="js/owl.carousel.min.js"></script>
<script src="js/main.js"></script>

<style>
    .ykiensanpham{
        width: 200px;
        height: 50px;
        border: 1px solid black;
        display: block;
        background-color: white;
        z-index: 999;
        font-size: 10px;
        .ykiensanpham::placeholder{
            border:3px solid #82caea;
        }
        .side-btn{
            font-size: 14px;
            color: #ffffff;
            font-weight: 800;
            text-transform: uppercase;
            display: inline-block;
            /* padding: 13px 30px 12px; */
            background: #7fad39;
            border: none;
        }
    }

</style>
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

    // Set the initial button text and Font Awesome icon


    // Enable Dark Reader when the page loads

</script>
<script>
    // Function to set the rating based on a given value
    function calcRate(r) {
        const f = Math.floor(r); // Ensure integer part using Math.floor
        const id = 'star' + f + (r % 1 ? 'half' : ''); // More concise ternary for half star

        if (id) {
            document.getElementById(id).checked = true;

        }
    }

    //No JS

    <%--const starInputs = document.querySelectorAll('#rating input[type="radio"]');--%>

    <%--starInputs.forEach(input => {--%>
    <%--    input.addEventListener('change', function() {--%>
    <%--        if (this.checked) {--%>
    <%--            const descriptionElement = document.querySelector(`label[for="${this.id}"] .label-description`);--%>
    <%--            const description = descriptionElement.dataset.content;--%>
    <%--            console.log(`Rating: ${description}`); // Output to console--%>
    <%--        }--%>
    <%--    });--%>
    <%--});--%>



    // Add event listener to each radio input
    <%--    const ratingInputs = document.querySelectorAll('#rating input[type="radio"]');--%>
    <%--    ratingInputs.forEach(input => {--%>
    <%--    input.addEventListener('change', event => {--%>
    <%--        const ids = event.target.id;--%>
    <%--        const values = event.target.value;--%>
    <%--        console.log(`Clicked input ID: ${ids}, Value: ${values}`);--%>
    <%--    });--%>
    <%--});--%>

</script>
<script>
    // // Select all buttons with the id "buttoncomment"
    // const toggleButtons = document.querySelectorAll("#buttoncomment");
    //
    // // Add an event listener to each button
    // toggleButtons.forEach(button => {
    //     const replyWrapper = button.closest(".reply-comment__wrapper");
    //     button.addEventListener("click", function (){
    //         toggleReplies(replyWrapper);
    //     });
    // });
    //
    // function toggleReplies(replyWrapper) {
    //     const replies = document.querySelectorAll(".reply-comment__wrapper");
    //     replies.forEach(item => {
    //         if (item !== replyWrapper) {
    //             item.classList.remove("show");
    //         } else {
    //             item.classList.toggle("show");
    //         }
    //     });
    // }



</script>

</body>

</html>
<%--document.addEventListener('DOMContentLoaded', function () {--%>
<%--const inputs = document.querySelectorAll('.container__items input[type="radio"]');--%>

<%--inputs.forEach(input => {--%>
<%--input.addEventListener('change', event => {--%>
<%--const id = event.target.id;--%>
<%--const labelFor = document.querySelector(`label[for="${id}"]`);--%>
<%--const labelContent = labelFor.querySelector('.label-description').getAttribute('data-content');--%>
<%--console.log(`Clicked input value: ${labelContent}`);--%>
<%--});--%>
<%--});--%>
<%--});--%>