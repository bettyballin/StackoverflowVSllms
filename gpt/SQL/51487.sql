CREATE TABLE configuration (\n       id INT PRIMARY KEY CHECK (id = 1),\n       app_name VARCHAR(255),\n       version VARCHAR(50),\n       created_at TIMESTAMP\n   );\n   \n   INSERT INTO configuration (id, app_name, version, created_at) VALUES (1, 'MyApp', '1.0.0', NOW());