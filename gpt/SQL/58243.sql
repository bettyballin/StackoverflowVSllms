INSERT INTO my_table (f1, f2)\nSELECT f1, ADD_MONTHS(f2, 1)\nFROM my_table\nWHERE status = 'your_status_condition';