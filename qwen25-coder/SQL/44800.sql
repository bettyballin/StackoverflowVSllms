WITH TimeIntervals AS (\n    SELECT \n        DATEADD(MINUTE, 30 * (N - 1), '2009-05-11 00:00:00.000') AS TimeInterval,\n        CAST(N AS INT) AS IntervalID,\n        0 AS Val\n    FROM (\n        SELECT ROW_NUMBER() OVER(ORDER BY (SELECT NULL)) AS N\n        FROM master..spt_values\n        WHERE type = 'P' AND number < 48 -- For 24 hours with half-hour intervals\n    ) AS Numbers\n)\nSELECT \n    ti.TimeInterval,\n    ti.IntervalID,\n    COALESCE(q2.Val, 0) AS Val2\nFROM \n    TimeIntervals ti\nLEFT JOIN \n    (SELECT * FROM (\n        VALUES \n            (3, 23), (9, 29), (10, 32),\n            (3, 21), (18, 33)\n    ) AS Query2(ID, Val)) q2\nON \n    ti.IntervalID = q2.ID;