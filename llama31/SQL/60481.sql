PREPARE stmt FROM 'SELECT * FROM users WHERE name = ?';\nSET @name = 'John';\nEXECUTE stmt USING @name;