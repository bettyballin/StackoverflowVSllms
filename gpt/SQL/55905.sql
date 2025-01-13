WITH RECURSIVE DateRange AS (\n    SELECT '2009-01-01' AS Date\n    UNION ALL\n    SELECT DATE_ADD(Date, INTERVAL 1 DAY)\n    FROM DateRange\n    WHERE Date < '2009-01-13'\n)\nSELECT Date\nFROM DateRange;