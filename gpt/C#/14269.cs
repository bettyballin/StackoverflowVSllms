using Microsoft.Office.Interop.Excel;\n\npublic void PrintExcelDocument(string filePath)\n{\n    Application excelApp = new Application();\n    Workbook workbook = excelApp.Workbooks.Open(filePath);\n    workbook.PrintOut();\n    workbook.Close(false);\n    excelApp.Quit();\n}