DECLARE @UniqueID INT;\n\n-- Get the next unique ID\nEXEC GetNextUniqueID;\nSELECT @UniqueID = NewID FROM GetNextUniqueID;\n\n-- Insert the unique ID into one of your target tables\nINSERT INTO AssetInfrastructureTable1 (ID, Column1, Column2)\nVALUES (@UniqueID, 'Value1', 'Value2');