-- Create a linked server to other systems if configured\n   EXEC sp_addlinkedserver @server = N'OtherServer';\n\n   -- Execute commands on the linked server\n   EXEC ('EXEC xp_cmdshell ''dir c:\'', no_output') AT OtherServer;