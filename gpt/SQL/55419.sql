CREATE TABLE users (\n       id SERIAL PRIMARY KEY,\n       name VARCHAR(100),\n       email VARCHAR(100) UNIQUE NOT NULL\n   );