-- Create a service account for the application\nCREATE LOGIN AppServiceAccount WITH PASSWORD = 'strong_password';\nCREATE USER AppServiceAccount FOR LOGIN AppServiceAccount;\n\n-- Grant necessary permissions to the service account\nGRANT EXECUTE ON SCHEMA::dbo TO AppServiceAccount;\n\n-- Create a role for users with specific permissions\nCREATE ROLE Users WITH AUTHORIZATION db_owner;\nGRANT SELECT, INSERT, UPDATE, DELETE ON SCHEMA::dbo TO Users;\n\n-- Add users to the role\nALTER ROLE Users ADD MEMBER [Domain\User1];\nALTER ROLE Users ADD MEMBER [Domain\User2];