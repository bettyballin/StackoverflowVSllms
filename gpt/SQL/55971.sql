SELECT \n    'Test Name' AS TestName,\n    CASE \n        WHEN foo = 'Result' THEN 1 \n        ELSE 0 \n    END AS IsResult\nFROM \n    bar\nWHERE \n    baz = (some criteria);