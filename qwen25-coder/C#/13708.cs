using System;\nusing System.IO;\nusing iText.Kernel.Pdf.Annot;\nusing iText.Kernel.Pdf;\n\npublic class PdfUtils\n{\n    public static byte[] RemoveHyperlinks(byte[] pdfBytes)\n    {\n        using (var msInput = new MemoryStream(pdfBytes))\n        using (var pdfDocument = new PdfDocument(new PdfReader(msInput), new PdfWriter(new MemoryStream())))\n        {\n            for (int i = 1; i <= pdfDocument.GetNumberOfPages(); i++)\n            {\n                var page = pdfDocument.GetPage(i);\n                var annotations = page.GetAnnotations();\n\n                if (annotations != null)\n                {\n                    foreach (var annotation in annotations.ToArray())\n                    {\n                        if (annotation is PdfLinkAnnotation linkAnnotation)\n                        {\n                            page.RemoveAnnotation(linkAnnotation);\n                        }\n                    }\n                }\n            }\n\n            using (var msOutput = new MemoryStream())\n            {\n                pdfDocument.Copy PagesTo(msOutput);\n                return msOutput.ToArray();\n            }\n        }\n    }\n}