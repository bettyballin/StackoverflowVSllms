-- Create a new database\nCREATE DATABASE YourDatabase;\n\n-- Detach the database\nEXEC sp_detach_db 'YourDatabase';\n\n-- Attach the database\nEXEC sp_attach_db @dbname = N'YourDatabase', \n    @filename1 = N'<path to YourDatabase.mdf>',\n    @filename2 = N'<path to YourDatabase_log.ldf>';