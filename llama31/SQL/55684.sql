SELECT rownum\nFROM (\n  SELECT dog.id AS dogId\n  FROM CANINES dog\n  ORDER BY dog.codename ASC\n)\nWHERE dogId = 206;