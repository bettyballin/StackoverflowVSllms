DECLARE @DaysToKeep INT = 30;\n\nDELETE FROM YourTable\nWHERE DateColumn < DATEADD(DAY, -@DaysToKeep, GETDATE());