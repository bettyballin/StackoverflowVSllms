CREATE FUNCTION dbo.GenerateDates (@startDate DATETIME, @endDate DATETIME)\nRETURNS @dates TABLE (AbsenceDate DATETIME)\nAS\nBEGIN\n    DECLARE @currentDate DATETIME\n    SET @currentDate = @startDate\n\n    WHILE @currentDate <= @endDate\n    BEGIN\n        INSERT INTO @dates (AbsenceDate) VALUES (@currentDate)\n        SET @currentDate = DATEADD(DAY, 1, @currentDate)\n    END\n\n    RETURN\nEND