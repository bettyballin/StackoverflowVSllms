using System;\nusing CTWebReport;\n\npublic class ReportGenerator\n{\n    public void GenerateReport()\n    {\n        try\n        {\n            IWebReportCOM report = new WebReportCOMClass();\n            // Use the report object as needed\n        }\n        catch (InvalidCastException ex)\n        {\n            Console.WriteLine("Error: " + ex.Message);\n        }\n    }\n}