WITH UserCTE AS (\n    SELECT \n        username,\n        ROW_NUMBER() OVER (ORDER BY username) AS RowNum\n    FROM \n        Users\n)\nSELECT \n    username\nFROM \n    UserCTE\nWHERE \n    RowNum BETWEEN @StartRow AND @EndRow\nORDER BY \n    RowNum;