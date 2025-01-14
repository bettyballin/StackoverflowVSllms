WITH CTE AS (\n    SELECT \n        t2.*,\n        t1.Column AS tmp\n    FROM \n        Table2 t2\n    INNER JOIN \n        Table1 t1 ON t1.Table2Id = t2.Id\n)\nSELECT *\nFROM CTE\nWHERE tmp = 1;