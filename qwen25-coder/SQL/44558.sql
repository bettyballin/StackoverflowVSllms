SELECT \n    @@SERVERNAME AS CurrentServerName,\n    ISNULL((SELECT TOP 1 member_name FROM sys.dm_hadr_cluster_members WHERE role_description = 'Owner'), N'Not in cluster or No data') AS ActiveNodeName