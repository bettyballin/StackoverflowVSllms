using System;\nusing System.IO;\nusing System.Web.UI.WebControls;\nusing iTextSharp.text;\nusing iTextSharp.text.pdf;\n\npublic void ExportGridViewToPdf(GridView gridView)\n{\n    // Create a Document object\n    Document pdfDoc = new Document(PageSize.A4, 10f, 10f, 10f, 0f);\n\n    try\n    {\n        // Create a memory stream to hold the PDF data\n        using (MemoryStream memoryStream = new MemoryStream())\n        {\n            PdfWriter writer = PdfWriter.GetInstance(pdfDoc, memoryStream);\n            pdfDoc.Open();\n\n            // Create a table with the same number of columns as the GridView\n            PdfPTable pdfTable = new PdfPTable(gridView.HeaderRow.Cells.Count);\n\n            // Add the header row\n            foreach (TableCell headerCell in gridView.HeaderRow.Cells)\n            {\n                Font font = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD);\n                PdfPCell pdfCell = new PdfPCell(new Phrase(headerCell.Text, font));\n                pdfCell.BackgroundColor = new BaseColor(gridView.HeaderStyle.BackColor);\n                pdfTable.AddCell(pdfCell);\n            }\n\n            // Add the data rows\n            foreach (GridViewRow gridViewRow in gridView.Rows)\n            {\n                foreach (TableCell tableCell in gridViewRow.Cells)\n                {\n                    Font font = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL);\n                    PdfPCell pdfCell = new PdfPCell(new Phrase(tableCell.Text, font));\n                    pdfTable.AddCell(pdfCell);\n                }\n            }\n\n            // Add the table to the document\n            pdfDoc.Add(pdfTable);\n            pdfDoc.Close();\n\n            byte[] bytes = memoryStream.ToArray();\n            memoryStream.Close();\n\n            // Output the PDF to the response\n            HttpContext.Current.Response.ContentType = "application/pdf";\n            HttpContext.Current.Response.AddHeader("content-disposition", "attachment;filename=GridViewExport.pdf");\n            HttpContext.Current.Response.BinaryWrite(bytes);\n            HttpContext.Current.Response.End();\n        }\n    }\n    catch (Exception ex)\n    {\n        // Handle any exceptions\n        throw new Exception("Error exporting GridView to PDF", ex);\n    }\n}