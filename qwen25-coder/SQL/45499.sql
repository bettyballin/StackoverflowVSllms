-- Create a login for NT AUTHORITY\NETWORK SERVICE if it does not exist\nUSE master;\nGO\n\nIF NOT EXISTS (SELECT * FROM sys.sql_logins WHERE name = 'NT AUTHORITY\NETWORK SERVICE')\nBEGIN\n    CREATE LOGIN [NT AUTHORITY\NETWORK SERVICE] FROM WINDOWS;\nEND\n\n-- Map the login to your database and add a user with db_datareader and db_datawriter roles\nUSE myDbName; -- Replace with your actual database name\nGO\n\nIF NOT EXISTS (SELECT * FROM sys.database_principals WHERE name = 'NT AUTHORITY\NETWORK SERVICE')\nBEGIN\n    CREATE USER [NT AUTHORITY\NETWORK SERVICE] FOR LOGIN [NT AUTHORITY\NETWORK SERVICE];\n    EXEC sp_addrolemember N'db_datareader', N'NT AUTHORITY\NETWORK SERVICE';\n    EXEC sp_addrolemember N'db_datawriter', N'NT AUTHORITY\NETWORK SERVICE';\nEND\nGO