-- src/main/resources/db/migration/V1__init_schema.sql\nCREATE TABLE your_table (\n  id INT PRIMARY KEY,\n  name VARCHAR(50) NOT NULL\n);\n\n-- src/main/resources/db/testdata/V2__initial_data.sql (optional)\nINSERT INTO your_table(id, name) VALUES (1, 'Test data');