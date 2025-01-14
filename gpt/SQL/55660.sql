DECLARE @ActiveTable VARCHAR(50);\n     SELECT @ActiveTable = TableName FROM ActiveTable;\n\n     DECLARE @NonActiveTable VARCHAR(50) = CASE \n       WHEN @ActiveTable = 'ImportantTableA' THEN 'ImportantTableB'\n       ELSE 'ImportantTableA'\n     END;\n\n     -- Update Non-Active Table\n     -- Example update statement\n     INSERT INTO @NonActiveTable (Column1, Column2)\n     SELECT Column1, Column2 FROM SqlFoxProData.ImportantTable;