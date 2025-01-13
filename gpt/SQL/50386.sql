-- Step 1: Backup the database\nBACKUP DATABASE [YourDatabaseName] TO DISK = 'C:\Backup\YourDatabaseName.bak';\n\n-- Step 2: Set the recovery model to SIMPLE\nALTER DATABASE [YourDatabaseName] SET RECOVERY SIMPLE;\n\n-- Step 3: Shrink the log file\nDBCC SHRINKFILE (YourLogFileName_Log, 1);  -- Replace 'YourLogFileName_Log' with your actual log file name\n\n-- Step 4: Set the recovery model back to FULL if needed\nALTER DATABASE [YourDatabaseName] SET RECOVERY FULL;