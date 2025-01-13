DECLARE @Year int\nDECLARE @WeekNo int\nSET @Year = 2009\nSET @WeekNo = 1\n\nDECLARE @DaysInWeekOne int\nDECLARE @FirstOfJan smalldatetime\nDECLARE @ThirtyFirstOfDec smalldatetime\nDECLARE @StartDateDayOfYear int\nDECLARE @EndDateDayOfYear int\n\n--GET THE START AND END OF THE YEAR\nSELECT\n    @ThirtyFirstOfDec = Cast(('12/31/' + Cast(@Year as varchar)) as smalldatetime)\n,   @FirstOfJan = Cast(('01/01/' + Cast(@Year as varchar)) as smalldatetime)\n\n--GET THE AMOUNT OF DAYS IN WEEK ONE\nSELECT\n    @DaysInWeekOne = 7 - (DatePart(dw, @FirstOfJan) - 1)\n\n--GET THE START AND END DAYOFYEAR VALUES FOR THE GIVEN WEEK\nSELECT\n    @StartDateDayOfYear = CASE WHEN ((@WeekNo-1)*7)-(7-@DaysInWeekOne) < 0 THEN 0 ELSE ((@WeekNo-1)*7)-(7-@DaysInWeekOne) END\n,   @EndDateDayOfYear = ((@WeekNo-1)*7)-(7-@DaysInWeekOne) + 6\n\n--SELECT THE START DATE AND END DATE MAKING SURE IF THE COUNT RUNS OVER THE YEAR THAT WE SHOW THE 31/12\nSELECT\n    @Year As mYear\n,   @WeekNo As WeekNo\n,   dateadd(dd, @StartDateDayOfYear, (@FirstOfJan)) As StartDate\n,   CASE \n        WHEN dateadd(dd, @EndDateDayOfYear,   (@FirstOfJan)) > @ThirtyFirstOfDec THEN @ThirtyFirstOfDec \n        ELSE dateadd(dd, @EndDateDayOfYear, @FirstOfJan) \n    END As EndDate