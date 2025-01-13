SELECT\n    SQRT(\n        CASE\n            WHEN (ISNULL(POWER(ISNULL(val1X, 0), 2) + POWER(ISNULL(val1Y, 0), 2), 0) >\n                  ISNULL(POWER(ISNULL(val2X, 0), 2) + POWER(ISNULL(val2Y, 0), 2), 0))\n            THEN ISNULL(POWER(ISNULL(val1X, 0), 2) + POWER(ISNULL(val1Y, 0), 2), 0)\n            ELSE ISNULL(POWER(ISNULL(val2X, 0), 2) + POWER(ISNULL(val2Y, 0), 2), 0)\n        END\n    ) AS ResultVal\nFROM myTable;