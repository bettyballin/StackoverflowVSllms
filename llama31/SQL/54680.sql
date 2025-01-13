SELECT *\nFROM (\n  SELECT *, @cumulative_sum:=@cumulative_sum + size AS cumulative_sum\n  FROM documents, (SELECT @cumulative_sum:=0) AS init\n  WHERE tag_id = 26\n  ORDER BY size\n) AS subquery\nWHERE cumulative_sum <= 600;