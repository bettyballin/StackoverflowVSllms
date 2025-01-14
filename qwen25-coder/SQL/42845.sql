CREATE PROCEDURE PivotData\nAS\nBEGIN\n    SELECT \n        theID AS ID,\n        [2] AS CHOICE,\n        [3] AS COUNT,\n        [4] AS SORT\n    FROM \n    (\n        SELECT theID, theGroup, theValue\n        FROM YourTableName\n    ) AS SourceTable\n    PIVOT\n    (\n        MAX(theValue)\n        FOR theGroup IN ([2], [3], [4])\n    ) AS PivotTable;\nEND