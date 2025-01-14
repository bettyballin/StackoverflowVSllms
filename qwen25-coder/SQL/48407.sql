DECLARE ItemCursor CURSOR FAST_FORWARD READ_ONLY FOR \n    SELECT ItemID FROM #Items ORDER BY SomeOrderColumn;\n\nDECLARE @CurrentItemID INT;\nDECLARE @ValidationResult BIT; -- Adjust type as per your validation logic\n\nOPEN ItemCursor;\n\nFETCH NEXT FROM ItemCursor INTO @CurrentItemID;\n\nWHILE @@FETCH_STATUS = 0\nBEGIN\n    EXEC ValidateItemProcedure @CurrentItemID, @ValidationResult OUTPUT;\n    \n    INSERT INTO #Validation (ItemID, ValidationResult)\n    VALUES (@CurrentItemID, @ValidationResult);\n\n    FETCH NEXT FROM ItemCursor INTO @CurrentItemID;\nEND\n\nCLOSE ItemCursor;\nDEALLOCATE ItemCursor;