SELECT \n    USECOUNTS,\n    TYPE,\n    ObjType,\n    PAGESUSED,\n    text\nFROM \n    syscacheobjects\nWHERE \n    OBJTYPE = 'Proc'\n    AND text LIKE '%YourStoredProcedureName%'