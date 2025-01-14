SELECT DISTINCT p.id, p.title, p.content\nFROM posts p\nLEFT JOIN tags t ON p.id = t.post_id AND t.tag LIKE '%$keywords%'\nWHERE t.post_id IS NULL;