-- Assuming 'YourFile' is the logical name of your data file you want to migrate.\nDBCC SHRINKFILE (N'YourFile', EMPTYFILE);\n\n-- Ensure the transaction log is truncated and backed up if needed, as it may grow during this process.\n-- Backup the database after shrinking files.\nBACKUP DATABASE YourDatabaseName TO DISK = 'Path\To\Backup\File.bak';