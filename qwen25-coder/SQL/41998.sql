USE [master];\nGO\n-- This is okay for server-level roles or logins\nCREATE LOGIN myUser WITH PASSWORD = 'StrongPassword123!'; -- Example login creation\nGO\n\nUSE [prodDb];\nGO\n-- Grant CREATE VIEW permission in the specific database\nGRANT CREATE VIEW TO [myUser];\nGO