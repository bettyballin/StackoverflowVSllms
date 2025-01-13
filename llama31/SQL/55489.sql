CREATE FUNCTION CalendarTable\n(\n    @StartDate DATETIME,\n    @EndDate DATETIME\n)\nRETURNS TABLE \nAS\nRETURN \n(\n    WITH MyCalendar AS\n    (\n        SELECT CAST(@StartDate AS DATETIME) DateValue\n        UNION ALL\n        SELECT DateValue + 1\n        FROM MyCalendar\n        WHERE DateValue + 1 <= @EndDate\n    )\n    SELECT \n        DateValue,\n        DATEPART(dy, DateValue) AS [day of year],\n        DATENAME(dw, DateValue) AS [day],\n        DATEPART(dw, DateValue-1) AS [day of week],\n        DATEPART(dd, DateValue) AS [day of month],\n        DATEPART(ww, DateValue) AS [week],\n        DATEPART(mm, DateValue) AS [month],\n        DATENAME(mm, DateValue) AS [month],\n        DATEPART(qq, DateValue) AS [quarter],\n        DATEPART(yy, DateValue) AS [year],\n        DATEPART(HH, DateValue) AS [HOUR],\n        DATEPART(MI, DateValue) AS [MIN],\n        DATEPART(SS, DateValue) AS [SEC],\n        DATEPART(MS, DateValue) AS [MILLISECOND]\n    FROM MyCalendar\n    OPTION (MAXRECURSION 0);\n);\nGO