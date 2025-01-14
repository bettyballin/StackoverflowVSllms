WITH ArrangedLogs AS (\n    SELECT \n        Count(Page) as VisitingCount,\n        dbo.fn_GetActivityLogsArranger(CONVERT(VARCHAR(5), Date, 108)) AS [TIME]\n    FROM \n        scr_SecuristLog\n    WHERE \n        Date BETWEEN '2009-04-30' AND '2009-05-02' AND \n        [user] IN (\n            SELECT USERNAME\n            FROM scr_CustomerAuthorities\n            WHERE customerID = CONVERT(VARCHAR, 4) AND ID = CONVERT(VARCHAR, 43)\n        )\n    GROUP BY \n        dbo.fn_GetActivityLogsArranger(CONVERT(VARCHAR(5), Date, 108))\n)\n\nSELECT \n    VisitingCount,\n    [TIME]\nFROM \n    ArrangedLogs\nORDER BY \n    [TIME] ASC;