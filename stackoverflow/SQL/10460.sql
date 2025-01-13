CREATE TABLE States (st CHAR(2) PRIMARY KEY, state VARCHAR(20) NOT NULL);\nINSERT INTO States VALUES ('MO', 'Montana');\n\nCREATE TABLE Addresses (addr VARCHAR(20), city VARCHAR(20), st CHAR(2), zip CHAR(6),\n  FOREIGN KEY (st) REFERENCES States(st));\nINSERT INTO Addresses VALUES ('1301 East Sixth Ave.', 'Helena', 'MO', '59620');