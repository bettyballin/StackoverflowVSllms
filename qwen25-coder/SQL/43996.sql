-- Creating a new login and assigning it to a database role\n     CREATE LOGIN [YourUsername] WITH PASSWORD=N'YourStrongPassword';\n     USE YourDatabaseName;\n     CREATE USER [YourUsername] FOR LOGIN [YourUsername];\n     ALTER ROLE [db_datareader] ADD MEMBER [YourUsername]; -- Or other relevant roles