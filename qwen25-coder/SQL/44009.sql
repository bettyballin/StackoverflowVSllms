DECLARE @CreateTableScript NVARCHAR(MAX) = N'';\n\nSELECT \n    @CreateTableScript += \n        CASE WHEN COLUMNPROPERTY(OBJECT_ID('People'), COLUMN_NAME, 'IsIdentity') = 1 THEN\n            N',' + QUOTENAME(COLUMN_NAME) + N' ' +\n                DATA_TYPE + \n                (CASE WHEN CHARACTER_MAXIMUM_LENGTH IS NOT NULL AND DATA_TYPE NOT LIKE '%text%' THEN \n                        '(' + CAST(CHARACTER_MAXIMUM_LENGTH AS NVARCHAR(4)) + ')' \n                 ELSE ''\n                 END) +\n                ' IDENTITY(1,1)'\n        ELSE N',' + QUOTENAME(COLUMN_NAME) + N' ' +\n            DATA_TYPE +\n            (CASE WHEN CHARACTER_MAXIMUM_LENGTH IS NOT NULL AND DATA_TYPE NOT LIKE '%text%' THEN \n                    '(' + CAST(CHARACTER_MAXIMUM_LENGTH AS NVARCHAR(4)) + ')' \n             ELSE ''\n             END)\n        END\nFROM INFORMATION_SCHEMA.COLUMNS\nWHERE TABLE_NAME = N'People';\n\n-- Remove leading comma\nSET @CreateTableScript = SUBSTRING(@CreateTableScript, 2, LEN(@CreateTableScript) - 1);\n\n-- Generate the final CREATE TABLE statement\nDECLARE @TableName NVARCHAR(128) = 'People';\nPRINT 'CREATE TABLE ' + QUOTENAME(@TableName) + N' (\n    ' + @CreateTableScript + N'\n);';