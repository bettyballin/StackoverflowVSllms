using System;\nusing Microsoft.Office.Interop.Excel;\n\nclass Program\n{\n    static void Main(string[] args)\n    {\n        Application excelApp = new Application();\n        Workbook workbook = excelApp.Workbooks.Open(@"C:\path\to\your\exportedfile.xlsx");\n        Worksheet worksheet = workbook.Sheets[1];\n        \n        // Assuming you want to change all cell borders in the range A1:D10\n        Range rangeToFormat = worksheet.Range["A1:D10"];\n        Borders borders = rangeToFormat.Borders;\n        \n        foreach (Border border in borders)\n        {\n            border.Weight = XlBorderWeight.xlThin; // Set the line weight to thin\n        }\n        \n        workbook.Save();\n        workbook.Close();\n        excelApp.Quit();\n\n        System.Runtime.InteropServices.Marshal.ReleaseComObject(border);\n        System.Runtime.InteropServices.Marshal.ReleaseComObject(borders);\n        System.Runtime.InteropServices.Marshal.ReleaseComObject(rangeToFormat);\n        System.Runtime.InteropServices.Marshal.ReleaseComObject(worksheet);\n        System.Runtime.InteropServices.Marshal.ReleaseComObject(workbook);\n        System.Runtime.InteropServices.Marshal.ReleaseComObject(excelApp);\n\n        GC.Collect();\n    }\n}