DECLARE @cursor CURSOR FOR\nSELECT \n    ShoppingCartItem.GFSID, \n    ShoppingCartItem.Quantity,\n    ShoppingCartItem.ShoppingCartItemID\nFROM \n    ShoppingCartItem \nWHERE \n    ShoppingCartItem.PurchID = @PurchID\n\nOPEN @cursor\n\nFETCH NEXT FROM @cursor INTO @TmpGFSID, @TmpQuantity, @TmpShoppingCartItemID\n\nWHILE @@FETCH_STATUS = 0\nBEGIN\n    EXEC @ErrorCode = spGoodsForSale_ReverseReservations @TmpGFSID, @TmpQuantity\n    IF @ErrorCode <> 0\n    BEGIN\n        Goto Cleanup    \n    END\n\n    DELETE FROM ShoppingCartItem WHERE ShoppingCartItem.ShoppingCartItemID = @TmpShoppingCartItemID\n\n    FETCH NEXT FROM @cursor INTO @TmpGFSID, @TmpQuantity, @TmpShoppingCartItemID\nEND\n\nCLOSE @cursor\nDEALLOCATE @cursor