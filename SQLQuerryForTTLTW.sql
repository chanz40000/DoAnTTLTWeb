Create database book;
use book;
CREATE TABLE products (
    product_id INT PRIMARY KEY AUTO_INCREMENT,
    product_name VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    image text,
    unit_price DECIMAL(10,2) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    quantity int not null default 0,
    author VARCHAR(255),
    publication_year INT,
    publisher VARCHAR(255),
    category_id INT NOT NULL,
    FOREIGN KEY (category_id) REFERENCES categories(category_id)
);

CREATE TABLE categories (
    category_id INT PRIMARY KEY AUTO_INCREMENT,
    category_name VARCHAR(100) NOT NULL
);
CREATE TABLE orders (
    order_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    total_price DECIMAL(10,2) NOT NULL,
    nameConsignee varchar(255) NOT NULL,
    phone text NOT NULL,
    address text NOT NULL,
    payment_id INT NOT NULL,
    status varchar(255) DEFAULT 'Unconfirmed',
    booking_date date,
    note TEXT,
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (payment_id) REFERENCES payment_methods(payment_id)
);
CREATE TABLE payment_methods(
	payment_id INT PRIMARY KEY auto_increment,
    payment_name varchar(255)
);
CREATE TABLE orderdetails (
    detail_id INT PRIMARY KEY AUTO_INCREMENT,
    order_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (order_id) REFERENCES orders(order_id),
    FOREIGN KEY (product_id) REFERENCES products(product_id)
);
drop table inventories;
drop table products;
drop table orderdetails;
ALTER TABLE orders DROP FOREIGN KEY  checkout_ibfk_1;

