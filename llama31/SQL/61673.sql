CREATE TABLE lookup_dept (\n  id SERIAL PRIMARY KEY,\n  value VARCHAR(50) NOT NULL,\n  description VARCHAR(255) NOT NULL\n);\n\nCREATE TABLE lookup_salary (\n  id SERIAL PRIMARY KEY,\n  value VARCHAR(50) NOT NULL,\n  description VARCHAR(255) NOT NULL\n);