USE master;\n   GO\n   SELECT name, state_desc\n   FROM sys.databases\n   WHERE name = 'YourDatabaseName';