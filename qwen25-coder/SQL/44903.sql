-- Update all statistics in the database\nEXEC sp_updatestats;\n\n-- Check for integrity issues\nDBCC CHECKDB ('YourDatabaseName') WITH ALL_ERRORMSGS;