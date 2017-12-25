
CREATE DATABASE bookstore;
go
use bookstore
go
/*�û���*/
CREATE TABLE tb_user(
  uid CHAR(32) PRIMARY KEY,/*����*/
  username VARCHAR(50) NOT NULL,/*�û���*/
  password VARCHAR(50) NOT NULL,/*����*/
  email VARCHAR(50) NOT NULL,/*����*/
  code CHAR(64) NOT NULL,/*������*/
  state bit/*�û�״̬���������Ƿ񼤻�*/
);

SELECT * FROM tb_user;

/*����*/
CREATE TABLE category (
  cid CHAR(32) PRIMARY KEY,/*����*/
  cname VARCHAR(100) NOT NULL/*��������*/
);

INSERT  INTO category(cid,cname) VALUES ('1','vegetables');
INSERT  INTO category(cid,cname) VALUES ('2','fruit');
INSERT  INTO category(cid,cname) VALUES ('3','common organic products');

SELECT * FROM category;

/*ͼ���*/
CREATE TABLE book (
  bid CHAR(32) PRIMARY KEY,/*����*/
  bname VARCHAR(100),/*��Ʒ��*/
  price DECIMAL(5,1),/*����*/
  author VARCHAR(20),/*ӵ����*/
  image VARCHAR(200),/*ͼƬ*/
  cid CHAR(32),/*��������*/
  del bit
);
SELECT * from book

--update book set del=1;
SELECT * FROM book;
delete from book;
insert into book values ('1','eggplant','2.6','qdmmy6','farming products_img/1.JPG','1',0);
INSERT  INTO book VALUES ('2','tamato','6.5','qdmmy6','farming products_img/2.JPG','3',0);
INSERT  INTO book VALUES ('3','carrot','3.9','��Т��','farming products_img/3.JPG','1',0);
INSERT  INTO book VALUES ('4','cabbage','4.5','����������','farming products_img/4.JPG','1',0);
INSERT  INTO book VALUES ('5','red bean','8.3','����','farming products_img/5.JPG','1',0);
INSERT  INTO book VALUES ('6','pear','6.2','����','farming products_img/7.JPG','2',0);
INSERT  INTO book VALUES ('7','watermelon','3.0','������','farming products_img/8.JPG','2',0);
INSERT  INTO book VALUES ('8','apple','6.2','�»���','farming products_img/9.JPG','2',0);
INSERT  INTO book VALUES ('9','cucumber','9.6','�����������ɸ�','farming products_img/10.JPG','3',0);
/*������*/
CREATE TABLE orders (
  oid CHAR(32) PRIMARY KEY,/*����*/
  ordertime timestamp,/*��������ʱ��*/
  total DECIMAL(10,2),/*�����ϼ�*/
  state smallint,/*����״̬��δ����Ѹ��δ�������ѷ�����δȷ���ջ����ջ��ѽ���*/
  uid CHAR(32),/*����������*/
  address VARCHAR(200),/*�������ջ���ַ*/
  FOREIGN KEY (uid) REFERENCES tb_user(uid)/*�����������ϵ*/
);

select * from orders;

insert into orders values('2CD0320B998B42E4B58507333FFC10F6', '2016-12-21 10:27:12.339', 274.0, 1, 'dfjdslfakddlkf','QD')
/*�������*/
CREATE TABLE orderitem (
  iid CHAR(32) PRIMARY KEY,/*����*/
  count int,/*����*/
  subtotal DECIMAL(10,2),/*С��*/
  oid CHAR(32),/*��������*/
  bid CHAR(32),/*��������ָ����Ʒ*/
  FOREIGN KEY (oid) REFERENCES orders (oid),/*�����������ϵ*/
  FOREIGN KEY (bid) REFERENCES book (bid)/*�����������ϵ*/
);

SELECT * FROM orderitem;



select * from book where del=0;

insert into tb_user values('dfjdslfakddlkf','shipeng','niit1234','1053061544@qq.com','jsdfjksdk',1);
select * from tb_user;