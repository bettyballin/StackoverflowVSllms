SELECT * FROM orders\nORDER BY \n  (SELECT RAND() FROM dual) + `user`;