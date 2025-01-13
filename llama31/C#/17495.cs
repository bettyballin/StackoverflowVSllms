using DocumentFormat.OpenXml;\nusing DocumentFormat.OpenXml.Packaging;\nusing DocumentFormat.OpenXml.Spreadsheet;\nusing System.Collections.Generic;\nusing System.IO;\n\npublic void ExportToExcel(List<List<object>> outputRows)\n{\n    using (var document = SpreadsheetDocument.Create("output.xlsx", SpreadsheetDocumentType.Workbook))\n    {\n        var workbookPart = document.AddWorkbookPart();\n        var worksheetPart = workbookPart.AddNewPart<WorksheetPart>();\n\n        var sheetData = new SheetData();\n\n        for (int row = 0; row < outputRows.Count; row++)\n        {\n            var rowElement = new Row();\n            for (int col = 0; col < outputRows[row].Count; col++)\n            {\n                var cellElement = new Cell();\n                cellElement.CellValue = new CellValue(outputRows[row][col].ToString());\n                rowElement.AppendChild(cellElement);\n            }\n            sheetData.AppendChild(rowElement);\n        }\n\n        worksheetPart.Worksheet = new Worksheet(sheetData);\n        workbookPart.Workbook = new Workbook(new Sheets(new Sheet("Sheet1", "rId1")));\n        document.Save();\n    }\n}