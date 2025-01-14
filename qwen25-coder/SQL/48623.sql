USE [master];\n   GO\n   EXEC sp_addlinkedserver \n       @server = N'SecondServer', \n       @srvproduct=N'SQL Server';\n   GO\n\n   -- Set login and password for the second server\n   EXEC sp_addlinkedsrvlogin \n       @rmtsrvname = N'SecondServer', \n       @useself = N'False',\n       @locallogin = NULL,\n       @rmtuser='RemoteUser',\n       @rmtpassword='StrongPassword';\n   GO