CREATE PROCEDURE CheckForNewData\nAS\nBEGIN\n    DECLARE @CurrentTime DATETIME\n    DECLARE @TimeThreshold DATETIME\n    DECLARE @NewRowsCount INT\n\n    -- Get the current date and time\n    SET @CurrentTime = GETDATE()\n\n    -- Calculate the time threshold (12 hours ago)\n    SET @TimeThreshold = DATEADD(HOUR, -12, @CurrentTime)\n\n    -- Check for new rows in the last 12 hours\n    SELECT @NewRowsCount = COUNT(*)\n    FROM YourTableName\n    WHERE CreatedDate >= @TimeThreshold\n\n    -- If no new rows are found, send an email\n    IF @NewRowsCount = 0\n    BEGIN\n        -- Replace with your email sending procedure\n        EXEC YourEmailSendingProcedure 'recipient@example.com', 'Warning: No new data in the last 12 hours'\n    END\nEND