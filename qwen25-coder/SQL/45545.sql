DECLARE @TableName NVARCHAR(128) = 'YourTableName'; -- Replace with your table name\nDECLARE @SQL NVARCHAR(MAX);\n\n-- Create script to insert rows into this table.\nSELECT \n    @SQL = COALESCE(@SQL + N' UNION ALL',N'SELECT ''INSERT INTO ['+ @TableName +'] ('+') +\n            STUFF((SELECT DISTINCT  ',[column_name]'\n                   FROM INFORMATION_SCHEMA.COLUMNS \n                   WHERE TABLE_NAME = @TableName\n                     AND COLUMN_NAME NOT IN('RowID') -- Exclude IDENTITY or other special columns if necessary\n                   FOR XML PATH(''),TYPE).value('.','NVARCHAR(MAX)'),1,1,'')+N') VALUES ('+') +\n            STUFF((SELECT DISTINCT  CASE WHEN DATA_TYPE IN ('char','nchar','varchar','nvarchar','text','ntext')\n                        THEN N''''+REPLACE(CAST([column_name] AS NVARCHAR(MAX)),'''','''''')+'''' \n                    ELSE CAST([column_name] AS NVARCHAR(MAX))\n                   END+','\n                   FROM INFORMATION_SCHEMA.COLUMNS \n                   WHERE TABLE_NAME = @TableName\n                     AND COLUMN_NAME NOT IN('RowID') -- Exclude IDENTITY or other special columns if necessary\n                   FOR XML PATH(''),TYPE).value('.','NVARCHAR(MAX)'),1,1,'')+N')' \n            + CHAR(13)\nFROM INFORMATION_SCHEMA.TABLES \nWHERE TABLE_NAME = @TableName;\n \n-- Generate final script\nSELECT 'SET NOCOUNT ON;'+CHAR(13)+@SQL AS [Generate_Script]\nGO