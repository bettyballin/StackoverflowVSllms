DECLARE @DynamicSQL NVARCHAR(MAX);\nDECLARE @OrderByColumn SYSNAME;\nDECLARE @SortOrder NVARCHAR(4);\n\n-- Assign the column to order by based on @OrderBy variable\nSELECT @OrderByColumn = CASE \n                         WHEN @OrderBy = 'surname'           THEN 'surname'\n                         WHEN @OrderBy = 'forename'          THEN 'forename'\n                         WHEN @OrderBy = 'fullName'          THEN 'fullName'\n                         WHEN @OrderBy = 'userId'            THEN 'userId'\n                         WHEN @OrderBy = 'MobileNumber'      THEN 'MSISDN'\n                         WHEN @OrderBy = 'DeviceStatus'      THEN 'DeviceStatus'\n                         WHEN @OrderBy = 'LastPosition'      THEN 'LastPosition'\n                         WHEN @OrderBy = 'LastAlert'         THEN 'LastAlert'\n                         WHEN @OrderBy = 'LastCommunication' THEN 'LastCommunication'\n                         WHEN @OrderBy = 'LastPreAlert'      THEN 'LastPreAlert'\n                       END;\n\n-- Construct the SQL query dynamically\nSET @DynamicSQL = N'SELECT * FROM #t_results ORDER BY ' + QUOTENAME(@OrderByColumn) + N' ' + @SortOrder;\n\n-- Execute the dynamic SQL\nEXEC sp_executesql @DynamicSQL;