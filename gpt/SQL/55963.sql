-- Script to generate login creation scripts\nDECLARE @sql NVARCHAR(MAX) = N'';\nSELECT @sql += 'CREATE LOGIN [' + name + '] \n    WITH PASSWORD = ''<password>'', \n    SID = ' + CONVERT(VARCHAR(MAX), sid, 1) + ', \n    DEFAULT_DATABASE = [' + default_database_name + '], \n    CHECK_POLICY = ' + CASE WHEN is_policy_checked = 1 THEN 'ON' ELSE 'OFF' END + ';'\nFROM sys.sql_logins\nWHERE name NOT IN ('sa');\n\n-- Print or execute the generated script\nPRINT @sql;\n-- EXEC sp_executesql @sql;