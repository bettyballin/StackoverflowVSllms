SELECT\n    column1,\n    column2,\n    CASE\n        WHEN column2 = 0 THEN NULL\n        ELSE column1 / column2\n    END AS result\nFROM\n    your_table;