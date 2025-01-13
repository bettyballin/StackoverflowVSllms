-- Create a Linked Server to the Oracle database\nEXEC sp_addlinkedserver \n    @server='ORACLE_DB', \n    @srvproduct='Oracle', \n    @provider='OraOLEDB.Oracle', \n    @datasrc='ORACLE_DB_ALIAS'\n\n-- Open a query on the Oracle database that returns a result set\nDECLARE @sql nvarchar(max)\nSET @sql = 'SELECT * FROM OPENQUERY(ORACLE_DB, ''SELECT * FROM YOUR_TABLE'')'\nEXEC sp_executesql @sql