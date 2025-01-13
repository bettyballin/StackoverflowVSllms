Dim app As Object = Application\nIf TypeOf app Is Excel.Application Then\n    Dim excelApp As Excel.Application = DirectCast(app, Excel.Application)\n    ' Excel-specific code here\nElseIf TypeOf app Is Word.Application Then\n    Dim wordApp As Word.Application = DirectCast(app, Word.Application)\n    ' Word-specific code here\nEnd If