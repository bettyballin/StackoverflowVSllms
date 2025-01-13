-- Create schemas\nCREATE SCHEMA UserSchema;\nCREATE SCHEMA OrderSchema;\nCREATE SCHEMA ProductSchema;\n\n-- Create roles\nCREATE ROLE UserRole;\nCREATE ROLE OrderRole;\nCREATE ROLE ProductRole;\n\n-- Grant permissions to roles\nGRANT SELECT, INSERT, UPDATE, DELETE ON SCHEMA::UserSchema TO UserRole;\nGRANT SELECT, INSERT, UPDATE, DELETE ON SCHEMA::OrderSchema TO OrderRole;\nGRANT SELECT, INSERT, UPDATE, DELETE ON SCHEMA::ProductSchema TO ProductRole;\n\n-- Assign roles to users\nALTER ROLE UserRole ADD MEMBER user1;\nALTER ROLE OrderRole ADD MEMBER user2;\nALTER ROLE ProductRole ADD MEMBER user3;