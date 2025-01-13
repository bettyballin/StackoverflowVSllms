SELECT \n  COUNT(Page) AS VisitingCount,\n  dbo.fn_GetActivityLogsArranger(CONVERT(VARCHAR(5), Date, 108)) AS [Time]\nFROM \n  scr_SecuristLog\nWHERE \n  Date BETWEEN '2009-04-30' AND '2009-05-02'\n  AND [user] IN (\n    SELECT USERNAME \n    FROM scr_CustomerAuthorities \n    WHERE customerID = CONVERT(VARCHAR, 4) AND ID = CONVERT(VARCHAR, 43)\n  )\nGROUP BY \n  dbo.fn_GetActivityLogsArranger(CONVERT(VARCHAR(5), Date, 108))\nORDER BY \n  dbo.fn_GetActivityLogsArranger(CONVERT(VARCHAR(5), Date, 108)) ASC