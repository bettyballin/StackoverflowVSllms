UPDATE your_table\nSET inuse = CASE\n    WHEN id = ? THEN 1\n    ELSE 0\nEND;