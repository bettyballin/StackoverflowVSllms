DECLARE @sample_size INT = 5000;\nDECLARE @table_size INT = (SELECT COUNT(*) FROM your_table WHERE /* your constraints here */);\nDECLARE @random_start INT = ABS(CHECKSUM(NEWID())) % (@table_size - @sample_size);\n\nSELECT *\nFROM (\n  SELECT *, ROW_NUMBER() OVER (ORDER BY (SELECT 1)) AS row_num\n  FROM your_table\n  WHERE /* your constraints here */\n) AS subquery\nWHERE row_num >= @random_start AND row_num < @random_start + @sample_size;