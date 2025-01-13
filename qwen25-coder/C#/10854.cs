using System;\nusing System.Collections.Generic;\nusing Excel = Microsoft.Office.Interop.Excel;\n\npublic class ExcelExporter\n{\n    public void ExportDataToExcel(List<List<object>> outputRows)\n    {\n        object oOpt = Missing.Value; //for optional arguments\n        Excel.Application oXL = new Excel.Application();\n        if (oXL == null)\n        {\n            throw new InvalidOperationException("Failed to create Excel instance.");\n        }\n\n        try\n        {\n            Excel.Workbooks oWBs = oXL.Workbooks;\n            Excel._Workbook oWB = oWBs.Add(Excel.XlWBATemplate.xlWBATWorksheet);\n            Excel._Worksheet oSheet = (Excel._Worksheet)oWB.ActiveSheet;\n\n            int numberOfRows = outputRows.Count;\n            int numberOfColumns = 0;\n\n            // Determine the maximum number of columns\n            foreach (var row in outputRows)\n            {\n                if (row.Count > numberOfColumns)\n                {\n                    numberOfColumns = row.Count;\n                }\n            }\n\n            // Create a 2D array to hold the data\n            object[,] outputArray = new object[numberOfRows, numberOfColumns];\n            for (int row = 0; row < numberOfRows; row++)\n            {\n                List<object> currentRow = outputRows[row];\n                for (int col = 0; col < currentRow.Count; col++)\n                {\n                    outputArray[row, col] = currentRow[col];\n                }\n            }\n\n            // Write the data to Excel\n            Excel.Range oRng = oSheet.Range[oSheet.Cells[1, 1], oSheet.Cells[numberOfRows, numberOfColumns]];\n            oRng.Value2 = outputArray;\n\n            oXL.Visible = true;\n        }\n        catch (Exception ex)\n        {\n            Console.WriteLine("An error occurred: " + ex.Message);\n        }\n        finally\n        {\n            // Ensure Excel is closed properly\n            if (oXL != null)\n            {\n                oXL.Quit();\n                System.Runtime.InteropServices.Marshal.ReleaseComObject(oXL);\n            }\n        }\n    }\n}