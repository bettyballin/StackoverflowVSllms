START TRANSACTION;\nINSERT INTO real_table (Item1, Item2, cnt)\nSELECT Item1, Item2, cnt\nFROM memory_table\nON DUPLICATE KEY UPDATE cnt = cnt + VALUES(cnt);\nCOMMIT;