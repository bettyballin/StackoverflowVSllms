SELECT i.*, c.name AS category_name\nFROM item i\nJOIN category c ON i.category_id = c.id\nWHERE i.id = ?