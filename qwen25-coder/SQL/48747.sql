CREATE OR REPLACE FUNCTION get_user_data(user_id INT) RETURNS TABLE(\n    user_id INT,\n    username TEXT,\n    email TEXT\n) AS $$\nBEGIN\n    RETURN QUERY SELECT \n        u.id, \n        u.username, \n        u.email \n    FROM users u\n    WHERE u.id = user_id;\nEND;\n$$ LANGUAGE plpgsql;