-- Example of creating multiple stored procedures in a single SQL file\n\n-- First, create a table to store the stored procedure definitions\nCREATE TABLE #StoredProcedureDefinitions (\n    SPName NVARCHAR(128),\n    SPDefinition NVARCHAR(MAX)\n);\n\n-- Insert the stored procedure definitions into the table\nINSERT INTO #StoredProcedureDefinitions (SPName, SPDefinition)\nVALUES\n('SummaryNone', 'YEAR([sale].[DateTime])'),\n('SummaryUser', '[sale].[User]'),\n('SummarySale', '[sale].[Sale]'),\n('SummaryBatch', '[sale].[Batch]'),\n('SummaryDay', 'dbo.FormatDateTime([sale].[DateTime], ''yyyy-mm-dd'')'),\n('SummaryMonth', 'dbo.FormatDateTime(dbo.DateSerial(YEAR([sale].[DateTime]), MONTH([sale].[DateTime]), 1), ''yyyy-mm-dd'')'),\n('SummaryYear', 'YEAR([sale].[DateTime])');\n\n-- Loop through the definitions and create the stored procedures\nDECLARE @SPName NVARCHAR(128);\nDECLARE @SPDefinition NVARCHAR(MAX);\nDECLARE @CommandText NVARCHAR(MAX);\n\nDECLARE db_cursor CURSOR FOR \nSELECT SPName, SPDefinition\nFROM #StoredProcedureDefinitions;\n\nOPEN db_cursor;\nFETCH NEXT FROM db_cursor INTO @SPName, @SPDefinition;\n\nWHILE @@FETCH_STATUS = 0\nBEGIN\n    SET @CommandText = \n        'CREATE PROCEDURE ' + @SPName + ' ' +\n        '@StartDate VARCHAR(50), ' +\n        '@EndDate VARCHAR(50) ' +\n        'AS ' +\n        'SELECT ' + @SPDefinition + ' AS GroupField, ' +\n        'SUM([Project].[NumProject]) AS TotalProject, ' +\n        'SUM([Project].[Title]) AS SumTitle, ' +\n        'SUM([Project].[Duration]) AS SumDuration, ' +\n        'SUM([Project].[Info]) AS SumInfo, ' +\n        'SUM([Customer].[NumCustomer]) AS TotalNumCustomer, ' +\n        'SUM([Orders].[NumOrders]) AS TotalNumOrders, ' +\n        'SUM([OrderInspection].[NumInspects]) AS TotalNumInspects, ' +\n        'SUM([OrderInspection].[NumFails]) AS TotalNumFails, ' +\n        'SUM([CustomerInspection].[NumInspects]) AS TotalNumCustomerInspectionInspects, ' +\n        'SUM([CustomerInspection].[NumFails]) AS TotalNumCustomerInspectionFails, ' +\n        'SUM([Measurements].[NumMeasurements]) AS TotalNumMeasurements ' +\n        'FROM ((((((sale LEFT JOIN Project ON [sale].[saleId] = [Project].[saleId]) ' +\n        'LEFT JOIN Customer ON [Project].[PrintId] = [Customer].[PrintId]) ' +\n        'LEFT JOIN Orders ON [Project].[PrintId] = [Orders].[PrintId]) ' +\n        'LEFT JOIN OrderInspection ON [Project].[PrintId] = [OrderInspection].[PrintId]) ' +\n        'LEFT JOIN CustomerInspection ON [Project].[PrintId] = [CustomerInspection].[PrintId]) ' +\n        'LEFT JOIN Measurements ON [Project].[PrintId] = [Measurements].[PrintId]) ' +\n        'WHERE [sale].[DateTime] BETWEEN dbo.FormatDateTime((@StartDate), ''yyyy-mm-dd'') ' +\n        'AND dbo.FormatDateTime((@EndDate), ''yyyy-mm-dd'') ' +\n        'GROUP BY ' + @SPDefinition + ' ' +\n        'ORDER BY ' + @SPDefinition + ';';\n\n    EXEC sp_executesql @CommandText;\n\n    FETCH NEXT FROM db_cursor INTO @SPName, @SPDefinition;\nEND;\n\nCLOSE db_cursor;\nDEALLOCATE db_cursor;\n\n-- Cleanup\nDROP TABLE #StoredProcedureDefinitions;