WITH RankedUsers AS (\n    SELECT Username, Firstname, Lastname,\n           ROW_NUMBER() OVER (PARTITION BY Username ORDER BY (SELECT NULL)) AS rn\n    FROM tempUsers\n)\nSELECT Username, Firstname, Lastname\nFROM RankedUsers\nWHERE rn = 1;