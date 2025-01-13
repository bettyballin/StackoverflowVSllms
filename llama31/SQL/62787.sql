CREATE TABLE registrations (\n  id SERIAL PRIMARY KEY,\n  email VARCHAR(255) NOT NULL,\n  password_hash VARCHAR(255) NOT NULL,\n  verification_token VARCHAR(255) NOT NULL,\n  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP\n);\n\nCREATE TABLE users (\n  id SERIAL PRIMARY KEY,\n  email VARCHAR(255) UNIQUE NOT NULL,\n  password_hash VARCHAR(255) NOT NULL,\n  activated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP\n);