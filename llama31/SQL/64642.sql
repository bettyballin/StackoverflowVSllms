CREATE TABLE LogEntries (\n    LogEntryID INT,\n    LogDate DATE,\n    -- other columns\n) ON LogEntryDateRange (LogDate);