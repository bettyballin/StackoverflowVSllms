SELECT @sql = COALESCE(@sql, '') + '\n    EXEC sp_rename ''' + name + ''', ''FK_' + OBJECT_NAME(parent_object_id) + '_tblFooBar''\n'\nFROM sys.foreign_keys\nWHERE referenced_object_id = OBJECT_ID('tblFooBar');\n\nEXEC sp_executesql @sql;