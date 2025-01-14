Imports System.Globalization\n\nFunction GetSaturdayFromIsoWeek(year As Integer, week As Integer) As DateTime\n    Dim calendar = CultureInfo.InvariantCulture.Calendar\n    If year < 100 Then\n        year += 2000 ' Assumes current century\n    End If\n    \n    ' Start with first day of the year\n    Dim jan1st = New DateTime(year, 1, 1)\n    \n    ' Get difference in days to get first Monday of ISO year\n    Dim diffToFirstMonday = (8 - jan1st.DayOfWeek + DayOfWeek.Sunday) Mod 7\n    Dim startOfYear = jan1st.AddDays(diffToFirstMonday)\n    \n    ' Calculate Saturday of the given week\n    Return startOfYear.AddDays((week - 1) * 7 + 6) ' Add days to reach target Saturday\nEnd Functio