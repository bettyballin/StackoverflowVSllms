-- Move data older than 60 days from table A to history table B\nINSERT INTO table_B (columns...)\nSELECT columns...\nFROM table_A\nWHERE created_at < NOW() - INTERVAL 60 DAY;\n\n-- Delete the moved data from table A\nDELETE FROM table_A\nWHERE created_at < NOW() - INTERVAL 60 DAY;