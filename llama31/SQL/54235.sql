CREATE TABLE users (\n  id BIGINT PRIMARY KEY,\n  username VARCHAR(255) NOT NULL,\n  password VARCHAR(255) NOT NULL,\n  salt VARCHAR(255) NOT NULL\n);\n\nCREATE TABLE roles (\n  id BIGINT PRIMARY KEY,\n  rolename VARCHAR(255) NOT NULL\n);\n\nCREATE TABLE user_roles (\n  user_id BIGINT NOT NULL,\n  role_id BIGINT NOT NULL,\n  PRIMARY KEY (user_id, role_id),\n  FOREIGN KEY (user_id) REFERENCES users(id),\n  FOREIGN KEY (role_id) REFERENCES roles(id)\n);\n\nCREATE TABLE permissions (\n  id BIGINT PRIMARY KEY,\n  permission VARCHAR(255) NOT NULL\n);\n\nCREATE TABLE role_permissions (\n  role_id BIGINT NOT NULL,\n  permission_id BIGINT NOT NULL,\n  PRIMARY KEY (role_id, permission_id),\n  FOREIGN KEY (role_id) REFERENCES roles(id),\n  FOREIGN KEY (permission_id) REFERENCES permissions(id)\n);