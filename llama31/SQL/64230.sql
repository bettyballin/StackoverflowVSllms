CREATE TABLE roles (\n  id INT PRIMARY KEY,\n  name VARCHAR(255) NOT NULL,\n  description TEXT\n);\n\nCREATE TABLE users (\n  id INT PRIMARY KEY,\n  username VARCHAR(255) NOT NULL,\n  password VARCHAR(255) NOT NULL\n);\n\nCREATE TABLE role_assignments (\n  id INT PRIMARY KEY,\n  user_id INT NOT NULL,\n  role_id INT NOT NULL,\n  FOREIGN KEY (user_id) REFERENCES users(id),\n  FOREIGN KEY (role_id) REFERENCES roles(id)\n);\n\nCREATE TABLE permissions (\n  id INT PRIMARY KEY,\n  name VARCHAR(255) NOT NULL,\n  description TEXT\n);\n\nCREATE TABLE role_permissions (\n  id INT PRIMARY KEY,\n  role_id INT NOT NULL,\n  permission_id INT NOT NULL,\n  FOREIGN KEY (role_id) REFERENCES roles(id),\n  FOREIGN KEY (permission_id) REFERENCES permissions(id)\n);