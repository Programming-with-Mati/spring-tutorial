CREATE SCHEMA bank;
USE bank;

CREATE TABLE bank_account (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         balance DECIMAL(14,2)
);

INSERT INTO bank_account(balance)
VALUES (0);
