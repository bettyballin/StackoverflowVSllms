using System.IO;\n\n[HttpGet]\npublic ActionResult DownloadFile(string fileName)\n{\n    string sharedFolder = @"C:\SharedFiles";\n    string filePath = Path.Combine(sharedFolder, fileName);\n    if (File.Exists(filePath))\n    {\n        return File(filePath, "application/octet-stream", fileName);\n    }\n    return HttpNotFound();\n}