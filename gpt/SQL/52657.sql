EXEC sp_addlinkedsrvlogin \n    @rmtsrvname = 'YourLinkedServerName', \n    @useself = 'false', \n    @locallogin = NULL, \n    @rmtuser = 'YourRemoteUsername', \n    @rmtpassword = 'YourRemotePassword';