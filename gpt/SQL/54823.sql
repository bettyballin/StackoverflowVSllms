DECLARE @start_time DATETIME;\n\nSET @start_time = GETDATE();\n\n-- Your query\nSELECT * FROM @search_temp_table;\n\n-- Calculate and display the time taken in milliseconds\nSELECT DATEDIFF(MILLISECOND, @start_time, GETDATE()) AS TimeTaken;