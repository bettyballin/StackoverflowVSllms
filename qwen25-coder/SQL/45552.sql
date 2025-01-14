WITH RankedCases AS (\n    SELECT \n        ID,\n        Case_ID,\n        Name,\n        Date,\n        Status,\n        Type,\n        ROW_NUMBER() OVER (PARTITION BY Case_ID ORDER BY Date ASC) AS RowNumber\n    FROM YourTable\n    WHERE Type = 'Support' AND Status = 'Start'\n)\nSELECT \n    rc.ID,\n    rc.Case_ID,\n    rc.Name,\n    rc.Date,\n    rc.Status,\n    rc.Type\nFROM RankedCases rc\nJOIN CaseTable ct ON rc.Case_ID = ct.Case_ID\nWHERE rc.RowNumber = 1 AND ct.Date BETWEEN DATEADD(MONTH, -1, GETDATE()) AND GETDATE();