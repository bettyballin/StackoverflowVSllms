SELECT \n    OBJECT_NAME(parent_id) AS TableName,\n    OBJECT_SCHEMA_NAME(parent_id) AS TableSchema\nFROM \n    sys.triggers\nWHERE \n    object_id = @@PROCID