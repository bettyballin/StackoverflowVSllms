USE [YourDatabaseName];\nGO\n\nIF OBJECT_ID('dbo.YourStoredProcedure', 'P') IS NOT NULL\n    DROP PROCEDURE dbo.YourStoredProcedure;\nGO\n\nCREATE PROCEDURE dbo.YourStoredProcedure\nAS\nBEGIN\n    -- Your procedure code goes here\n    SELECT 1;\nEND;\nGO