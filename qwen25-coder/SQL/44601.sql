-- Example for ISO 8601 Extended Date: 2000-01-14T13:42Z\nDECLARE @dt DATETIME = '2000-01-14T13:42:00';\nSELECT CONVERT(varchar(19), @dt, 126) AS ISO8601_Extended;\n\n-- Example for ISO 8601 Basic Date: 20090123T105321Z\nDECLARE @dt2 DATETIME = '2009-01-23T10:53:21';\nSELECT \n    CONVERT(varchar(4), YEAR(@dt2)) + \n    RIGHT('0' + CONVERT(varchar(2), MONTH(@dt2)), 2) + \n    RIGHT('0' + CONVERT(varchar(2), DAY(@dt2)), 2) +\n    'T' +\n    RIGHT('0' + CONVERT(varchar(2), DATEPART(hour, @dt2)), 2) +\n    RIGHT('0' + CONVERT(varchar(2), DATEPART(minute, @dt2)), 2) +\n    RIGHT('0' + CONVERT(varchar(2), DATEPART(second, @dt2)), 2) +\n    'Z' AS ISO8601_Basic;