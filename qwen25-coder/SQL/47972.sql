USE master;\nGO\n\nSELECT 'CREATE LOGIN [' + name + '] WITH PASSWORD = ''' + CONVERT(nvarchar(max), password_hash, 2) +\n       ''', SID = ' + CONVERT(varchar(180), sid, 1) +\n       ', DEFAULT_DATABASE = [' + COALESCE(default_database_name,'master') + '], ' +\n       'CHECK_POLICY = ON, CHECK_EXPIRATION = OFF;'\nFROM sys.sql_logins\nWHERE type IN ('S', 'U')\nAND name NOT LIKE '##%'