SELECT p.id, p.url, p.created_at, pa.name, pa.value\nFROM posts p\nJOIN post_attributes pa ON p.id = pa.post_id\nWHERE pa.name IN ('title', 'body')\nORDER BY p.id;