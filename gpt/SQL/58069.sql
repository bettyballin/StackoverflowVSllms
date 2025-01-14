USE master;\n   GO\n\n   CREATE LOGIN [AppLogin] WITH PASSWORD = 'YourStrongPassword';\n   GO\n\n   CREATE USER [AppUser] FOR LOGIN [AppLogin];\n   GO\n\n   EXEC sp_addrolemember 'db_datareader', 'AppUser';\n   EXEC sp_addrolemember 'db_datawriter', 'AppUser';\n   GO\n\n   -- Allow connections only from a specific IP (Web Server IP)\n   ALTER LOGIN [AppLogin] WITH DEFAULT_DATABASE = [YourDatabase];\n   GO\n\n   -- Create a server-level firewall rule\n   EXEC sp_set_firewall_rule 'AllowWebServer', '192.168.1.100', '192.168.1.100';\n   GO