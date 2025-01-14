WITH CTE AS (\n    SELECT \n        ROW_NUMBER() OVER (ORDER BY NEWID()) AS RowNum,\n        Column1\n    FROM YourTable\n),\nCTE2 AS (\n    SELECT \n        ROW_NUMBER() OVER (ORDER BY NEWID()) AS RowNum,\n        Column2\n    FROM YourTable\n),\nCTE3 AS (\n    SELECT \n        ROW_NUMBER() OVER (ORDER BY NEWID()) AS RowNum,\n        Column3\n    FROM YourTable\n),\nCTE4 AS (\n    SELECT \n        ROW_NUMBER() OVER (ORDER BY NEWID()) AS RowNum,\n        Column4\n    FROM YourTable\n),\nCTE5 AS (\n    SELECT \n        ROW_NUMBER() OVER (ORDER BY NEWID()) AS RowNum,\n        Column5\n    FROM YourTable\n)\nSELECT \n    CTE.Column1,\n    CTE2.Column2,\n    CTE3.Column3,\n    CTE4.Column4,\n    CTE5.Column5\nFROM CTE\nJOIN CTE2 ON CTE.RowNum = CTE2.RowNum\nJOIN CTE3 ON CTE.RowNum = CTE3.RowNum\nJOIN CTE4 ON CTE.RowNum = CTE4.RowNum\nJOIN CTE5 ON CTE.RowNum = CTE5.RowNum;