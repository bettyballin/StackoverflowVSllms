CREATE TABLE #Results (\n    -- Define the column structure here\n)\n\nEXEC dbo.spPivot @EntityTypeID = 1;\n\nINSERT INTO #Results\nSELECT * FROM OPENROWSET('SQLNCLI', 'Server=(local);Trusted_Connection=yes;', 'EXEC dbo.spPivot @EntityTypeID = 1')\n\nSELECT * FROM #Results;\nDROP TABLE #Results;