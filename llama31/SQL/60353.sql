-- Create a linked server\nEXEC sp_addlinkedserver \n    @server = 'RemoteServer', \n    @srvproduct = 'SQL Server'\n\n-- Query the linked server\nSELECT * \nFROM [RemoteServer].[DatabaseName].[SchemaName].[TableName]