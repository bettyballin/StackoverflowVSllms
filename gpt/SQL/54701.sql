-- Enumeration for date parts\nCREATE TYPE DatePartEnum AS TABLE (\n    PartName NVARCHAR(50),\n    PartValue INT\n);\n\nINSERT INTO DatePartEnum (PartName, PartValue) VALUES\n('year', 1),\n('month', 2),\n('day', 3),\n('hour', 4),\n('minute', 5),\n('second', 6);\n\n-- Function to accept date part as an integer\nCREATE FUNCTION dbo.MyFunc (@datePart INT, @dateValue DATETIME)\nRETURNS INT\nAS\nBEGIN\n    DECLARE @result INT;\n\n    SET @result = CASE @datePart\n                    WHEN 1 THEN DATEPART(year, @dateValue)\n                    WHEN 2 THEN DATEPART(month, @dateValue)\n                    WHEN 3 THEN DATEPART(day, @dateValue)\n                    WHEN 4 THEN DATEPART(hour, @dateValue)\n                    WHEN 5 THEN DATEPART(minute, @dateValue)\n                    WHEN 6 THEN DATEPART(second, @dateValue)\n                    ELSE NULL\n                  END;\n\n    RETURN @result;\nEND;\nGO\n\n-- Example usage:\nSELECT dbo.MyFunc(3, GETDATE()) AS DayPart;