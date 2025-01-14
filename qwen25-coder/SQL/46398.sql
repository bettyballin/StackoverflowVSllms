SELECT t1.FieldName\nFROM TableName AS t1\nLEFT JOIN (\n    SELECT DISTINCT UPPER(FieldName2) + '%' AS PrefixPattern\n    FROM TableName2\n) AS t2 ON LEFT(UPPER(t1.ColumnName), LEN(t2.PrefixPattern) - 1) = SUBSTRING(t2.PrefixPattern, 1, LEN(t2.PrefixPattern) - 1)\nWHERE t2.PrefixPattern IS NULL;