Dim oExcel As Object\nOn Error Resume Next\nSet oExcel = GetObject(, "Excel.Application")\nIf oExcel Is Nothing Then\n    Set oExcel = CreateObject("Excel.Application")\nEnd If\nOn Error GoTo 0