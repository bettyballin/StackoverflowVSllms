Dim ws As Worksheet\nSet ws = ThisWorkbook.Sheets("Sheet1")\n\nWith ws ' or With ThisWorkbook.Sheets("Sheet1")\n    Set rFound = .Columns(1).Find(What:="Cat", _\n        After:=.Cells(1, 1), LookIn:=xlValues, LookAt:=xlPart, _\n        SearchOrder:=xlByRows, SearchDirection:=xlNext, MatchCase:=False, _\n        SearchFormat:=False)\nEnd With