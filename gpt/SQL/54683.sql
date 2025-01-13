SET STATISTICS TIME ON;\nSET STATISTICS IO ON;\n\n-- Clear cache\nDBCC FREEPROCCACHE;\nDBCC DROPCLEANBUFFERS;\n\n-- Measure execution time and resource usage\nDECLARE @start DATETIME = GETDATE();\nEXEC test_1a;\nSELECT DATEDIFF(ms, @start, GETDATE()) AS Execution_Time_ms;\n\n-- Clear cache\nDBCC FREEPROCCACHE;\nDBCC DROPCLEANBUFFERS;\n\nDECLARE @start DATETIME = GETDATE();\nEXEC test_1b;\nSELECT DATEDIFF(ms, @start, GETDATE()) AS Execution_Time_ms;\n\nSET STATISTICS TIME OFF;\nSET STATISTICS IO OFF;