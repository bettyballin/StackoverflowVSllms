SELECT DATEADD(day, (7 - DATEPART(weekday, GETDATE()) + 1) % 7, GETDATE()) AS NextSunday;