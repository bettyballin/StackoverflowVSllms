INSERT INTO timecrunch.dbo.intervals (IntervalID, Duration)\nSELECT ixInterval, CAST(DATEDIFF(minute, dtStart, dtEnd) AS FLOAT) / 60.0 \nFROM fogbugz.dbo.TimeInterval\nWHERE dtEnd is not NULL;