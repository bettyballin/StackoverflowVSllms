SELECT \n    ROW_NUMBER() OVER (ORDER BY id) AS row_counter,\n    id,\n    name\nFROM \n    users\nWHERE \n    group = 2