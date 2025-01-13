DECLARE @StartDate datetime, @EndDate datetime, @TimeOfDay time\n\nSET @StartDate = DATEADD(dd, -60, GETDATE())  -- 60 days ago\nSET @EndDate = GETDATE()\nSET @TimeOfDay = '08:00:00'  -- specific time of day\n\nWITH Dates AS (\n    SELECT TOP 60  -- adjust this to the number of days you want to retrieve\n        DATEADD(dd, ROW_NUMBER() OVER (ORDER BY object_id), @StartDate) AS Date\n    FROM\n        sys.all_columns ac\n)\nSELECT\n    d.Date,\n    wh.DateTime,\n    wh.ACMKWHYTD_1\nFROM\n    Dates d\nINNER JOIN\n    WideHistory wh ON wh.DateTime >= DATEADD(ss, 0, DATEADD(dd, 0, d.Date)) AND wh.DateTime < DATEADD(ss, 90, DATEADD(dd, 0, d.Date))\nWHERE\n    wh.wwResolution = 60000 AND wh.wwRetrievalMode = 'cyclic'\nORDER BY\n    d.Date