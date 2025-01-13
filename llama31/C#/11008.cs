using System;\nusing System.IO;\nusing System.Windows.Forms;\nusing iTextSharp.text;\nusing iTextSharp.text.pdf;\n\npublic class PdfGenerator\n{\n    public void GeneratePdf(WebBrowser webBrowser, string pdfFilePath)\n    {\n        using (var pdfWriter = PdfWriter.GetInstance(Document, new FileStream(pdfFilePath, FileMode.Create)))\n        {\n            pdfWriter.SetPageSize(PageSize.A4);\n            var document = new Document();\n            document.Open();\n\n            webBrowser.PrintToPdf(pdfWriter);\n\n            document.Close();\n        }\n    }\n}\n\npublic static class WebBrowserExtensions\n{\n    public static void PrintToPdf(this WebBrowser webBrowser, PdfWriter pdfWriter)\n    {\n        var printDoc = new PrintDocument();\n        printDoc.DocumentName = "PDF Document";\n        printDoc.PrintController = new StandardPrintController();\n        printDoc.PrinterSettings.PrinterName = "PDF Printer";\n        printDoc.PrintPage += (sender, e) =>\n        {\n            var graphics = e.Graphics;\n            var size = webBrowser.ClientSize;\n            var image = new Bitmap(size.Width, size.Height);\n            webBrowser.DrawToBitmap(image, new Rectangle(0, 0, size.Width, size.Height));\n            graphics.DrawImage(image, 0, 0);\n        };\n        printDoc.PrintToPdf(pdfWriter);\n    }\n\n    public static void PrintToPdf(this PrintDocument printDoc, PdfWriter pdfWriter)\n    {\n        var pdfContentByte = pdfWriter.DirectContent;\n        var printController = new StandardPrintController();\n        var pageSettings = new PageSettings(printDoc.DefaultPageSettings);\n        pageSettings.PrinterSettings.PrinterName = "PDF Printer";\n        printDoc.PrintController = printController;\n        printDoc.PrinterSettings = pageSettings.PrinterSettings;\n        printDoc.Print();\n        var pdfPage = pdfWriter.GetImportedPage(new PdfReader(printController.GetPrintedPage()));\n        pdfContentByte.AddTemplate(pdfPage, 0, 0);\n    }\n}