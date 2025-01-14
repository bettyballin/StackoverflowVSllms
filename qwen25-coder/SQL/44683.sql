USE YourDatabaseName;\nGO\n\n-- Disable constraints and triggers to allow dropping of tables with relationships or dependencies\nEXEC sp_msforeachtable 'ALTER TABLE ? NOCHECK CONSTRAINT ALL';\nEXEC sp_msforeachtable 'ALTER TABLE ? DISABLE TRIGGER ALL';\n\n-- Drop all non-system objects in the database\nDECLARE @name NVARCHAR(128)\nDECLARE @type CHAR(2)\n\nDECLARE db_cursor CURSOR FOR \nSELECT name, type FROM sys.objects WHERE type IN ('U', 'P', 'V', 'FN', 'IF', 'TF', 'TR') ORDER BY type\n\nOPEN db_cursor  \nFETCH NEXT FROM db_cursor INTO @name, @type  \n\nWHILE @@FETCH_STATUS = 0  \nBEGIN   \n    IF @type = 'U'\n        DECLARE @disableFKs nvarchar(max)\n        SELECT @disableFKs = 'ALTER TABLE [' + SCHEMA_NAME(schema_id) + '].[' + object_name(object_id) + '] NOCHECK CONSTRAINT ALL;'\n        EXEC sp_executesql @disableFKs\n\n       EXEC('DROP TABLE [' + SCHEMA_NAME(schema_id) + '].[' + object_name(object_id) + ']')\n    ELSE IF @type = 'P'\n         EXEC('DROP PROCEDURE [' + SCHEMA_NAME(schema_id) + '].[' + object_name(object_id) + ']')\n    ELSE IF @type = 'V'\n         EXEC('DROP VIEW [' + SCHEMA_NAME(schema_id) + '].[' + object_name(object_id) + ']')\n    ELSE IF @type IN ('FN', 'IF', 'TF')\n         EXEC('DROP FUNCTION [' + SCHEMA_NAME(schema_id) + '].[' + object_name(object_id) + ']')\n    ELSE IF @type = 'TR'\n         EXEC('DROP TRIGGER [' + SCHEMA_NAME(schema_id) + '].[' + object_name(object_id) + ']')\n\n    FETCH NEXT FROM db_cursor INTO @name, @type  \nEND \n\nCLOSE db_cursor  \nDEALLOCATE db_cursor\n\n-- Drop all full-text catalogs\nDECLARE @FTCatalogName sysname;\nDECLARE FTCatalogs CURSOR FOR \nSELECT name FROM sys.fulltext_catalogs ORDER BY name;\n\nOPEN FTCatalogs;\nFETCH NEXT FROM FTCatalogs INTO @FTCatalogName;\n\nWHILE @@FETCH_STATUS = 0  \nBEGIN   \n    EXEC('DROP FULLTEXT CATALOG ' + QUOTENAME(@FTCatalogName)) \n    FETCH NEXT FROM FTCatalogs INTO @FTCatalogName; \nEND \n\nCLOSE FTCatalogs;\nDEALLOCATE FTCatalogs;\n\n-- Drop all users except dbo\nDECLARE @userName NVARCHAR(128)\nDECLARE UserCursor CURSOR FOR \nSELECT name FROM sys.database_principals WHERE type IN ('U', 'S') AND name NOT IN ('dbo')\n\nOPEN UserCursor  \nFETCH NEXT FROM UserCursor INTO @userName  \n\nWHILE @@FETCH_STATUS = 0  \nBEGIN   \n    EXEC('DROP USER [' + QUOTENAME(@userName) + ']')\n    FETCH NEXT FROM UserCursor INTO @userName  \nEND \n\nCLOSE UserCursor  \nDEALLOCATE UserCursor\n\n-- Re-enable constraints and triggers\nEXEC sp_msforeachtable 'ALTER TABLE ? CHECK CONSTRAINT ALL';\nEXEC sp_msforeachtable 'ALTER TABLE ? ENABLE TRIGGER ALL';