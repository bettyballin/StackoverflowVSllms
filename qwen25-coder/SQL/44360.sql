select * \nfrom weblogs.dbo.vwlogs \nwhere Log_time between @BeginDate and @EndDate \nand (@UserName is null or client_user = @UserName)