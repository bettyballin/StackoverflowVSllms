CREATE PROCEDURE sp_PivotData\nAS\nBEGIN\n    SELECT theID AS ID,\n           MAX(CASE WHEN theGroup = 2 THEN theValue END) AS CHOICE,\n           MAX(CASE WHEN theGroup = 3 THEN theValue END) AS COUNT,\n           MAX(CASE WHEN theGroup = 4 THEN theValue END) AS SORT\n    FROM YourTableName\n    GROUP BY theID;\nEND;