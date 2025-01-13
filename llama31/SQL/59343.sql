CREATE FUNCTION NextDate (@Month tinyint, @Day tinyint)\nRETURNS datetime\nAS\nBEGIN\n    DECLARE @Today datetime = GETDATE()\n    DECLARE @NextDate datetime = DATEFROMPARTS(YEAR(@Today), @Month, @Day)\n\n    IF @NextDate < @Today\n        SET @NextDate = DATEFROMPARTS(YEAR(@Today) + 1, @Month, @Day)\n\n    RETURN @NextDate\nEND\nGO