SELECT *\nFROM (\n  SELECT sum(reviews.rev_rating)/count(reviews.rev_id) as avg_rating, ...\n  FROM ...\n) AS subquery\nWHERE avg_rating > x;