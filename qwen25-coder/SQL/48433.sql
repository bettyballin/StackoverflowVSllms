BEGIN TRANSACTION;\n\n-- Modify column\nALTER TABLE CustomizableTable ALTER COLUMN __asdf VarChar(50) NULL;\n\n-- Create index if not exists\nIF NOT EXISTS (SELECT * FROM sys.indexes WHERE object_id = OBJECT_ID(N'[dbo].[CustomizableTable]') AND name = N'idx___asdf')\n    CREATE NONCLUSTERED INDEX idx___asdf ON CustomizableTable (__asdf ASC);\n\n-- Update columns with NULL values\nUPDATE CustomizableTable SET [__asdf] = '' WHERE [__asdf] IS NULL;\n\nCOMMIT TRANSACTION;