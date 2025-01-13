using iTextSharp.text;\n   using iTextSharp.text.pdf;\n   using System.IO;\n   using System.Web.Mvc;\n\n   public class PdfController : Controller\n   {\n       public ActionResult CreatePdf()\n       {\n           // Create a new document\n           Document document = new Document();\n           \n           // Set the output file path\n           string filePath = Server.MapPath("~/App_Data/Example.pdf");\n           \n           // Create a PDF writer instance\n           PdfWriter writer = PdfWriter.GetInstance(document, new FileStream(filePath, FileMode.Create));\n           \n           // Open the document for writing\n           document.Open();\n           \n           // Add content to the document\n           document.Add(new Paragraph("Hello, this is a test PDF document."));\n           \n           // Close the document\n           document.Close();\n           \n           // Return the file as a download\n           return File(filePath, "application/pdf", "Example.pdf");\n       }\n   }