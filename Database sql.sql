create database automation_exercise;
use automation_exercise;

create table users (
  user_id int auto_increment primary key,
  first_name varchar(50),
  last_name varchar(50),
  email varchar(100) unique,
  password_hash varchar(255),
  gender enum('male', 'female'),
  birth_date date,
  newsletter boolean default 0,
  created_at datetime default current_timestamp
);

insert into users (first_name, last_name, email, password_hash, gender, birth_date, newsletter)
values
('Manual', 'user', 'manual@example.com', 'manual@2025', 'male', '1990-03-12', 1),
('new', 'user', 'new@example.com', 'new@2025', 'female', '1995-08-25', 0),
('Leo', 'Messi', 'leo@example.com', 'goat@2022', 'male', '1988-02-10', 1);

create table brands (
  brand_id int auto_increment primary key,
  brand_name varchar(100)
);

insert into brands (brand_name)
values ('h&m'), ('zara'), ('polo'), ('adidas'), ('nike');


create table categories (
  category_id int auto_increment primary key,
  category_name varchar(100),
  parent_id int null,
  foreign key (parent_id) references categories(category_id)
);

insert into categories (category_name, parent_id)
values
('men', null),
('women', null),
('kids', null),
('t-shirts', 1),
('jeans', 1),
('dresses', 2),
('shoes', 1),
('accessories', 2);

create table products (
  product_id int auto_increment primary key,
  brand_id int,
  category_id int,
  product_name varchar(150),
  description text,
  price decimal(10,2),
  image_url varchar(255),
  stock_qty int,
  created_at datetime default current_timestamp,
  foreign key (brand_id) references brands(brand_id),
  foreign key (category_id) references categories(category_id)
);

insert into products (brand_id, category_id, product_name, description, price, image_url, stock_qty)
values
(1, 4, 'blue t-shirt', 'soft cotton blue t-shirt for men.', 19.99, '/images/tshirts/blue_tshirt.jpg', 45),
(2, 6, 'red dress', 'elegant red evening dress for women.', 45.50, '/images/dresses/red_dress.jpg', 30),
(3, 5, 'slim fit jeans', 'classic slim-fit jeans with stretch.', 39.00, '/images/jeans/slim_fit.jpg', 20),
(4, 4, 'sports t-shirt', 'adidas sportswear for men.', 25.00, '/images/tshirts/sport_tshirt.jpg', 15),
(5, 7, 'running shoes', 'nike lightweight running shoes.', 79.99, '/images/shoes/running_shoes.jpg', 10);

create table orders (
  order_id int auto_increment primary key,
  user_id int,
  order_date datetime default current_timestamp,
  total_amount decimal(10,2),
  status enum('pending', 'shipped', 'delivered', 'cancelled') default 'pending',
  foreign key (user_id) references users(user_id)
);

insert into orders (user_id, total_amount, status)
values
(1, 59.99, 'delivered'),
(2, 45.50, 'pending');

create table order_items (
  order_item_id int auto_increment primary key,
  order_id int,
  product_id int,
  quantity int,
  price_each decimal(10,2),
  foreign key (order_id) references orders(order_id),
  foreign key (product_id) references products(product_id)
);

insert into order_items (order_id, product_id, quantity, price_each)
values
(1, 1, 2, 19.99),
(1, 3, 1, 39.00),
(2, 2, 1, 45.50);

create table contacts (
  contact_id int auto_increment primary key,
  name varchar(100),
  email varchar(100),
  subject varchar(200),
  message text,
  created_at datetime default current_timestamp
);

insert into contacts (name, email, subject, message)
values
('manual user', 'manual@example.com', 'shipping inquiry', 'when will my order arrive?'),
('new user', 'new@example.comusers', 'return request', 'i want to return my t-shirt.');

create table reviews (
  review_id int auto_increment primary key,
  user_id int,
  product_id int,
  rating int check (rating between 1 and 5),
  comment text,
  created_at datetime default current_timestamp,
  foreign key (user_id) references users(user_id),
  foreign key (product_id) references products(product_id)
);

insert into reviews (user_id, product_id, rating, comment)
values
(1, 1, 5, 'great quality and fit!'),
(2, 2, 4, 'beautiful color, a bit large.'),
(3, 5, 5, 'perfect running shoes!');


-- test case 1
insert into users (first_name, last_name, email, password_hash, gender, birth_date, newsletter) values ('omar', 'ali', 'omar@example.com', 'hashed_pass', 'male', '1998-04-11', 1);

-- test case 2 
insert into users (first_name, last_name, email, password_hash, gender, birth_date) values ('mohamed', 'said', 'john@example.com', 'hash2', 'male', '1995-10-10');

-- test case 3
insert into users (first_name, last_name, email, password_hash, gender) values ('lina', 'omar', 'lina@example.com', 'pass123', 'other');

-- test case 4
insert into brands (brand_name) values ('gucci');

-- test case 5
insert into categories (category_name, parent_id) values ('jackets', 1);

-- test case 6
insert into categories (category_name, parent_id) values ('hats', 999);

-- test case 7
insert into products (brand_id, category_id, product_name, description, price, image_url, stock_qty) values (1, 4, 'white t-shirt', 'basic cotton t-shirt', 20.00, '/images/tshirts/white.jpg', 100);

-- test case 8
insert into products (brand_id, category_id, product_name, price) values (999, 4, 'fake product', 10.00);

-- test case 9
insert into orders (user_id, total_amount, status) values (1, 100.00, 'pending');

-- test case 10 
insert into orders (user_id, total_amount, status) values (999, 50.00, 'pending');

-- test case 11
insert into order_items (order_id, product_id, quantity, price_each) values (1, 1, 2, 19.99);

-- test case 12
insert into reviews (user_id, product_id, rating, comment) values (1, 1, 6, 'too good');

-- test case 13
insert into contacts (name, email, subject, message) values ('ahmed hossam', 'ahmed@example.com', 'order help', 'need update on first order');

