WITH OrderedData AS (\n    SELECT DISTINCT c.CN as ClaimNumber, \n                    a.ItemDate as BillReceivedDate, \n                    c.DTN as DocTrackNumber\n    FROM ItemData a\n    JOIN ItemDataPage b ON a.ItemNum = b.ItemNum\n    JOIN KeyGroupData c ON b.ItemNum = c.ItemNum\n    WHERE a.ItemTypeNum in (112, 113, 116, 172, 189)\n)\nSELECT ClaimNumber, BillReceivedDate, DocTrackNumber\nFROM OrderedData\nORDER BY DateStored DESC;