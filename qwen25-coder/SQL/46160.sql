-- Batch 1: Declare and set the value in a global temporary table\nIF OBJECT_ID('tempdb..##temp') IS NOT NULL DROP TABLE ##temp;\nCREATE TABLE ##temp (DB_Name sysname);\nINSERT INTO ##temp (DB_Name) VALUES ('SweetDB');\n\nGO\n\n-- Batch 2: Use the value from the global temporary table\nUSE [$(SELECT DB_Name FROM ##temp)];\nGO\n\n-- Batch 3: Insert values using the database name stored in the global temporary table\nDECLARE @db_name sysname;\nSET @db_name = (SELECT DB_Name FROM ##temp);\n\nINSERT INTO [@db_name].[dbo].[ProjectVersion] ([DB_Name], [Script]) VALUES (@db_name, '1.2');\n\nGO\n\n-- Cleanup: Drop the global temporary table\nIF OBJECT_ID('tempdb..##temp') IS NOT NULL DROP TABLE ##temp;