DECLARE @inputDate DATE = '2008-11-19';\nSELECT EOMONTH(DATEADD(QUARTER, DATEDIFF(QUARTER, 0, @inputDate) - 1, 0)) AS LastDayOfPriorQuarter;