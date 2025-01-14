IF EXISTS (\n    SELECT 1 \n    FROM sys.all_columns \n    WHERE object_id = OBJECT_ID(N'[dbo].[MyTable]')\n    AND name = 'Column1'\n)\nBEGIN\n    -- Ensure the table exists and Column1 is indeed present before updating.\n    UPDATE [dbo].[MyTable] \n    SET [Column2] = [Column1]\n\n    --- Drop the column after data has been moved safely to another column.\n    ALTER TABLE [dbo].[MyTable]\n    DROP COLUMN [Column1]\nEND