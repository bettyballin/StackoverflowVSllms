using System;\nusing System.IO;\nusing RSWebReference; // This namespace will depend on your project setup\n\nclass Program\n{\n    static void Main(string[] args)\n    {\n        string reportPath = "/Your/Report/Folder/ReportName"; // Path to the report in Report Manager\n        string historyID = null;\n        string deviceInfo = "<DeviceInfo><OutputFormat>PDF</OutputFormat></DeviceInfo>";\n        string format = "PDF";\n        string encoding = string.Empty;\n        string mimeType = string.Empty;\n        Warning[] warnings = null;\n        string[] streamIDs = null;\n\n        ReportingService2005 rs = new ReportingService2005();\n        rs.Url = "http://YourReportServer/ReportServer.ReportingService2005.asmx";\n        rs.Credentials = System.Net.CredentialCache.DefaultCredentials; // Use appropriate credentials\n\n        byte[] result = rs.Render(reportPath, format, deviceInfo, out extension, out mimeType, out encoding,\n                                  out warnings, out streamIDs);\n\n        string filePath = @"C:\Your\Destination\Folder\ReportName.pdf";\n        using (FileStream fs = new FileStream(filePath, FileMode.Create))\n        {\n            fs.Write(result, 0, result.Length);\n        }\n\n        Console.WriteLine("Report generated and saved to: " + filePath);\n    }\n}