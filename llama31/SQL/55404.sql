CREATE TABLE files (\n  id SERIAL PRIMARY KEY,\n  group_id INTEGER NOT NULL,\n  title VARCHAR(255) NOT NULL,\n  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,\n  updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,\n  status VARCHAR(20) NOT NULL CHECK (status IN ('draft', 'final'))\n);\n\nCREATE TABLE versions (\n  id SERIAL PRIMARY KEY,\n  file_id INTEGER NOT NULL REFERENCES files(id),\n  version INTEGER NOT NULL,\n  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,\n  file_path VARCHAR(255) NOT NULL\n);\n\nCREATE TABLE groups (\n  id SERIAL PRIMARY KEY,\n  name VARCHAR(255) NOT NULL\n);\n\nCREATE TABLE users (\n  id SERIAL PRIMARY KEY,\n  username VARCHAR(255) NOT NULL,\n  email VARCHAR(255) NOT NULL\n);\n\nCREATE TABLE file_owners (\n  file_id INTEGER NOT NULL REFERENCES files(id),\n  user_id INTEGER NOT NULL REFERENCES users(id),\n  PRIMARY KEY (file_id, user_id)\n);\n\nCREATE TABLE group_owners (\n  group_id INTEGER NOT NULL REFERENCES groups(id),\n  user_id INTEGER NOT NULL REFERENCES users(id),\n  PRIMARY KEY (group_id, user_id)\n);