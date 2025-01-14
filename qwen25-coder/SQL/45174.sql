DECLARE @TableName NVARCHAR(128);\nDECLARE table_cursor CURSOR FOR \nSELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_TYPE='BASE TABLE' AND TABLE_SCHEMA='dbo';\n\nOPEN table_cursor;\nFETCH NEXT FROM table_cursor INTO @TableName;\n\nWHILE @@FETCH_STATUS = 0\nBEGIN\n    DECLARE @SQL NVARCHAR(MAX);\n\n    -- Create script to insert rows into this table.\n    SELECT \n        @SQL = COALESCE(@SQL + N' UNION ALL',N'SELECT ''INSERT INTO ['+ @TableName +'] ('+') +\n                STUFF((SELECT DISTINCT ',[column_name]'\n                       FROM INFORMATION_SCHEMA.COLUMNS \n                       WHERE TABLE_NAME = @TableName\n                         AND COLUMN_NAME NOT IN('RowID') -- Exclude IDENTITY or other special columns if necessary\n                       FOR XML PATH(''),TYPE).value('.','NVARCHAR(MAX)'),1,1,'')+N') VALUES ('+') +\n                STUFF((SELECT DISTINCT CASE WHEN DATA_TYPE IN ('char','nchar','varchar','nvarchar','text','ntext')\n                            THEN ''''+REPLACE(CAST([column_name] AS NVARCHAR(MAX)),'''','''''')+'''' \n                        ELSE CAST([column_name] AS NVARCHAR(MAX))\n                       END+','\n                       FROM INFORMATION_SCHEMA.COLUMNS \n                       WHERE TABLE_NAME = @TableName\n                         AND COLUMN_NAME NOT IN('RowID') -- Exclude IDENTITY or other special columns if necessary\n                       FOR XML PATH(''),TYPE).value('.','NVARCHAR(MAX)'),1,1,'')+N')' \n                + CHAR(13)\n    FROM INFORMATION_SCHEMA.TABLES \n    WHERE TABLE_NAME = @TableName;\n\n    -- Generate final script\n    SELECT 'SET NOCOUNT ON;'+CHAR(13)+@SQL AS [Generate_Script]\n\n    FETCH NEXT FROM table_cursor INTO @TableName;\nEND\n\nCLOSE table_cursor;\nDEALLOCATE table_cursor;\nGO