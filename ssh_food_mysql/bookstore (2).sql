
CREATE DATABASE bookstore;
go
use bookstore
go
/*用户表*/
CREATE TABLE tb_user(
  uid CHAR(32) PRIMARY KEY,/*主键*/
  username VARCHAR(50) NOT NULL,/*用户名*/
  password VARCHAR(50) NOT NULL,/*密码*/
  email VARCHAR(50) NOT NULL,/*邮箱*/
  code CHAR(64) NOT NULL,/*激活码*/
  state bit/*用户状态，有两种是否激活*/
);

SELECT * FROM tb_user;

/*分类*/
CREATE TABLE category (
  cid CHAR(32) PRIMARY KEY,/*主键*/
  cname VARCHAR(100) NOT NULL/*分类名称*/
);

INSERT  INTO category(cid,cname) VALUES ('1','vegetables');
INSERT  INTO category(cid,cname) VALUES ('2','fruit');
INSERT  INTO category(cid,cname) VALUES ('3','common organic products');

SELECT * FROM category;

/*图书表*/
CREATE TABLE book (
  bid CHAR(32) PRIMARY KEY,/*主键*/
  bname VARCHAR(100),/*产品名*/
  price DECIMAL(5,1),/*单价*/
  author VARCHAR(20),/*拥有者*/
  image VARCHAR(200),/*图片*/
  cid CHAR(32),/*所属分类*/
  del bit
);
SELECT * from book

--update book set del=1;
SELECT * FROM book;
delete from book;
insert into book values ('1','eggplant','2.6','qdmmy6','farming products_img/1.JPG','1',0);
INSERT  INTO book VALUES ('2','tamato','6.5','qdmmy6','farming products_img/2.JPG','3',0);
INSERT  INTO book VALUES ('3','carrot','3.9','张孝祥','farming products_img/3.JPG','1',0);
INSERT  INTO book VALUES ('4','cabbage','4.5','（美）塞若','farming products_img/4.JPG','1',0);
INSERT  INTO book VALUES ('5','red bean','8.3','孙鑫','farming products_img/5.JPG','1',0);
INSERT  INTO book VALUES ('6','pear','6.2','孙鑫','farming products_img/7.JPG','2',0);
INSERT  INTO book VALUES ('7','watermelon','3.0','孙卫琴','farming products_img/8.JPG','2',0);
INSERT  INTO book VALUES ('8','apple','6.2','陈华雄','farming products_img/9.JPG','2',0);
INSERT  INTO book VALUES ('9','cucumber','9.6','（美）弗兰纳根','farming products_img/10.JPG','3',0);
/*订单表*/
CREATE TABLE orders (
  oid CHAR(32) PRIMARY KEY,/*主键*/
  ordertime timestamp,/*订单生成时间*/
  total DECIMAL(10,2),/*订单合计*/
  state smallint,/*订单状态：未付款、已付款但未发货、已发货但未确认收货、收货已结束*/
  uid CHAR(32),/*订单的主人*/
  address VARCHAR(200),/*订单的收货地址*/
  FOREIGN KEY (uid) REFERENCES tb_user(uid)/*建立主外键关系*/
);

select * from orders;

insert into orders values('2CD0320B998B42E4B58507333FFC10F6', '2016-12-21 10:27:12.339', 274.0, 1, 'dfjdslfakddlkf','QD')
/*订单项表*/
CREATE TABLE orderitem (
  iid CHAR(32) PRIMARY KEY,/*主键*/
  count int,/*数量*/
  subtotal DECIMAL(10,2),/*小计*/
  oid CHAR(32),/*所属订单*/
  bid CHAR(32),/*订单项所指的商品*/
  FOREIGN KEY (oid) REFERENCES orders (oid),/*建立主外键关系*/
  FOREIGN KEY (bid) REFERENCES book (bid)/*建立主外键关系*/
);

SELECT * FROM orderitem;



select * from book where del=0;

insert into tb_user values('dfjdslfakddlkf','shipeng','niit1234','1053061544@qq.com','jsdfjksdk',1);
select * from tb_user;