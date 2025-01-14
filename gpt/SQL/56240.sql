IF EXISTS (\n    SELECT 1 \n    FROM sys.columns \n    WHERE object_id = OBJECT_ID(N'[dbo].[MyTable]')\n    AND name = N'Column1'\n)\nBEGIN\n    UPDATE [dbo].[MyTable] \n    SET [Column2] = [Column1]\n    WHERE [Column1] IS NOT NULL;\n\n    ALTER TABLE [dbo].[MyTable]\n    DROP COLUMN [Column1];\nEND