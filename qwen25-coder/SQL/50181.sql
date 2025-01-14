SELECT \n    t1.name, \n    COALESCE(COUNT(t2.id), 0) AS count\nFROM \n    t1\nLEFT JOIN \n    t2 ON t2.id = t1.id\nGROUP BY \n    t1.name\nORDER BY \n    count DESC; -- you can change this to ORDER BY t1.name ASC for sorting by name