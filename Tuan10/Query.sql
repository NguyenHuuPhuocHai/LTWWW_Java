CREATE DATABASE IF NOT EXISTS employee_db
	CHARACTER SET utf8mb4 
  	COLLATE UTF8MB4_UNICODE_CI;
  	
USE employee_db;

CREATE TABLE employee (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    email VARCHAR(255) UNIQUE,
    gender VARCHAR(50),
    phone VARCHAR(20),
    date_of_birth VARCHAR(20), 
    address VARCHAR(255)
);

INSERT INTO employee (first_name, last_name, gender, date_of_birth, email, phone, address) VALUES
('Nguyễn', 'Văn A', 'Male', '15/03/1995', 'vana.nguyen@example.com', '0901234567', '123 Đường Sáng, Quận 1'),
('Trần', 'Thị B', 'Female', '22/10/1998', 'thib.tran@example.com', '0918765432', '456 Đường Hạnh Phúc, Quận 3'),
('Lê', 'Hoàng C', 'Male', '01/07/1990', 'hoangc.le@example.com', '0987654321', '789 Đường Tương Lai, Quận 5'),
('Phạm', 'Thị D', 'Female', '29/11/2000', 'thid.pham@example.com', '0976543210', '321 Đường Bình Yên, Quận 7'),
('Võ', 'Minh E', 'Male', '10/01/1988', 'minhe.vo@example.com', '0965432109', '654 Đường Thành Công, Quận 10');

SELECT * FROM employee;
