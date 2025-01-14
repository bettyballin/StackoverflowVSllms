CREATE TABLE Countries (\n    CountryID NUMBER PRIMARY KEY,\n    CountryName VARCHAR2(100) NOT NULL\n);\n\nCREATE TABLE Employees (\n    EmployeeID NUMBER PRIMARY KEY,\n    EmployeeName VARCHAR2(100) NOT NULL,\n    CountryID NUMBER,  -- This column is nullable to allow for optional relationship\n    CONSTRAINT fk_country FOREIGN KEY (CountryID) REFERENCES Countries(CountryID)\n);