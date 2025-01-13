DECLARE @d AS datetime\nSET @d = '1/15/2009'\nPRINT @d\nPRINT DATEADD(day, 8 - DATEPART(weekday, @d), @d)\nSET @d = '1/18/2009'\nPRINT @d\nPRINT DATEADD(day, 8 - DATEPART(weekday, @d), @d)\n\n-- So it should be able to be used inline pretty efficiently:\nDATEADD(day, 8 - DATEPART(weekday, datecolumn), datecolumn)\n\n-- If you want to change the first day for a different convention, simply use SET DATEFIRST before performing the operation\n-- e.g. for Monday: SET DATEFIRST 1\n-- e.g. for Saturday: SET DATEFIRST 6\n\nDECLARE @restore AS int\nSET @restore = @@DATEFIRST\nSET DATEFIRST 1\n\nDECLARE @d AS datetime\nSET @d = '1/15/2009'\nPRINT @d\nPRINT DATEADD(day, 8 - DATEPART(weekday, @d), @d)\nSET @d = '1/19/2009'\nPRINT @d\n\nPRINT DATEADD(day, 8 - DATEPART(weekday, @d), @d)\nSET DATEFIRST @restore