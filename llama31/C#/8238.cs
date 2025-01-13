using System.Drawing.Printing;\n\n// Load the PDF file\nbyte[] pdfBytes = File.ReadAllBytes("path/to/report.pdf");\n\n// Create a PrintDocument instance\nPrintDocument printDoc = new PrintDocument();\nprintDoc.DocumentName = "Report";\nprintDoc.PrinterSettings.PrinterName = "YourPrinterName";\nprintDoc.PrinterSettings.UserName = "YourUsername";\nprintDoc.PrinterSettings.Password = "YourPassword";\n\n// Create a PrintPage event handler\nprintDoc.PrintPage += (sender, e) =>\n{\n    // Draw the PDF page\n    e.Graphics.DrawImage(PdfToImage(pdfBytes), 0, 0);\n};\n\n// Print the document\nprintDoc.Print();