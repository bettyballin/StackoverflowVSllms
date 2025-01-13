SELECT tags.*, COUNT(ct1.company_id) AS count\nFROM company2tag ct1\nJOIN tags ON ct1.tag_id = tags.id\nJOIN (\n  SELECT ct2.company_id\n  FROM company2tag ct2\n  WHERE ct2.tag_id = 18\n  GROUP BY ct2.company_id\n  HAVING COUNT(ct2.company_id) = 1\n) AS company_ids ON ct1.company_id = company_ids.company_id\nWHERE tags.id != 18\nGROUP BY ct1.tag_id\nORDER BY count DESC\nLIMIT 5;