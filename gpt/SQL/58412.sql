SELECT Col1,\n       Col2,\n       Col3,\n       dbo.fn3(Col3) as Col4\nFROM   (\n    SELECT Col1,\n           Col2,\n           dbo.fn1(col2) as Col3\n    FROM   TestTable\n) AS SubQuery;