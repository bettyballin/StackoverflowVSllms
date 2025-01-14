USE YourDatabaseName;\nGO\n\n-- Create a new database role for read and write access\nCREATE ROLE db_appuser;\n\n-- Grant appropriate permissions to this role\nGRANT SELECT, INSERT, UPDATE, DELETE ON SCHEMA::dbo TO db_appuser;\n\n-- Add the application user to this limited role instead of db_owner\nALTER ROLE db_appuser ADD MEMBER YourApplicationUser;\nGO