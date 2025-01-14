USE [YourDatabaseName];\n   GO\n\n   CREATE USER [DefaultAppPoolUser] FOR LOGIN [IIS APPPOOL\DefaultAppPool];\n   GO\n\n   -- Grant SELECT, INSERT, UPDATE, DELETE or other required rights\n   GRANT SELECT, INSERT, UPDATE, DELETE ON SCHEMA::dbo TO [DefaultAppPoolUser];\n   GO