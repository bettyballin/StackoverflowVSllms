SELECT CAST(CONVERT(VARBINARY, \n                    SUBSTRING(CONVERT(VARCHAR(8), signal_data, 2), 5, 2), \n                    2) AS INT) AS Signal\nFROM your_table;