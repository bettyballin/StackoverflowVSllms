SELECT * FROM versions\nWHERE thing_id = ? AND thing_type = ?\nORDER BY created_at DESC\nLIMIT 1;