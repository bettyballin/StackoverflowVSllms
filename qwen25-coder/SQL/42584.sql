DECLARE \n    @BillNo int,\n    @column_name nvarchar(500),\n    @sql nvarchar(max),\n    @OldValue sql_variant,\n    @NewValue sql_variant\n\n-- Get BillNo from inserted rows, assuming there's only one row as example\nSELECT TOP 1 @BillNo = BillNo FROM INSERTED\n\nDECLARE HistoryMonitorLoop CURSOR FOR\n    SELECT column_name \n    FROM information_schema.columns\n    WHERE table_name = 'Shipment' AND table_schema = 'dbo'\n\nOPEN HistoryMonitorLoop\nFETCH NEXT FROM HistoryMonitorLoop INTO @column_name\nWHILE @@FETCH_STATUS = 0\nBEGIN\n    -- Construct the dynamic SQL to get old and new values\n    SET @sql = N'SELECT @OldValue = ISNULL(CONVERT(nvarchar(max), d.' + QUOTENAME(@column_name) + '), ''NULL''), \n                         @NewValue = ISNULL(CONVERT(nvarchar(max), i.' + QUOTENAME(@column_name) + '), ''NULL'') \n              FROM Deleted d\n              INNER JOIN Inserted i ON d.BillNo = i.BillNo'\n    \n    -- Execute the constructed SQL\n    EXEC sp_executesql @sql, N'@OldValue sql_variant OUTPUT, @NewValue sql_variant OUTPUT', @OldValue OUTPUT, @NewValue OUTPUT\n    \n    IF (@OldValue <> @NewValue)\n    BEGIN\n        DECLARE @Comment nvarchar(5000)\n        SET @Comment = @column_name + ' Changed from ''' + CONVERT(nvarchar(max), @OldValue) + ''' to ''' + CONVERT(nvarchar(max), @NewValue) + ''''\n        \n        EXEC ShipmentNote_Insert @BillNo=@BillNo, @CoordinatorID=1, @Comment=@Comment\n    END\n    \n    FETCH NEXT FROM HistoryMonitorLoop INTO @column_name\nEND\n\nCLOSE HistoryMonitorLoop\nDEALLOCATE HistoryMonitorLoop