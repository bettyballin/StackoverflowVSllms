-- Fetch comments ordered by their thread path\nSELECT * FROM comment \nWHERE article_id = ? \nORDER BY COALESCE(thread, '') ASC;