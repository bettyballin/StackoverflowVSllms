CREATE TABLE example (\n    id INT PRIMARY KEY,\n    name VARCHAR(255), -- Use a reasonable limit\n    tags VARCHAR2(100) -- Another reasonable limit\n);\n\nCREATE TYPE varray_type AS VARRAY(10) OF VARCHAR2(50);