SELECT Column1, ..., NewColumn\n   INTO #TempTable\n   FROM OriginalTable;\n   \n   -- After validation\n   DROP TABLE OriginalTable;\n   EXEC sp_rename N'#TempTable', N'OriginalTable';