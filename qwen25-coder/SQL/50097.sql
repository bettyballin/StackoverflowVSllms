SELECT * FROM notes WHERE MATCH(title, body) AGAINST('~test' IN BOOLEAN MODE);