using System;\nusing Excel = Microsoft.Office.Interop.Excel;\n\nclass Program\n{\n    static void Main()\n    {\n        // Create a new instance of Excel application\n        Excel.Application excelApp = new Excel.Application();\n        \n        // Make it visible (optional, useful for debugging)\n        excelApp.Visible = true;\n\n        // Open the existing workbook or create a new one if needed\n        Excel.Workbook workbook;\n        try\n        {\n            workbook = excelApp.Workbooks.Open(@"C:\path\to\your\workbook.xls");\n        }\n        catch\n        {\n            workbook = excelApp.Workbooks.Add();\n        }\n\n        // Adding a new worksheet\n        Excel.Worksheet newWorksheet = null;\n        try\n        {\n            newWorksheet = (Excel.Worksheet)workbook.Worksheets.Add(\n                before: workbook.Sheets[workbook.Sheets.Count],\n                after: null,\n                count: 1,\n                type: Microsoft.Office.Interop.Excel.XlSheetType.xlWorksheet);\n\n            // Optionally, rename the new worksheet\n            newWorksheet.Name = "NewSheetName";\n        }\n        catch (Exception ex)\n        {\n            Console.WriteLine("Failed to add a new worksheet: " + ex.Message);\n        }\n\n        // Save and close workbook if needed\n        try\n        {\n            workbook.Save();\n            workbook.Close(false);\n            excelApp.Quit();\n        }\n        catch (Exception ex)\n        {\n            Console.WriteLine("Failed to save or close the workbook: " + ex.Message);\n        }\n\n        // Release COM objects\n        System.Runtime.InteropServices.Marshal.ReleaseComObject(newWorksheet);\n        System.Runtime.InteropServices.Marshal.ReleaseComObject(workbook);\n        System.Runtime.InteropServices.Marshal.ReleaseComObject(excelApp);\n\n        newWorksheet = null;\n        workbook = null;\n        excelApp = null;\n\n        GC.Collect();\n    }\n}