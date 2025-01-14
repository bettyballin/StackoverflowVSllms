DECLARE @TmpTable TABLE (GFSID INT, Quantity INT, ShoppingCartItemID INT)\n\n-- Insert the rows to be processed into the temporary table\nINSERT INTO @TmpTable (GFSID, Quantity, ShoppingCartItemID)\nSELECT GFSID, Quantity, ShoppingCartItemID\nFROM ShoppingCartItem\nWHERE PurchID = @PurchID\n\n-- Process rows from the temporary table\nWHILE EXISTS (SELECT 1 FROM @TmpTable)\nBEGIN\n    -- Select the top row from the temporary table\n    SELECT TOP 1 \n        @TmpGFSID = GFSID, \n        @TmpQuantity = Quantity,\n        @TmpShoppingCartItemID = ShoppingCartItemID\n    FROM @TmpTable\n\n    -- Call the stored procedure\n    EXEC @ErrorCode = spGoodsForSale_ReverseReservations @TmpGFSID, @TmpQuantity\n    IF @ErrorCode <> 0\n    BEGIN\n        GOTO Cleanup    \n    END\n\n    -- Delete the processed row from the original table\n    DELETE FROM ShoppingCartItem \n    WHERE ShoppingCartItemID = @TmpShoppingCartItemID\n\n    -- Remove the processed row from the temporary table\n    DELETE FROM @TmpTable \n    WHERE ShoppingCartItemID = @TmpShoppingCartItemID\nEND\n\nCleanup:\n-- Your cleanup code here