WITH base_t AS (\n    SELECT city, temp,\n           ROW_NUMBER() OVER (PARTITION BY city ORDER BY temperature) as rownum,\n           COUNT(*) OVER (PARTITION BY city) as total_count\n    FROM weatherhistory\n),\nmedian_t AS (\n    SELECT city, temp\n    FROM base_t\n    WHERE rownum = CEIL(total_count / 2e0)\n       OR (total_count % 2 = 0 AND (rownum = FLOOR(total_count / 2e0) OR rownum = CEILING(total_count / 2e0)))\n)\nSELECT city,\n       DECIMAL(AVG(temp),10,2) AS mean_temp,\n       CASE\n           WHEN COUNT(*) = 1 THEN temp\n           ELSE AVG(temp)\n       END AS median_temp\nFROM median_t\nGROUP BY city;