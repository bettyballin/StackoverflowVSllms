DECLARE @sql VARCHAR(8000)\nDECLARE @dts_name VARCHAR(255)\nDECLARE @file_name VARCHAR(255)\nDECLARE @file_path VARCHAR(255)\n\nSET @file_path = 'C:\DTS_Export\'  -- specify the file path\n\nDECLARE cur_dts CURSOR FOR\nSELECT name \nFROM sysdtspackages\n\nOPEN cur_dts\n\nFETCH NEXT FROM cur_dts INTO @dts_name\n\nWHILE @@FETCH_STATUS = 0\nBEGIN\n    SET @sql = 'SELECT packagedata FROM sysdtspackages WHERE name = ''' + @dts_name + ''''\n    EXEC sp_executesql @sql\n\n    DECLARE @packagedata VARBINARY(MAX)\n    SET @packagedata = (SELECT packagedata FROM sysdtspackages WHERE name = @dts_name)\n\n    DECLARE @extracted_sql VARCHAR(MAX)\n    SET @extracted_sql = CONVERT(VARCHAR(MAX), @packagedata)\n\n    SET @file_name = @dts_name + '_' + CONVERT(VARCHAR, GETDATE(), 112) + '.txt'\n\n    DECLARE @file_handle INT\n    EXEC sp_OACreate 'ADODB.Stream', @file_handle OUTPUT\n    EXEC sp_OASetProperty @file_handle, 'Type', 1\n    EXEC sp_OAMethod @file_handle, 'Open', NULL\n    EXEC sp_OAMethod @file_handle, 'WriteText', NULL, @extracted_sql\n    EXEC sp_OAMethod @file_handle, 'SaveToFile', NULL, @file_path + @file_name, 2\n    EXEC sp_OAMethod @file_handle, 'Close', NULL\n    EXEC sp_OADestroy @file_handle\n\n    FETCH NEXT FROM cur_dts INTO @dts_name\nEND\n\nCLOSE cur_dts\nDEALLOCATE cur_dts