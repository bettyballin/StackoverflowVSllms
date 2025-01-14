WITH RankedRows AS (\n    SELECT *,\n           ROW_NUMBER() OVER (ORDER BY [YourSortingColumn]) AS RowNum\n    FROM YourTable\n)\nDELETE FROM RankedRows\nWHERE RowNum > n;