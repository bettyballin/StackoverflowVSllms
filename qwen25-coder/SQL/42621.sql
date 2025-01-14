-- Generate a numbers table (this can be created permanently in your database)\nWITH Numbers AS (\n    SELECT 1 N UNION ALL SELECT N + 1 FROM Numbers WHERE N < 365*2 -- enough days for two years of data\n),\nCalendar AS (\n    SELECT DATEADD(DAY, N - 1, '2008-04-01') as CalendarDate\n        -- Start from a base date before the earliest event and generate dates up to after latest expected range\n    FROM Numbers WHERE DATEADD(DAY, N - 1, '2008-04-01') <= '2009-06-30'\n)\n-- Define your events table with sample data for demonstration\n, Events AS (\n    SELECT eventId, CAST(startDate AS DATETIME) startDate, \n            CASE WHEN endDate IS NULL THEN '9999-12-31' ELSE CAST(endDate AS DATETIME) END as endDate -- treat NULL(endDate) as a future date\n    FROM (\n        VALUES (1, '02/05/2009', '10/05/2009'),\n               (2, '08/05/2009', '12/05/2009'),\n               (3, '10/05/2009', '12/05/2009'),\n               (4, '21/05/2009', '21/05/2009'),\n               (5, '25/05/2009', NULL),\n               (6, '01/06/2009', '03/06/2009')\n    ) as T(eventId, startDate, endDate)\n)\n\n-- Main query to find overlaps and gaps\nSELECT DateStart = MIN(CalendarDate), DateEnd = MAX(CalendarDate)\n  , CASE WHEN COUNT(DISTINCT eventId) > 1 THEN 'overlap' ELSE 'no event' END AS EventStatus\nFROM (\n    SELECT CalendarDate, eventId    \n        , rn = ROW_NUMBER() OVER(PARTITION BY CASE WHEN COUNT(eventId) > 0 THEN 1 ELSE 0 END ORDER BY CalendarDate)\n    FROM Calendar c\n    LEFT JOIN Events e ON c.CalendarDate BETWEEN startDate AND endDate\n    WHERE CalendarDate BETWEEN '2009-04-01' AND '2009-06-30'\n    GROUP BY CalendarDate, CASE WHEN COUNT(eventId) > 0 THEN 1 ELSE 0 END\n) X \nGROUP BY EventStatus, DateDiff(DAY,'2008-04-01',CalendarDate) - rn\nORDER BY MIN(CalendarDate);