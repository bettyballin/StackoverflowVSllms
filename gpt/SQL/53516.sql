-- Drop the existing stored procedure if it exists\nIF OBJECT_ID('dbo.YourStoredProcedureName', 'P') IS NOT NULL\nBEGIN\n    DROP PROCEDURE dbo.YourStoredProcedureName;\nEND\nGO\n\n-- Create the stored procedure\nCREATE PROCEDURE dbo.YourStoredProcedureName\nAS\nBEGIN\n    -- Your procedure's logic here\n    SELECT 'Hello, World!';\nEND\nGO