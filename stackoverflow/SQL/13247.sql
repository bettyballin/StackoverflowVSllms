SELECT * FROM categories\nLEFT JOIN comments ON categories.id = comments.category_id\nWHERE comments.id IS NULL OR\ncomments.id IN ( SELECT id FROM comments AS a2 WHERE categories.id = a2.category_id ORDER BY id DESC LIMIT 5 )