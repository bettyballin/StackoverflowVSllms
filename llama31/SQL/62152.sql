WITH dates AS (\n  SELECT CAST('2022-01-01' AS DATE) AS date\n  UNION ALL\n  SELECT DATEADD(day, 1, date)\n  FROM dates\n  WHERE date < '2022-01-31'\n)\nSELECT \n  d.date, \n  COUNT(t.record_date) AS record_count\nFROM \n  dates d\n  LEFT JOIN your_table t ON d.date = t.record_date\nGROUP BY \n  d.date\nORDER BY \n  d.date;