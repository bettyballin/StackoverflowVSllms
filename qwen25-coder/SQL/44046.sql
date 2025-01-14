SELECT \n    OBJECT_DEFINITION(OBJECT_ID(t1.name)) AS Routine_Definition\nFROM\n    [server1].MyDatabase.sys.procedures t1 \nLEFT JOIN\n    [server2].MyDatabase.sys.procedures t2 ON t1.name = t2.name\nWHERE\n    t2.name IS NULL;