USE master;\n   GO\n\n   CREATE LOGIN [IIS APPPOOL\DefaultAppPool] FROM WINDOWS WITH DEFAULT_DATABASE=[YourDatabaseName];\n   GO