WITH ranked_comments AS (\n  SELECT post_id, comment, ROW_NUMBER() OVER (PARTITION BY post_id ORDER BY comment_id DESC) AS row_num\n  FROM replies\n)\nSELECT post_id, comment\nFROM ranked_comments\nWHERE row_num <= 3;