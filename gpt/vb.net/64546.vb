Declare Sub UseExcel Lib "ExcelDLL.dll" (ByVal ExcelApp As Object)\n\nSub CallDll()\n    Dim xlApp As Object\n    Set xlApp = Application\n    ' Pass the current Excel Application object to the DLL\n    UseExcel xlApp\nEnd Sub