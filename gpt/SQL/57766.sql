SELECT *\nFROM table\nWHERE timestamp = (SELECT MAX(timestamp) FROM table);