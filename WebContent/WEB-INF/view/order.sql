CREATE TABLE tbl_order(
	num INT AUTO_INCREMENT PRIMARY KEY,
	p_name VARCHAR(200),
	quantity  INT,
	price 	INT
);

INSERT INTO tbl_order(p_name, quantity, price) VALUES('�ȭ', 3, 50000);
INSERT INTO tbl_order(p_name, quantity, price) VALUES('������', 10, 5600);
INSERT INTO tbl_order(p_name, quantity, price) VALUES('����', 5, 34500);

SELECT * FROM tbl_order