-- Using CAST\nSELECT CAST(your_datetime_column AS DATE) AS DateOnly\nFROM your_table;\n\n-- Using CONVERT\nSELECT CONVERT(DATE, your_datetime_column, 101) AS DateOnly\nFROM your_table;