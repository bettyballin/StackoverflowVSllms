SELECT \n    t.id AS topic_id,\n    t.title,\n    u.username AS author_name,\n    COUNT(r.id) AS reply_count\nFROM \n    Topic t\nLEFT JOIN \n    Reply r ON t.id = r.topic_id\nLEFT JOIN \n    User u ON t.author_id = u.id\nWHERE \n    t.id BETWEEN :start AND :end  -- e.g., BETWEEN 1 AND 30 for the first page\nGROUP BY \n    t.id, t.title, u.username\nORDER BY \n    t.id;  -- or some other column or criteria based on your needs