USE [YourDatabase]\nGO\n\nALTER PROCEDURE [dbo].[bsp_GetBlockedProcessCount]\nAS\nBEGIN\n    SET NOCOUNT ON;\n\n    DECLARE @count INT;\n\n    SELECT @count = COUNT(*)\n    FROM master.dbo.vw_BlockedProcesses;\n\n    RETURN @count;\nEND\nGO