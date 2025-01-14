-- Select comments for an article, ordered by thread path\nSELECT c.comment_id, c.user_id, c.comment, c.timestamp, COALESCE(c.thread, '') AS thread_path\nFROM comment c\nWHERE c.article_id = ?\nORDER BY thread_path;