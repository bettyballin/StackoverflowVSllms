SELECT \n    *\nFROM \n    myTable\nWHERE \n    field1 LIKE 'match0'\n    AND EXISTS (SELECT 1 WHERE myfunc(t1.hardwareConfig) LIKE 'match1')