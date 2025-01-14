SELECT comment_id, parent_id, author, content, created_at, level\nFROM comments\nWHERE parent_id IN (:parent_ids)\nORDER BY CASE WHEN parent_id IS NOT NULL THEN created_at END;