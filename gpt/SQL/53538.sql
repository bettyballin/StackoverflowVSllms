DECLARE @whatTheHell float(53)\nSET @whatTheHell = 3.1415926535897931 / 180\nPRINT CONVERT(varchar, @whatTheHell, 128)