Protected Sub Page_Load(ByVal sender As Object, ByVal e As EventArgs) Handles Me.Load\n    Dim excelGen As New ExcelGenerator()\n    excelGen.GenerateExcelFile(HttpContext.Current)\nEnd Sub