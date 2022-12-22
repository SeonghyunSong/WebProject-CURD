제품의 재고를 관리해주는 간단한 MVC2 프로그램 
입력, 수정, 삭제 기능
데이터베이스 구성

[테이블명 : tbl_order]
[게시글 번호 : num]
[제품명 : p_name]
[수량 : quantity]
[가격 : price]

CREATE TABLE tbl_order(
	num INT AUTO_INCREMENT PRIMARY KEY,
	p_name VARCHAR(200),
	quantity  INT,
	price 	INT
);


Web Server
tomcat 9.0_40
Programming Language
Jdk14/JSP
Database
MySQL
소스 편집
eclipses
