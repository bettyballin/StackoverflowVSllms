-- Check roles for a specific user in a specific database\nUSE [YourDatabaseName];\nEXEC sp_helpuser 'YourUsername';\n\n-- Grant access if not already granted\nUSE [master];\nALTER SERVER ROLE [sysadmin] ADD MEMBER [YourUsername];\n\nUSE [YourDatabaseName];\nCREATE USER [YourUsername] FOR LOGIN [YourUsername];\nALTER ROLE db_datareader ADD MEMBER [YourUsername]; -- or another role as needed\n\n-- Check login status and default database\nSELECT * FROM sys.sql_logins WHERE name = 'YourUsername';\n\n-- Enable a disabled SQL Server login\nALTER LOGIN [YourUsername] WITH PASSWORD = N'NewStrongPassword!', CHECK_POLICY = ON;\nALTER LOGIN [YourUsername] ENABLE;\n\n-- Set the default database for a login\nALTER LOGIN [YourUsername] WITH DEFAULT_DATABASE=[YourDatabaseName];