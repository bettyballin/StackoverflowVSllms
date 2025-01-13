using OfficeOpenXml;\n\n// Load the Excel file\nvar package = new ExcelPackage("C:\Path\To\Your\Excel\File.xlsx");\n\n// Get the first sheet\nvar sheet = package.Workbook.Worksheets["Sheet1"];\n\n// Iterate over the rows and columns\nfor (var row = 1; row <= sheet.Dimension.End.Row; row++)\n{\n    for (var col = 1; col <= sheet.Dimension.End.Column; col++)\n    {\n        // Read the cell value and import it into your database\n        var cellValue = sheet.Cells[row, col].Value.ToString();\n        // Your database import code here...\n    }\n}