WITH RECURSIVE missing_values AS (\n  SELECT \n    MIN(WebId) AS start_value,\n    MAX(WebId) AS end_value\n  FROM \n    your_table\n  WHERE \n    WebId LIKE 'S%' AND\n    DocEntry >= (SELECT MIN(DocEntry) FROM your_table WHERE DocEntry >= DATE_TRUNC('month', CURRENT_DATE))\n    AND DocEntry <= (SELECT MAX(DocEntry) FROM your_table WHERE DocEntry < DATE_TRUNC('month', CURRENT_DATE) + INTERVAL '1 month')\n  UNION ALL\n  SELECT \n    start_value + 1,\n    end_value\n  FROM \n    missing_values\n  WHERE \n    start_value < end_value\n)\nSELECT \n  CONCAT('S', LPAD(start_value, 3, '0')) AS missing_web_id\nFROM \n  missing_values\nWHERE \n  CONCAT('S', LPAD(start_value, 3, '0')) NOT IN (SELECT WebId FROM your_table)\nORDER BY \n  missing_web_id;