using System;\nusing System.IO;\nusing iTextSharp.text.pdf;\n\nclass Program\n{\n    static void Main()\n    {\n        // Path to the input PDF\n        string inputPdf = "path/to/your/input.pdf";\n        \n        // Path to the output PDF\n        string outputPdf = "path/to/your/output.pdf";\n        \n        // Open the existing PDF\n        using (PdfReader pdfReader = new PdfReader(inputPdf))\n        {\n            using (FileStream fileStream = new FileStream(outputPdf, FileMode.Create, FileAccess.Write))\n            {\n                using (PdfStamper pdfStamper = new PdfStamper(pdfReader, fileStream))\n                {\n                    // Get the XFA form\n                    AcroFields form = pdfStamper.AcroFields;\n                    XfaForm xfa = form.Xfa;\n                    \n                    // Load the XML form data\n                    XmlDocument xmlDoc = xfa.DomDocument;\n                    \n                    // Modify the XML data (assuming you know the structure)\n                    XmlNode node = xmlDoc.SelectSingleNode("//YourFieldName");\n                    if (node != null)\n                    {\n                        node.InnerText = "New Value";\n                    }\n                    \n                    // Save the modified XML back\n                    xfa.DomDocument = xmlDoc;\n                    \n                    // Flatten the form if needed (optional)\n                    // pdfStamper.FormFlattening = true;\n                }\n            }\n        }\n    }\n}