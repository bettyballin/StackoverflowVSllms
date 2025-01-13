WITH table2_filtered AS (\n  SELECT person_uid, period, col2\n  FROM table2\n  WHERE period = (SELECT period FROM table1)\n)\nSELECT col1, col2\nFROM table1\nLEFT OUTER JOIN table2_filtered\nON table1.person_uid = table2_filtered.person_uid;