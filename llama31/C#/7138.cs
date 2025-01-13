using iTextSharp.text;\nusing iTextSharp.text.pdf;\nusing iTextSharp.tool.xml;\n\n// Create a PDF writer\nvar pdfWriter = PdfWriter.GetInstance(document, new FileStream("output.pdf", FileMode.Create));\n\n// Create a PDF document\nvar document = new Document(PageSize.A4);\n\n// Convert HTML to PDF\nvar html = File.ReadAllText("input.html");\nvar elements = XMLWorkerHelper.ParseToElementList(html, null);\nforeach (var element in elements)\n{\n    document.Add(element);\n}\n\n// Close the PDF writer\npdfWriter.Close();