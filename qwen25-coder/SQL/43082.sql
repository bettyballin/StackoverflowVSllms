WITH RankedStatus AS (\n    SELECT \n        [Date], \n        User, \n        Status, \n        Notes,\n        ROW_NUMBER() OVER (PARTITION BY User ORDER BY [Date] DESC) AS rn\n    FROM \n        YourTableName -- Replace with your actual table name\n)\nSELECT \n    [Date], \n    User, \n    Status, \n    Notes\nFROM \n    RankedStatus\nWHERE \n    rn = 1;