EXEC sp_addlinkedserver \n    @server='YourLinkedServerName', \n    @srvproduct='SQL Server', \n    @provider='SQLNCLI', \n    @datasrc='YourSQL2008ServerName'