drop table users;
drop table roles;
drop table orders;
drop table categories;
drop table comments;
drop table payment_methods;
CREATE TABLE users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(100) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role_id INT NOT NULL,
    name varchar(255),
    birthday date,
    sexual char(25),
    phoneNumber text,
    email varchar(255),
    avatar text,
    FOREIGN KEY (role_id) REFERENCES roles(role_id)
);
CREATE TABLE roles (
    role_id INT PRIMARY KEY,
    role_name VARCHAR(100) NOT NULL
);
create table rating(
	rating_id int PRIMARY KEY AUTO_INCREMENT,
    product_id int not null,
    user_id INT NOT NULL,
    rating int,
    FOREIGN KEY (product_id) REFERENCES products(product_id),
        FOREIGN KEY (user_id) REFERENCES users(user_id)

);
CREATE TABLE imports (
    import_id INT PRIMARY KEY AUTO_INCREMENT,
    supplier varchar(255) not null,
    note text,
	import_date date
);
CREATE TABLE importDetails (
	importDetail_id int PRIMARY KEY AUTO_INCREMENT,
    import_id INT not null,
	product_id INT not null,
	number_of_warehouses INT NOT NULL,
    unit_price DECIMAL(10,2) NOT NULL,
    total_price DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (product_id) REFERENCES products(product_id),
    FOREIGN KEY (import_id) REFERENCES imports(import_id)
);
CREATE TABLE comments(
    	comment_id int PRIMARY KEY AUTO_INCREMENT,
	product_id INT NOT NULL,
    user_id INT NOT NULL,
    detail_comment varchar(255) not null,
    date_comment datetime not null,
    FOREIGN KEY (product_id) REFERENCES products(product_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);
CREATE TABLE log (
id int PRIMARY KEY AUTO_INCREMENT,
level varchar(255) NOT NULL,
national varchar(255) not null


);

INSERT INTO categories(category_name) VALUES('Sách đời sống'),
                             ('Sách giáo dục');
                             SELECT * FROM categories;
-- INSERT INTO users (username, password, role_id, name, email) VALUES
--     ('Trang', 'cGFzc3dvcmQxMjN0eW5za2Rqd2FrZGx3ZGo7c2Nhd2RmZWVkaA==',1,'Trang','21130574@st.hcmuaf.edu.vn');
    INSERT INTO users (username, password, role_id, name, email) VALUES
    ('Tín', 'cGFzc3dvcmQxMjN0eW5za2Rqd2FrZGx3ZGo7c2Nhd2RmZWVkaA==',1,'Tín','21130565@st.hcmuaf.edu.vn');
    INSERT INTO roles VALUES (1,'Admin');
    INSERT INTO roles VALUES (2,'User');
    DROP DATABASE book;
    SELECT * from users;
    TRUNCATE users;
    UPDATE users set name = 'tt' where user_id=1;
    INSERT INTO categories (category_name) VALUES
('Tiểu thuyết'),
('Kinh tế'),
('Khoa học'),
('Tâm lý'),
('Lịch sử'),
('Thiếu nhi'),
('Phiêu lưu'),
('Hành động'),
('Kỹ năng sống'),
('Thơ ca'),
('Hài hước'),
('Khoa học viễn tưởng'),
('Cổ điển'),
('Chính trị'),
('Kiếm hiệp'),
('Tự truyện'),
('Kỹ thuật');
-- Chèn dữ liệu vào bảng products dựa trên dữ liệu từ bảng categories
INSERT INTO products (product_name, description, image, unit_price, price, quantity, author, publication_year, publisher, category_id) VALUES
('Bí mật của sự may mắn', 'Một cuốn sách tâm lý học tự chuyển', 'image_url_1.jpg', 150000, 250000.99, 50, 'Brian Tracy', 2020, 'NXB Lao Động', 1),
('Thiên tài bán hàng', 'Hướng dẫn chi tiết để trở thành một nhà bán hàng thành công', 'image_url_2.jpg', 180000, 300000, 30, 'Zig Ziglar', 2019, 'NXB Văn hóa - Văn nghệ', 1),
('Sức mạnh của hiện tại', 'Khám phá sức mạnh lớn lao của hiện tại', 'image_url_3.jpg', 110000, 230000, 40, 'Eckhart Tolle', 2008, 'NXB Phụ nữ', 1),
('Người giỏi không phải là người không bao giờ mắc lỗi', 'Học cách chấp nhận và học từ các sai lầm', 'image_url_4.jpg', 100000, 250000, 25, 'John C. Maxwell', 2015, 'NXB Hải Dương', 1),
('Tư duy tích cực', 'Một cách tiếp cận tích cực với cuộc sống', 'image_url_5.jpg', 120000, 240000, 60, 'Norman Vincent Peale', 2017, 'NXB Văn Hóa - Văn Nghệ', 1),
('Những bí quyết giỏi giao tiếp', 'Cách thức giao tiếp hiệu quả trong cuộc sống và công việc', 'image_url_6.jpg', 110000, 210000, 35, 'Dale Carnegie', 2021, 'NXB Thanh niên', 1),
('Hành trình về phương Đông', 'Cuốn sách nói về sự trưởng thành của một người', 'image_url_7.jpg', 200000, 300000, 45, 'Hermann Hesse', 2016, 'NXB Hà Nội', 1),
('Tâm lý học hạnh phúc', 'Các phương pháp áp dụng tâm lý học để đạt được hạnh phúc', 'image_url_8.jpg', 120000, 250000, 55, 'William James', 2014, 'NXB Giáo dục', 1),
('Lãng mạn cuộc đời', 'Những câu chuyện lãng mạn về cuộc sống', 'image_url_9.jpg', 110000, 255000, 20, 'Paulo Coelho', 2018, 'NXB Văn hóa - Văn nghệ', 1),
('Giỏi đàm phán', 'Kỹ năng quan trọng trong kinh doanh và cuộc sống', 'image_url_10.jpg', 112000, 260000, 65, 'Roger Dawson', 2022, 'NXB Đại học Quốc gia Hà Nội', 1),
('Sapiens: Lược sử loài người', 'Cuốn sách này khám phá lịch sử phát triển của loài người từ thời tiền sử đến hiện đại.', 'sapiens.jpg', 100000, 280000, 50, 'Yuval Noah Harari', 2014, 'NXB Trẻ', 1),
('Điểm dối lừa', 'Cuốn sách này là một câu chuyện gay cấn về bí mật và âm mưu trong thế giới gián điệp.', 'tinker-tailor-soldier-spy.jpg', 110000, 250000, 40, 'John le Carré', 1974, 'NXB Lao Động', 2);