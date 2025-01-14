-- Create test table\nCREATE TABLE [dbo].[TestTable](\n    [ID] [numeric](18, 0) IDENTITY(1,1) NOT NULL,\n    [Name] [varchar](50) NULL,\n CONSTRAINT [PK_TestTable] PRIMARY KEY CLUSTERED \n(\n    [ID] ASC\n)\n) \n\n-- Insert some data\nINSERT INTO TestTable (Name)\nVALUES ('One'), ('Two'), ('Three');\n\n-- Create empty temp table without identity property\nSELECT CAST(1 AS NUMERIC(18,0)) AS ID2, *\nINTO #Tmp\nFROM TestTable WHERE 1=0;\n\nALTER TABLE #Tmp DROP COLUMN ID;\n\n-- Insert data into the temporary table\nSET IDENTITY_INSERT #Tmp ON;\nINSERT INTO #Tmp (ID, Name)\nSELECT TOP 1 ID, Name FROM TestTable;\nSET IDENTITY_INSERT #Tmp OFF;\n\n-- Clean up test table\nDROP TABLE [dbo].[TestTable];\nGO