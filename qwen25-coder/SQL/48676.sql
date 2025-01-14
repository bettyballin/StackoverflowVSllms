SELECT \n    SUM(\n        DATEDIFF(MINUTE, Start, \n            CASE \n                WHEN Stop = '12/31/9999' THEN GETDATE() \n                ELSE Stop \n            END\n        )\n    ) AS TotalElapsedMinutes\nFROM \n    YourTableName;