-- Create a new SQL Server login\nCREATE LOGIN NewLogin WITH PASSWORD = 'StrongP@ssw0rd!';\n\n-- Use the desired database\nUSE YourDatabaseName;\n\n-- Create a user in specified database mapped to the login\nCREATE USER NewUser FOR LOGIN NewLogin;