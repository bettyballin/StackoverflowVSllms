WITH Atts AS \n(\n    SELECT\n    DISTINCT\n        at1.[Attribute]\n    FROM\n        Attribute at1\n    WHERE\n        at1.[Asset] = 'Asset-A'\n)\n\nSELECT \n    DISTINCT\n    Asset,\n    (\n        SELECT \n            COUNT(ta2.[Attribute]) \n        FROM \n            Attribute ta2 \n        INNER JOIN\n            Atts b \n            ON\n                b.[Attribute] = ta2.[attribute]\n        WHERE \n            ta2.[Asset] = ta.Asset\n    ) \n    AS [Count]\nFROM \n    Atts a\nINNER JOIN\n    Attribute ta\n    ON\n    a.[Attribute] = ta.[Attribute]