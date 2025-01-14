-- Grant SELECT, INSERT, UPDATE, DELETE permissions for a user\nUSE [YourDatabaseName];\nGRANT SELECT TO [YourUserName];\nGRANT INSERT TO [YourUserName];\nGRANT UPDATE TO [YourUserName];\nGRANT DELETE TO [YourUserName];\n\n-- Or use a role with the necessary permissions\nCREATE ROLE db_data_access;\nALTER ROLE db_data_access ADD MEMBER [YourUserName];\nGRANT SELECT, INSERT, UPDATE, DELETE ON SCHEMA::dbo TO db_data_access;