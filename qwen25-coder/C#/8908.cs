using System.Collections.Generic;\nusing System.IO;\nusing iTextSharp.text;\nusing iTextSharp.text.pdf;\n\npublic byte[] GeneratePdfFromCanvas(string serializedData)\n{\n    var canvasObjects = DeserializeCanvas(serializedData);\n    Document document = new Document(PageSize.A4, 50, 50, 25, 25);\n    MemoryStream memoryStream = new MemoryStream();\n    PdfWriter writer = PdfWriter.GetInstance(document, memoryStream);\n\n    document.Open();\n\n    // For each object in the canvasObjects list\n    foreach (var obj in canvasObjects)\n    {\n        // Add your logic here to add objects like text or images based on obj properties to the PDF document\n    }\n\n    document.Close();\n    return memoryStream.ToArray(); // This byte array can be sent back to client as a downloadable PDF\n}\n\nprivate List<CanvasObject> DeserializeCanvas(string serializedData)\n{\n    DataContractJsonSerializer deserializer = new DataContractJsonSerializer(typeof(List<CanvasObject>));\n    using (var memStream = new MemoryStream(Encoding.Default.GetBytes(serializedData)))\n    {\n        return (List<CanvasObject>)deserializer.ReadObject(memStream);\n    }\n}