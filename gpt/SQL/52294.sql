WITH SUB1 AS (\n    -- Your first sub-query here\n    SELECT ID, Date FROM your_table1\n),\nSUB2 AS (\n    -- Your second sub-query here\n    SELECT ID, Date FROM your_table2\n)\nSELECT ID, Date\nFROM SUB1\nUNION\nSELECT ID, Date\nFROM SUB2\nWHERE ID NOT IN (SELECT ID FROM SUB1);