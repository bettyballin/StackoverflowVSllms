using Excel = Microsoft.Office.Interop.Excel;\n\npublic sealed class ExcelAddin\n{\n    public void OnStartup(Excel.Application app)\n    {\n        var main = new Main();\n        // Use the main object to call your .NET code...\n    }\n}