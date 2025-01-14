-- Assuming the main table is called 'MainTable' and the primary key column is 'Id'\n-- Also, assume there is a foreign key relationship with 'RelatedTable' on 'MainID'\n\nDECLARE @mainTableId INT = 1; -- The ID of the row you want to check\n\nIF EXISTS (\n    SELECT 1 \n    FROM RelatedTable\n    WHERE MainID = @mainTableId\n)\nBEGIN\n    PRINT 'Cannot delete because there are related records in RelatedTable.'\nEND\nELSE\nBEGIN\n    DELETE FROM MainTable WHERE Id = @mainTableId;\n    PRINT 'Row deleted successfully.'\nEND