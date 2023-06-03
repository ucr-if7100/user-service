CREATE DATABASE GasIn;

USE GasIn;

CREATE TABLE App_Account (
    Id INT PRIMARY KEY,
    User_name VARCHAR(100)
);
CREATE TABLE Bank_Account (
    Account_Name VARCHAR(100),
    Account_number INT PRIMARY KEY,
    Bank_name VARCHAR(100),
	Account_type CHAR(1),
    Current_balance DECIMAL(10, 2),
    Account_Id INT,
	Card CHAR(4),
	IBAN VARCHAR(22),
	Phone_number CHAR(8),
    FOREIGN KEY (Account_Id) REFERENCES App_Account (Id)
);



