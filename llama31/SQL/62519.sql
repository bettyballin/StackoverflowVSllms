CREATE TABLE sessions (\n  id INT PRIMARY KEY,\n  session_id VARCHAR(255) NOT NULL,\n  user_id INT NOT NULL,\n  ip_address VARCHAR(45) NOT NULL,\n  user_agent TEXT NOT NULL,\n  expires_at TIMESTAMP NOT NULL,\n  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP\n);