EXEC sp_addlinkedserver \n   @server = 'ORACLE_LINKED_SERVER',\n   @srvproduct = 'Oracle',\n   @provider = 'OraOLEDB.Oracle',\n   @datasrc = 'YourOracleDataSource';\n\nEXEC sp_addlinkedsrvlogin \n   @rmtsrvname = 'ORACLE_LINKED_SERVER', \n   @useself = 'false', \n   @rmtuser = 'YourUsername', \n   @rmtpassword = 'YourPassword';