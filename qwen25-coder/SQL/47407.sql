-- Step 1: Perform nightly backup (on Production Server)\nBACKUP DATABASE [YourProductionDB] TO DISK = 'D:\Backups\YourProductionDB.bak' WITH COPY_ONLY;\n\n-- Step 2: Detach current database in dev environment if needed (optional, run manually or automated script on Dev Server)\nUSE master;\nGO\nsp_detach_db 'YourDevelopmentDB';\n\n-- This step requires file system access to move the backup to dev server. Use a task scheduler and robocopy/xcopy for automation.\n-- Robocopy command example (run this in Windows Task Scheduler):\n-- ROBOCOPY "ProductionServerD$\Backups\" "DevServerD$\Backups\" YourProductionDB.bak\n\n-- Step 3: Attach the database on Dev Environment from copied backup file\nCREATE DATABASE [YourDevelopmentDB] ON \n(FileName = 'D:\Data\YourProductionDB_Data.mdf'),\n(FileName = 'D:\Log\YourProductionDB_Log.ldf')\nFOR ATTACH_REBUILD_LOG;\n\nUSE YourDevelopmentDB;\nGO\n\n-- Example of clearing tables or data on dev environment as per the requirement\nTRUNCATE TABLE [LargeUselessLogsTable];\n\n-- Note: Ensure to handle transactions, logs, and file paths appropriately for your use case.