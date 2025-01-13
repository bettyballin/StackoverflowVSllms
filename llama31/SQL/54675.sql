SELECT c.category_name, com.username, com.text, com.created_at\nFROM categories c\nJOIN (\n  SELECT category_id, username, text, created_at,\n         ROW_NUMBER() OVER (PARTITION BY category_id ORDER BY created_at DESC) as row_num\n  FROM comments\n) com ON c.id = com.category_id\nWHERE com.row_num <= 5\nORDER BY c.category_name, com.created_at DESC;