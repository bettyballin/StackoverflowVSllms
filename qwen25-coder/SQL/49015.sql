WITH RankedMembers AS (\n    SELECT memID, foo, bar, foobar,\n           ROW_NUMBER() OVER (PARTITION BY memID ORDER BY [some_column]) AS rn\n    FROM your_table\n    WHERE memID BETWEEN 1 AND 2\n)\nSELECT memID, foo, bar, foobar\nFROM RankedMembers\nWHERE rn <= 3;