-- On SQL Server 2005, add SQL Server 2000 as a Linked Server\nEXEC sp_addlinkedserver \n    @server = 'OldServer',\n    @srvproduct = 'SQL Server';\n\nEXEC sp_addlinkedsrvlogin \n    @rmtsrvname = 'OldServer', \n    @useself = 'False', \n    @locallogin = NULL, \n    @rmtuser = 'YourRemoteUser', \n    @rmtpassword = 'YourRemotePassword';