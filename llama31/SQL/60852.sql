SELECT t.tag, a.date_time\nFROM articletags t\nJOIN articles a ON t.id = a.id\nWHERE (t.tag, a.date_time) IN (\n  SELECT t.tag, MAX(a.date_time)\n  FROM articletags t\n  JOIN articles a ON t.id = a.id\n  GROUP BY t.tag\n)