USE YourDatabaseName;\nGO\n\n-- Grant db_datareader role which provides read access to tables/views\nEXEC sp_addrolemember 'db_datareader', 'YourUserName';\nGO\n\n-- Grant EXECUTE on all stored procedures. Adjust the filter as needed.\nDECLARE @sql NVARCHAR(MAX) = N'';\n\nSELECT @sql += N'\nGRANT EXEC ON ' + QUOTENAME(OBJECT_SCHEMA_NAME(object_id)) + '.' + QUOTENAME(name) + N' TO YourUserName;\n'\nFROM sys.procedures;\n\nEXEC sp_executesql @sql;\nGO