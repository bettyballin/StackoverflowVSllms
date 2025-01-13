WITH MostRecentRows AS\n(\n    SELECT ID, Name, Data,\n    ROW_NUMBER() OVER (PARTITION BY Name ORDER BY TimeStamp DESC) AS 'RowNumber'\n    FROM MySchema.MyTable\n) \nSELECT * FROM MostRecentRows \nWHERE RowNumber = 1