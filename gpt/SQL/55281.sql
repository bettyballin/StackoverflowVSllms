WITH RankedRows AS (\n    SELECT\n        memID,\n        foo,\n        bar,\n        foobar,\n        ROW_NUMBER() OVER (PARTITION BY memID ORDER BY /* specify your ordering column here */) AS rn\n    FROM\n        your_table\n    WHERE\n        memID BETWEEN 0 AND 2 \n)\nSELECT\n    memID,\n    foo,\n    bar,\n    foobar\nFROM\n    RankedRows\nWHERE\n    rn <= 3;