SELECT p.id AS parent_id,\n       p.name AS parent_name,\n       c.id AS child_id,\n       c.name AS child_name,\n       c.age AS child_age\nFROM Persons p\nLEFT JOIN Persons c ON p.id = c.parent\nWHERE p.parent IS NULL\nORDER BY p.age, c.age;