DECLARE @BatchSize INT = 10000;\nDECLARE @LastProcessedID INT = 0;\nDECLARE @MaxID INT;\n\nSELECT @MaxID = MAX(iRowIndex) FROM MasterData;\n\nWHILE @LastProcessedID < @MaxID\nBEGIN\n    -- Process a batch of records\n    DECLARE cSource CURSOR LOCAL FORWARD_ONLY READ_ONLY\n    FOR\n    SELECT MD.sFieldName, \n           MD.sFieldValue, \n           TR.sTargetDataType,\n           MD2.sFieldValue AS sUniqueID,\n           TR.sTargetTableName,\n           TR.sTargetFieldName,\n           I.iRefCustomerID, \n           I.iInterfaceID, \n           IL.iRefInterfaceSessionID\n    FROM MasterData MD\n    JOIN MasterData MD2\n      ON MD.iRowIndex = MD2.iRowIndex\n     AND MD.iBatchNumber = MD2.iBatchNumber\n     AND MD.sTableName = MD2.sTableName \n     AND MD2.sFieldName = 'sUniqueID'\n    JOIN SourceTargetRelation TR\n      ON MD.sFieldName = TR.sSourceFieldName\n     AND MD.sTableName = TR.sSourceTableName\n    JOIN InterfaceLog IL\n      ON IL.iInterfaceLogID = MD.iBatchNumber\n    JOIN Interface I\n      ON I.iInterfaceID = IL.iRefInterfaceID\n     AND TR.iRefSystemID = I.iRefSystemID\n    WHERE MD.iBatchNumber = @iBatchNumber\n      AND MD.iRowIndex > @LastProcessedID\n      AND MD.iRowIndex <= @LastProcessedID + @BatchSize\n    ORDER BY MD.sTableName, MD.iRowIndex;\n\n    -- Process the cursor as usual\n    OPEN cSource;\n    FETCH NEXT FROM cSource INTO ...;\n    WHILE @@FETCH_STATUS = 0\n    BEGIN\n        -- Process each row\n        FETCH NEXT FROM cSource INTO ...;\n    END;\n    CLOSE cSource;\n    DEALLOCATE cSource;\n\n    -- Update the last processed ID\n    SELECT @LastProcessedID = ISNULL(MAX(iRowIndex), @LastProcessedID)\n    FROM MasterData\n    WHERE iRowIndex > @LastProcessedID AND iRowIndex <= @LastProcessedID + @BatchSize;\nEND;