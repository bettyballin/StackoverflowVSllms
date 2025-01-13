CREATE TABLE employees (\n  employee_id NUMBER PRIMARY KEY,\n  country_id NUMBER,\n  CONSTRAINT fk_employees_countries\n    FOREIGN KEY (country_id)\n    REFERENCES countries (country_id)\n    ON DELETE SET NULL\n);\n\nCREATE TABLE countries (\n  country_id NUMBER PRIMARY KEY,\n  country_name VARCHAR2(50)\n);