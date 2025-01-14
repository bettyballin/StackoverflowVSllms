DECLARE @BatchSize INT = 10000; -- Adjust the batch size as needed\nDECLARE @DeletedRows INT;\n\nWHILE (1=1)\nBEGIN\n    BEGIN TRANSACTION;\n    \n    DELETE TOP (@BatchSize) \n    FROM GPSInfoTable\n    WHERE DateColumn < DATEADD(MONTH, -1, GETDATE()); -- Replace 'DateColumn' with your actual date column name\n    \n    SET @DeletedRows = @@ROWCOUNT;\n\n    COMMIT TRANSACTION;\n    \n    IF @DeletedRows < @BatchSize BREAK; -- Exit when there are less than one batch of rows left to delete\n    WAITFOR DELAY '00:00:1'; -- Pause for a short time before the next batch to reduce load, tweak as necessary\nEND