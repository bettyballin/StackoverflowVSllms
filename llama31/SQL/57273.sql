WITH BaseQuery AS (\n  SELECT \n    Column1 AS c1,\n    ...\n    ColumnN AS cN\n  FROM \n    database1.dbo.Table1\n  UNION\n  SELECT \n    'Some String' as c1,\n    ...\n    NULL as cN\n  FROM \n    database1.dbo.Table2\n)\nSELECT * FROM BaseQuery\nUNION\nSELECT * FROM BaseQuery\n  REPLACE 'database1' WITH 'database2'