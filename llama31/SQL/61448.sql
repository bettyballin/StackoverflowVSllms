SELECT \n    Count(Page) as VisitingCount,\n    Page,\n    CONVERT(VARCHAR(5), Date, 108) as Time\nFROM \n    scr_SecuristLog\nWHERE \n    Date BETWEEN '2009-05-04 00:00:00' AND '2009-05-06 14:58'\n    AND [user] IN (SELECT USERNAME FROM scr_CustomerAuthorities)\nGROUP BY \n    Page, \n    CONVERT(VARCHAR(5), Date, 108)\nORDER BY \n    [VisitingCount] ASC