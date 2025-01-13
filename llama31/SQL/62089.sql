WITH Parent AS\n(\n    SELECT\n        table2.Key,\n        cast(table2.Key as varchar(128))  AS Path\n    FROM\n        table2\n    WHERE\n        table2.ParentKey IS NULL\n\n   UNION ALL\n\n    SELECT\n        TH.Key,\n        CONVERT(varchar(128), Parent.Path + ',' + CONVERT(varchar(128),TH.Key)) AS Path\n    FROM\n        table2 TH\n    INNER JOIN\n        Parent\n    ON\n        Parent.Key = TH.ParentKey\n)\nSELECT t1.* \nFROM table1 t1\nJOIN table3 t3 ON t1.Key = t3.Table1Key\nJOIN Parent p ON t3.Table2Key = p.Key\nWHERE p.Path NOT LIKE '%2,%'  -- exclude branches with parent key 2