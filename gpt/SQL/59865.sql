CREATE TABLE TableA (\n    ID INT PRIMARY KEY,\n    DataA NVARCHAR(50)\n);\n\nCREATE TABLE TableB (\n    ID INT PRIMARY KEY,\n    TableA_ID INT,\n    DataB NVARCHAR(50),\n    FOREIGN KEY (TableA_ID) REFERENCES TableA(ID)\n);