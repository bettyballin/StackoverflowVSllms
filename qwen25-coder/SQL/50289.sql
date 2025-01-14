DECLARE @searchString NVARCHAR(100) = ''; -- Set your search string here\n\nSELECT \n    Column1, \n    Column2,  -- Add other columns as necessary\n    CAST(NULL AS INT) AS Rank,\n    1 AS Priority  -- Higher priority for exact match by PK\nFROM \n    YourTable\nWHERE \n    TRY_CAST(@searchString AS INT) = ID AND @searchString <> ''\n\nUNION ALL\n\nSELECT \n    t.Column1, \n    t.Column2,  -- Add other columns as necessary\n    ft.Rank,\n    2 AS Priority  -- Lower priority for full text search results\nFROM \n    FREETEXTTABLE(YourTable, (ColumnToSearch), @searchString) AS ft\nINNER JOIN \n    YourTable t ON ft.[KEY] = t.ID\nORDER BY \n    Priority ASC, \n    ISNULL(Rank, 1000) ASC;  -- Assuming the highest Rank would be less than 1000