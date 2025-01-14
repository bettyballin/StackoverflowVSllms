WITH Ordered AS (\n    SELECT ROW_NUMBER() OVER (ORDER BY OrderID) AS RowNumber, *\n    FROM Orders\n)\nSELECT *\nFROM Ordered\nWHERE RowNumber = 1000000;