SELECT ChargeNum, CategoryID, SUM(Hours) AS Hours\nFROM (\n    SELECT ChargeNum, CategoryID, Hours\n    FROM KnownHours\n    UNION ALL\n    SELECT ChargeNum, 'Unknown' AS CategoryID, Hours\n    FROM UnknownHours\n) combined_hours\nGROUP BY ChargeNum, CategoryID;