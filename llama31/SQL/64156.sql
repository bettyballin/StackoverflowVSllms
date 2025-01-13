CREATE FUNCTION create_user(\n  IN p_name VARCHAR(50),\n  IN p_email VARCHAR(100),\n  IN p_password VARCHAR(255)\n) RETURNS INTEGER AS $$\nBEGIN\n  INSERT INTO users (name, email, password) VALUES (p_name, p_email, p_password);\n  RETURN currval('users_id_seq');\nEND;\n$$ LANGUAGE plpgsql;