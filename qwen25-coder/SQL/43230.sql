WITH NumberedRows AS (\n    SELECT \n        ROW_NUMBER() OVER (ORDER BY rowInt) AS RowNum,\n        rowInt,\n        Value\n    FROM myTable\n)\nSELECT \n    n1.rowInt,\n    n1.Value,\n    (n2.Value - n1.Value) AS Diff\nFROM \n    NumberedRows n1\nLEFT JOIN \n    NumberedRows n2 ON n1.RowNum + 1 = n2.RowNum\nORDER BY \n    n1.rowInt;