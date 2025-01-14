WITH PagedResults AS (\n    SELECT \n        YourColumnsHere,\n        ROW_NUMBER() OVER (ORDER BY YourOrderByColumn) AS RowNum\n    FROM \n        YourTableName\n)\nSELECT \n    *\nFROM \n    PagedResults\nWHERE \n    RowNum BETWEEN @StartRow AND @EndRow;