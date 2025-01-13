WITH Refs AS (\n  SELECT id, ref,\n         LEN(ref) - LEN(REPLACE(ref, LEFT(ref, 1), '')) AS CommonPrefixLength\n  FROM tableA\n),\nRefsWithPrefixRemoved AS (\n  SELECT id, \n         RIGHT(ref, LEN(ref) - MIN(CommonPrefixLength) OVER (PARTITION BY id)) AS ref\n  FROM Refs\n)\nSELECT id, \n       STUFF((SELECT '/' + ref \n              FROM RefsWithPrefixRemoved r2\n              WHERE r2.id = r1.id\n              FOR XML PATH('')), 1, 1, '') AS refs\nFROM RefsWithPrefixRemoved r1\nGROUP BY id;