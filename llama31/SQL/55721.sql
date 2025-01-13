SELECT\n    P.Column1,\n    P.Column2,\n    P.Column3,\n    ...\n    (\n        SELECT\n            A.ColumnX,\n            A.ColumnY,\n            ...\n        FROM\n            dbo.TableReturningFunc1(@StaticParam1, @StaticParam2) AS A\n        WHERE\n            A.Key = P.Key\n        FOR XML AUTO, TYPE\n    ),\n    (\n        SELECT\n            B.ColumnX,\n            B.ColumnY,\n            ...\n        FROM\n            dbo.TableReturningFunc2(@StaticParam1, @StaticParam2) AS B\n        WHERE\n            B.Key = P.Key\n        FOR XML AUTO, TYPE\n    )\nFROM\n    (\n        <joined tables here>\n    ) AS P\nOPTION (HASH JOIN)\nFOR XML AUTO,ROOT('ROOT')