-- Create a new database role named 'ObjectPermissionModifier'\nCREATE ROLE ObjectPermissionModifier;\n\n-- Grant SELECT, INSERT, UPDATE, DELETE on specific tables/schema to this role\nGRANT SELECT, INSERT, UPDATE, DELETE ON SCHEMA::YourSchema TO ObjectPermissionModifier;\n\n-- Grant ALTER permission on objects in the schema to this role so they can modify permissions\nGRANT ALTER ON SCHEMA::YourSchema TO ObjectPermissionModifier;\n\n-- Add developers to the new role\nALTER ROLE ObjectPermissionModifier ADD MEMBER YourDeveloperLogin;