CREATE PROCEDURE GetOldRecords\nAS\nBEGIN\n    SELECT *\n    FROM YourTableName\n    WHERE CreateTime < DATEADD(HOUR, -78, GETUTCDATE());\nEND;