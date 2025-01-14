SELECT row_num\nFROM (\n  SELECT dog.id AS dogId, ROW_NUMBER() OVER (ORDER BY dog.codename ASC) AS row_num\n  FROM CANINES dog\n)\nWHERE dogId = 206;