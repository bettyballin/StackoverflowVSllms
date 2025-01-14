WITH UserHistory AS (\n    SELECT \n        UserId, \n        CAST(CreationDate AS DATE) AS AccessDate\n    FROM \n        UserHistoryTable\n),\nRankedUserHistory AS (\n    SELECT \n        UserId,\n        AccessDate,\n        ROW_NUMBER() OVER (PARTITION BY UserId ORDER BY AccessDate) AS RowNum\n    FROM \n        UserHistory\n),\nGroupedUserHistory AS (\n    SELECT \n        UserId,\n        AccessDate,\n        RowNum,\n        DATEADD(DAY, -RowNum, AccessDate) AS GroupIdentifier\n    FROM \n        RankedUserHistory\n)\nSELECT \n    UserId,\n    MIN(AccessDate) AS StartDate,\n    MAX(AccessDate) AS EndDate,\n    COUNT(*) AS ContinuousDays\nFROM \n    GroupedUserHistory\nGROUP BY \n    UserId, GroupIdentifier\nHAVING \n    COUNT(*) >= @n\nORDER BY \n    UserId, StartDate;