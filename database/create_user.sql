CREATE TABLE user (
   id BIGINT NOT NULL AUTO_INCREMENT,
    email VARCHAR(100),
    login VARCHAR(12),
    name VARCHAR(40),
    password VARCHAR(255),
    PRIMARY KEY (id)
);

INSERT INTO user(
name,
email,
login,
password) 
VALUES (
'Mobile User',
'user@gmail.com',
'user',
'$2a$10$oniFUARSTmtaEbAHg8GSDuUVrtwLiz8mO9dtbZR4J8jKGz7ZgxZM6');
