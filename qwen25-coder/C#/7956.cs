using System.Diagnostics;\n\nstring pdfPath = CreatePDF(); // method that creates your pdf and returns the full path\n\ntry\n{\n    Process p = new Process();\n    p.StartInfo.FileName = "AcroRd32.exe"; // Path to Adobe Acrobat Reader, adjust as needed\n    p.StartInfo.Arguments = pdfPath;\n    if (!p.Start())\n        Controller.Error = "Opening PDF failed.";\n}\ncatch (Exception ex)\n{\n    Controller.Error = "Create PDF::" + ex.Message;\n}