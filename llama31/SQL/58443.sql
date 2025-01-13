UPDATE p\nSET UniqueName = UniqueName + \n    CASE \n        WHEN ROW_NUMBER() OVER (PARTITION BY UniqueName ORDER BY UniqueName) > 1 \n        THEN CONVERT(VARCHAR(10), ROW_NUMBER() OVER (PARTITION BY UniqueName ORDER BY UniqueName) - 1)\n        ELSE ''\n    END\nFROM \n    Persons p;