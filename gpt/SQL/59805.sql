DECLARE @Date DATE = '2008-10-16';\n\nSELECT DATEPART(WEEK, @Date) - DATEPART(WEEK, DATEADD(MONTH, DATEDIFF(MONTH, 0, @Date), 0)) + 1 AS WeekOfMonth;