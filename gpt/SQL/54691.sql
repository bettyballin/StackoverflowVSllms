WITH LatestData AS (\n    SELECT\n        f1,\n        f2,\n        f3,\n        ROW_NUMBER() OVER (PARTITION BY f1 ORDER BY f3 DESC) AS rn\n    FROM\n        Server.DB.dbo.Table2\n)\nUPDATE b\nSET \n    b.f2 = c.f2,\n    b.f3 = CONVERT(varchar, c.f3, 101)\nFROM \n    Table1 b\nINNER JOIN \n    LatestData c ON b.f1 = c.f1\nWHERE \n    c.rn = 1;