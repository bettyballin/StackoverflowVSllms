SELECT *\nFROM your_table_name\nWHERE your_timestamp_column < CAST(CAST(GETDATE() AS DATE) AS DATETIME)