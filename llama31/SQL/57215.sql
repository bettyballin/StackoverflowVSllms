CREATE TABLE access_control (\n  id INT PRIMARY KEY,\n  user_id INT,\n  resource_id INT,\n  allow BIT NOT NULL DEFAULT 0\n);\n\n-- Example query to check access\nSELECT allow FROM access_control WHERE user_id = ? AND resource_id = ?;