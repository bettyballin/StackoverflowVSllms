DECLARE @Date datetime\nSET @Date = GETDATE()\n\nSELECT DATEADD(s, -1, DATEADD(mm, DATEDIFF(m, 0, @Date) + 1, 0))