CREATE TABLE Employee (\n    EmployeeID NUMBER PRIMARY KEY,\n    Name VARCHAR2(100),\n    EmployeeType VARCHAR2(20) CHECK (EmployeeType IN ('Manager', 'Engineer'))\n);\n\nCREATE TABLE Manager (\n    EmployeeID NUMBER PRIMARY KEY,\n    FOREIGN KEY (EmployeeID) REFERENCES Employee(EmployeeID),\n    ManagerSpecificAttribute VARCHAR2(100)\n);\n\nCREATE TABLE Engineer (\n    EmployeeID NUMBER PRIMARY KEY,\n    FOREIGN KEY (EmployeeID) REFERENCES Employee(EmployeeID),\n    EngineerSpecificAttribute VARCHAR2(100)\n);