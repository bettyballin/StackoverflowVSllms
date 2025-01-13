SELECT A.id, (\n  SELECT JSON_AGG(B.id ORDER BY B.sort_key DESC LIMIT 5)\n  FROM B\n  WHERE B.aid = A.id\n) AS top_foods\nFROM A;