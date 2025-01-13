WITH PaginatedQuery AS (\n  SELECT \n    *,\n    ROW_NUMBER() OVER (ORDER BY column_name) AS row_num,\n    COUNT(*) OVER () AS total_rows\n  FROM \n    table_name\n)\nSELECT \n  *\nFROM \n  PaginatedQuery\nWHERE \n  row_num BETWEEN @start_row AND @end_row;