SELECT DISTINCT p.caption\nFROM posts p\nINNER JOIN comments c ON p.id = c.post_id;