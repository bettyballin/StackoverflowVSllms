SELECT t.id, t.title\nFROM threads t\nLEFT JOIN comments c ON t.id = c.thread_id\nORDER BY c.date DESC