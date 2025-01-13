using OfficeOpenXml;\n\nvar package = new ExcelPackage();\nvar worksheet = package.Workbook.Worksheets.Add("Example");\nworksheet.Cells["A1"].Value = "Name";\nworksheet.Cells["B1"].Value = "Description";\nworksheet.Cells["A2"].Value = "ø";\nworksheet.Cells["B2"].Value = "ü";\npackage.SaveAs(new FileInfo("example.xlsx"));