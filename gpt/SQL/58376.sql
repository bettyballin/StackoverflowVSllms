WITH CTE AS (\n    SELECT \n        Id, \n        Status, \n        BatchRef, \n        ItemCount,\n        ROW_NUMBER() OVER (PARTITION BY Id ORDER BY Status DESC) AS rn\n    FROM \n        HistoryTable\n    WHERE \n        BatchRef = @BatchRef\n)\nSELECT \n    Id, \n    Status, \n    BatchRef, \n    ItemCount\nFROM \n    CTE\nWHERE \n    rn = 1;