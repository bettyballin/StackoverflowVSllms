-- MySQL 4 (implicit join)\nSELECT * FROM users, orders WHERE users.id = orders.user_id;\n\n-- MySQL 5 (explicit join)\nSELECT * FROM users INNER JOIN orders ON users.id = orders.user_id;