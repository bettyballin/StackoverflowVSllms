WITH NumberedAccess AS (\n    SELECT \n        UserId,\n        CreationDate,\n        DATEADD(day, -ROW_NUMBER() OVER (PARTITION BY UserId ORDER BY CreationDate), CreationDate) AS grp\n    FROM \n        UserHistory\n),\nSequentialDays AS (\n    SELECT \n        UserId,\n        COUNT(*) AS ConsecutiveDays\n    FROM \n        NumberedAccess\n    GROUP BY \n        UserId, grp\n)\nSELECT \n    UserId\nFROM \n    SequentialDays\nWHERE \n    ConsecutiveDays >= n;