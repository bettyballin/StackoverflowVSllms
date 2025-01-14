SELECT \n    p.ProductId,\n    p.ProductTitle,\n    p.Price,\n    pil.LookUpId,\n    i.FileID\nFROM \n    Products p\nJOIN \n    (SELECT ProductId, MIN(Order) AS MinOrder\n     FROM ProductImagesLookUp\n     GROUP BY ProductId) minOrders ON p.ProductId = minOrders.ProductId\nJOIN \n    ProductImagesLookUp pil ON minOrders.ProductId = pil.ProductId AND minOrders.MinOrder = pil.Order\nJOIN \n    Images i ON pil.FileID = i.FileID;