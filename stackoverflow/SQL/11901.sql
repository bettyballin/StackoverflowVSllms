DECLARE @StartDate DATETIME,\n        @EndDate DATETIME\n\nSELECT  @StartDate = '01 Jun 2009',\n        @EndDate = '30 Jun 2009'\n\nSELECT  *\nFROM    Logs l LEFT JOIN\n        LogsExtended le ON l.LogID = le.LogID\nWHERE   l.Date BEYWEEN @StartDate AND @EndDate