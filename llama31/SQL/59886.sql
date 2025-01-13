DECLARE @datePart INT\nDECLARE @dateParameter INT\n\nSELECT @datePart = 1  -- 1 = dd, 2 = ww, 3 = mm, etc.\nSELECT @dateParameter = 28\n\nSELECT\n    *\nFROM\n    MyTable\nWHERE\n    CHOOSE(@datePart, \n           DATEDIFF(dd, MyTable.MyDate, GETDATE()),\n           DATEDIFF(ww, MyTable.MyDate, GETDATE()),\n           DATEDIFF(mm, MyTable.MyDate, GETDATE()),\n           DATEDIFF(qq, MyTable.MyDate, GETDATE()),\n           DATEDIFF(yy, MyTable.MyDate, GETDATE())) < @dateParameter