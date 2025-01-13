using System;\nusing Microsoft.Office.Interop.Word;\n\nclass Program\n{\n    static void Main()\n    {\n        // Create a new application class object\n        Application wordApp = new Application();\n\n        // Open the word document, assuming it's located at specified path and is a .docx file\n        Document wordDoc = wordApp.Documents.Open(@"C:\path\to\your\form.docx");\n\n        // Define bookmark names as they appear in your Word template document\n        string bookmarkToFill1 = "BookmarkName1";\n        string bookmarkToFill2 = "BookmarkName2";\n\n        // Fill content into bookmarks within the document\n        wordDoc.Bookmarks[bookmarkToFill1].Range.Text = "Value for Field 1";\n        wordDoc.Bookmarks[bookmarkToFill2].Range.Text = "Value for Field 2";\n\n        // Print the document\n        wordDoc.PrintOut();\n\n        // Close the document without saving changes and close Word application\n        wordDoc.Close(false);\n        wordApp.Quit();\n    }\n}