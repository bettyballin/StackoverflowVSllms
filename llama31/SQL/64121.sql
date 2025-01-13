-- Create a test database\nCREATE DATABASE TestDB;\nGO\n\n-- Create a table and insert some data\nUSE TestDB;\nCREATE TABLE TestTable (ID INT, Name VARCHAR(50));\nINSERT INTO TestTable (ID, Name) VALUES (1, 'John'), (2, 'Jane');\nGO\n\n-- Take a full backup\nBACKUP DATABASE TestDB TO DISK = 'C:\TestDB_Full.bak';\nGO\n\n-- Make schema changes (add a new table)\nCREATE TABLE NewTable (ID INT, Description VARCHAR(100));\nGO\n\n-- Insert data into the new table\nINSERT INTO NewTable (ID, Description) VALUES (1, 'New data');\nGO\n\n-- Take a differential backup\nBACKUP DATABASE TestDB TO DISK = 'C:\TestDB_Diff.bak' WITH DIFFERENTIAL;\nGO\n\n-- Verify the differential backup includes the new table and data\nRESTORE DATABASE TestDB FROM DISK = 'C:\TestDB_Full.bak' WITH NORECOVERY;\nRESTORE DATABASE TestDB FROM DISK = 'C:\TestDB_Diff.bak' WITH RECOVERY;\nGO\n\n-- Query the restored database to verify the new table and data\nSELECT * FROM NewTable;\nGO