DECLARE @DateTimeString NVARCHAR(26) = '2009-06-24 09:52:43.000';\nDECLARE @DateOnlyWithZeroTime DATETIME;\n\nSET @DateOnlyWithZeroTime = CAST(CAST(@DateTimeString AS DATE) AS DATETIME);\n\nSELECT @DateOnlyWithZeroTime AS DateOnlyWithZeroTime;