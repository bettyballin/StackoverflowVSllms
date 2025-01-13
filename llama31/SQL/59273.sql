CREATE PROCEDURE aggregated_mystoredproc_sp\nAS\nBEGIN\n    CREATE TABLE #TempResults (\n        AccountNumber INT,\n        -- other columns...\n    );\n\n    INSERT INTO #TempResults\n    EXEC mystoredproc_sp;\n\n    SELECT AccountNumber, COUNT(*) \n    FROM #TempResults\n    GROUP BY AccountNumber;\n\n    DROP TABLE #TempResults;\nEND;