<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="util.FormatCurrency"%>
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
  <meta charset="utf-8" />
  <meta
          name="viewport"
          content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0"
  />

  <title>Tables - Basic Tables | Sneat - Bootstrap 5 HTML Admin Template - Pro</title>

  <meta name="description" content="" />

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

  <!--! Template customizer & Theme config files MUST be included after core stylesheets and helpers.js in the <head> section -->
  <!--? Config:  Mandatory theme config file contain global vars & default theme options, Set your preferred theme option in this file.  -->
  <script src="../assetsForAdmin/assets/js/config.js"></script>
</head>

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
      <div class="content-wrapper">
        <!-- Content -->

        <div class="container-xxl flex-grow-1 container-p-y">
          <h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light">Forms/</span> Vertical Layouts</h4>

          <!-- Basic Layout -->
          <div class="row">

              <div class="card mb-4">
                <div class="card-header d-flex justify-content-between align-items-center">
                  <h5 class="mb-0">Basic Layout</h5>
                  <small class="text-muted float-end">Default label</small>
                </div>
                <div class="card-body">

                  <form action="/CreateProduct2" METHOD="post">

                      <div class="button-wrapper">
                        <label for="image" class="btn btn-primary me-2 mb-4" tabindex="0">
                          <span class="d-none d-sm-block">Upload new photo</span>
                          <i class="bx bx-upload d-block d-sm-none"></i>
                          <input
                                  type="file"
                                  id="image"
                                  class="account-file-input"
                                  hidden
                                  accept="image/png, image/jpeg"
                          />
                        </label>
                        <button type="button" class="btn btn-outline-secondary account-image-reset mb-4">
                          <i class="bx bx-reset d-block d-sm-none"></i>
                          <span class="d-none d-sm-block">Reset</span>
                        </button>

                        <p class="text-muted mb-0">Allowed JPG, GIF or PNG. Max size of 800K</p>
                      </div>
                    <div class="mb-3">
                      <label class="form-label" for="product_name">Tên sản phầm</label>
                      <input type="text" class="form-control" name="product_name" id="product_name"  />
                    </div>
                    <div class="mb-3">
                      <label class="form-label" for="author">Tác giả</label>
                      <input type="text" class="form-control" name="author" id="author" />
                    </div>
                    <div class="mb-3">
                      <label class="form-label" for="category">Thể loại</label>
                      <select id="category" name="category" class="select2 form-select">
                        <option value="Tiểu thuyết">Tiểu thuyết</option>
                        <option value="Kinh tế">Kinh tế</option>
                        <option value="Khoa học">Khoa học</option>
                        <option value="Tâm lý">Tâm lý</option>
                        <option value="Lịch sử">Lịch sử</option>
                        <option value="Thiếu nhi">Thiếu nhi</option>
                        <option value="Phiêu lưu">Phiêu lưu</option>
                        <option value="Hành động">Hành động</option>
                        <option value="Kỹ năng sống">Kỹ năng sống</option>
                        <option value="Thơ ca">Thơ ca</option>
                        <option value="Hài hước">Hài hước</option>
                        <option value="Khoa học viễn tưởng">Khoa học viễn tưởng</option>
                        <option value="Cổ điển">Cổ điển</option>
                        <option value="Chính trị">Chính trị</option>
                        <option value="Kiếm hiệp">Kiếm hiệp</option>
                        <option value="Tự truyện">Tự truyện</option>
                        <option value="Kỹ thuật">Kỹ thuật</option>

                      </select>
                    </div>
                    <div class="mb-3">
                      <label class="form-label" for="publicationYear">Năm xuất bản</label>
                      <input type="number" class="form-control" name="publicationYear" id="publicationYear" />
                    </div>
                    <div class="mb-3">
                      <label class="form-label" for="publisher">Nhà xuất bản</label>
                      <input type="text" class="form-control" name="publisher" id="publisher" />
                    </div>
                    <div class="mb-3">
                      <label class="form-label" for="description">Mô tả</label>
                      <textarea
                              id="description"
                              class="form-control"
                              name="description"
                      ></textarea>
                    </div>
                    <button type="submit" class="btn btn-primary">Tạo sản phẩm mới</button>
                  </form>
                </div>
              </div>
            </div>


            </div>
          </div>
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
          href="https://themeselection.com/products/sneat-bootstrap-html-admin-template/"
          target="_blank"
          class="btn btn-danger btn-buy-now"
  >Upgrade to Pro</a
  >
</div>

<!-- Core JS -->
<!-- build:js assets/vendor/js/core.js -->
<script src="../assetsForAdmin/assets/vendor/libs/jquery/jquery.js"></script>
<script src="../assetsForAdmin/assets/vendor/libs/popper/popper.js"></script>
<script src="../assetsForAdmin/assets/vendor/js/bootstrap.js"></script>
<script src="../assetsForAdmin/assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.js"></script>

<script src="../assetsForAdmin/assets/vendor/js/menu.js"></script>
<!-- endbuild -->

<!-- Vendors JS -->

<!-- Main JS -->
<script src="../assetsForAdmin/assets/js/main.js"></script>

<!-- Page JS -->

<!-- Place this tag in your head or just before your close body tag. -->
<script async defer src="https://buttons.github.io/buttons.js"></script>
</body>
</html>