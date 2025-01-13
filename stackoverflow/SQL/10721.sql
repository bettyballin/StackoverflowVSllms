SELECT c.ClaimNumber, a.ItemDate, c.DTN, b.FilePath\nFROM items a\nINNER JOIN itempages b ON b.ItemNum = a.ItemNum\nINNER JOIN keygroupdata c ON c.ItemNum = b.ItemNum\nWHERE a.ItemType IN (112,115,189,241)\nORDER BY a.DateStored DESC