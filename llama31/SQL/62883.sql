-- Query1\ndeclare @date1 datetime, @date2 datetime, @COUNT INT, @countgap int\nselect @date1 = '2009-05-11', @date2 = '2009-05-12'\nselect @countgap = 30, @COUNT = 0\n\nselect @date1 TARIH, @COUNT SIRA\ninto #TMP\nwhile @date1 < @date2\nbegin\n    select @date1 = dateadd(minute, @countgap, @date1), @COUNT = @COUNT + 1\n    insert into #TMP\n    select @date1 TARIH, @COUNT SIRA\nend\n\n-- Query2\nselect count(page) as VISITINGCOUNT, \n       (datepart(hour, Date) * 60 + datepart(minute, Date)) / @countgap as SIRA\ninto #TMP2\nfrom scr_SecuristLog\nwhere Date between @date1 and @date2\ngroup by (datepart(hour, Date) * 60 + datepart(minute, Date)) / @countgap\n\n-- Join the two queries\nselect t1.TARIH, t1.SIRA, coalesce(t2.VISITINGCOUNT, 0) as VISITINGCOUNT\nfrom #TMP t1\nleft join #TMP2 t2 on t1.SIRA = t2.SIRA\norder by t1.SIRA\n\ndrop table #TMP\ndrop table #TMP2