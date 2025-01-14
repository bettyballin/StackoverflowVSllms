SELECT \n    dp.type_desc AS PermissionType,\n    OBJECT_NAME(dp.major_id) AS TableName,\n    USER_NAME(dp.grantee_principal_id) AS GranteeUser\nFROM \n    sys.database_permissions dp\nWHERE \n    dp.major_id > 0  -- Filter out non-table permissions\nORDER BY \n    TableName, GranteeUser;