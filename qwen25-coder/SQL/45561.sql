CREATE FUNCTION dbo.GetNextDate(@Month INT, @Day INT)\nRETURNS DATETIME\nAS\nBEGIN\n    DECLARE @CurrentDate DATE = GETDATE();\n    DECLARE @Year INT = YEAR(@CurrentDate);\n    DECLARE @CandidateDate DATE;\n\n    -- Construct the candidate date with the current year\n    SET @CandidateDate = DATEFROMPARTS(@Year, @Month, @Day);\n\n    -- If the candidate date is before the current date, increment the year\n    IF (@CandidateDate < @CurrentDate)\n        SET @Year = @Year + 1;\n\n    -- Return the final constructed date\n    RETURN DATEFROMPARTS(@Year, @Month, @Day);\nEND;