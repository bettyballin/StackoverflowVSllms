SELECT \n    OBJECT_NAME(fk.constid) AS ForeignKeyName,\n    OBJECT_NAME(fk.parent_obj) AS TableName\nFROM \n    sysforeignkeys fk\nINNER JOIN \n    sysreferences r ON fk.constid = r.constid\nWHERE \n    r.rkeyid = OBJECT_ID('foo')