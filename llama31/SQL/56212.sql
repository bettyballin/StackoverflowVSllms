SELECT AttemptDate \nFROM dbo.ChangeAttempt \nWHERE CONVERT(varchar(10), AttemptDate, 120) = CONVERT(varchar(10), GETDATE(), 120)