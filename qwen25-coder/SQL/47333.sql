WITH filtered_items AS (\n    SELECT ItemNum, DateStored \n    FROM items \n    WHERE ItemType IN (112, 115, 189, 241)\n)\nSELECT c.ClaimNumber, a.ItemDate, c.DTN, b.FilePath\nFROM filtered_items a\nJOIN itempages b ON a.ItemNum = b.ItemNum\nJOIN keygroupdata c ON b.ItemNum = c.ItemNum\nORDER BY a.DateStored DESC;