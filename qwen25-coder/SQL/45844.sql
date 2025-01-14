SELECT \n  A.id AS aid,\n  GROUP_CONCAT(B.id ORDER BY B.id SEPARATOR ',') AS bid\nFROM \n  A\nLEFT JOIN \n  B ON B.aid = A.id\nWHERE \n  A.id = 1\nGROUP BY \n  A.id;