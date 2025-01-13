using System;\nusing Microsoft.Office.Interop.Word;\n\nclass Program\n{\n    static void Main(string[] args)\n    {\n        // Create a new instance of the Word application\n        Application wordApp = new Application();\n        \n        // Make the application visible (optional for background processing)\n        wordApp.Visible = true;\n\n        // Add a new document\n        Document doc = wordApp.Documents.Add();\n\n        // Add some text to the document\n        Range range = doc.Range(0, 0);\n        range.Text = "Hello, this is a test document!";\n\n        // Save the document\n        doc.SaveAs2("C:\\Path\\To\\Your\\Document.docx");\n\n        // Close the document and quit Word application\n        doc.Close();\n        wordApp.Quit();\n\n        // Release COM objects to fully kill Excel process from running in the background (optional)\n        System.Runtime.InteropServices.Marshal.ReleaseComObject(range);\n        System.Runtime.InteropServices.Marshal.ReleaseComObject(doc);\n        System.Runtime.InteropServices.Marshal.ReleaseComObject(wordApp);\n\n        Console.WriteLine("Document created and saved.");\n    }\n}