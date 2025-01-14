WITH LatestEntries AS (\n    SELECT business_key, MAX(id) AS max_id\n    FROM your_table_name\n    GROUP BY business_key\n)\nSELECT t.business_key, t.result\nFROM your_table_name t\nJOIN LatestEntries le ON t.id = le.max_id;