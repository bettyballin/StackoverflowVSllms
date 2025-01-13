CREATE FUNCTION dbo.wtfunc (@s VARCHAR(50))\nRETURNS VARCHAR(10)\nAS\nBEGIN\n    RETURN LEFT(@s, 2);\nEND\nGO\n\nSELECT t.* INTO #test FROM (\n    SELECT 'blah' AS s UNION\n    SELECT 'foo' UNION\n    SELECT 'bar'\n) t;\n\nSELECT * FROM #test;\n\nDECLARE @s VARCHAR(100); \nSET @s = '';\n\n-- Concatenate without a function in ORDER BY\nSELECT @s = @s + s FROM #test ORDER BY s;\nSELECT @s;\n\nSET @s = '';\n\n-- Concatenate with a function in ORDER BY using FOR XML PATH\nSELECT @s = (\n    SELECT s + ''\n    FROM #test\n    ORDER BY dbo.wtfunc(s)\n    FOR XML PATH('')\n);\nSELECT @s;\n\n-- Drop the function and the table\nDROP FUNCTION dbo.wtfunc;\nDROP TABLE #test;