System.Diagnostics.Process p = new System.Diagnostics.Process();\np.StartInfo.FileName = "acrobat.exe"; // or "acrord32.exe" for Adobe Acrobat Reader\np.StartInfo.Arguments = "/A \"" + CreatePDF() + "\""; // specify the PDF file as an argument\ntry\n{\n    if (!p.Start())\n        Controller.Error = "Opening acrobat failed..";\n}\ncatch (Exception ex)\n{\n    Controller.Error = "Create PDF::" + ex.Message;\n}