CREATE PROCEDURE GenerateNightlyReport\nAS\nBEGIN\n    -- Your long-running transactional/reporting SQL queries here\n    SELECT * FROM SomeTable WHERE DateCreated > GETDATE() - 1;\nEND