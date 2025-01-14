-- Set the database to SINGLE_USER mode\nALTER DATABASE YourDatabaseName SET SINGLE_USER WITH ROLLBACK IMMEDIATE;\n\n-- Now restore your database here\nRESTORE DATABASE YourDatabaseName FROM DISK = 'C:\Backups\YourBackupFile.bak' WITH REPLACE;\n\n-- Optionally, set it back to MULTI_USER mode\nALTER DATABASE YourDatabaseName SET MULTI_USER;