EXEC sp_addlinkedserver \n    @server = 'SourceServerName', \n    @srvproduct = '', \n    @provider = 'SQLNCLI', \n    @datasrc = 'SourceServerName';\n\nEXEC sp_addlinkedsrvlogin \n    @rmtsrvname = 'SourceServerName', \n    @useself = 'false', \n    @rmtuser = 'sourceUsername', \n    @rmtpassword = 'sourcePassword';