SELECT customers_id, COUNT(*) AS total_reviews\nFROM reviews\nWHERE customers_id IN (\n  SELECT customers_id\n  FROM reviews\n  WHERE products_id = '170'\n)\nGROUP BY customers_id;