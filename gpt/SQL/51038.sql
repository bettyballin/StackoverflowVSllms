USE master;\nGO\nSELECT \n    name AS [Database Name], \n    size * 8 / 1024 AS [Size (MB)] \nFROM sys.master_files\nWHERE type = 0;\nGO