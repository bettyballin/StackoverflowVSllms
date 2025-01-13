byte[] pdfbytes = Convert.FromBase64String(rapportB64);\n\nResponse.ClearContent();\nResponse.ClearHeaders();\nResponse.Buffer = true;\nResponse.ContentType = "application/pdf"; // Make sure to set the correct content type\n\n// Set headers to allow caching\nResponse.AddHeader("Content-Disposition", "inline; filename=APKrapport.pdf");\nResponse.AddHeader("Cache-Control", "private, max-age=0, must-revalidate, post-check=0, pre-check=0");\nResponse.AddHeader("Pragma", "public"); // HTTP/1.0\nResponse.AddHeader("Expires", "0");\n\nResponse.BinaryWrite(pdfbytes);         \nResponse.Flush(); \nResponse.End();