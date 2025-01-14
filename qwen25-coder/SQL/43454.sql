-- Sample Data Table\nDECLARE @tbl_Info TABLE (Info VARCHAR(10))\n\nINSERT INTO @tbl_Info (Info)\nVALUES ('Name1'), ('Age1'), ('Sex1'),\n       ('Name2'), ('Age2'), ('Sex2')\n\n-- Row-Col Transposition using PIVOT\nSELECT [Name], [Age], [Sex]\nFROM (\n    SELECT Info,\n           SUBSTRING(Info, 1, CHARINDEX('1', Info) - 1) AS Category,\n           ROW_NUMBER() OVER (PARTITION BY SUBSTRING(Info, 1, CHARINDEX('1', Info) - 1) ORDER BY (SELECT NULL)) AS RowNum\n    FROM @tbl_Info\n) AS SourceTable\nPIVOT (\n    MAX(Info)\n    FOR Category IN ([Name], [Age], [Sex])\n) AS PivotTable;