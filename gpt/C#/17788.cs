using Lucene.Net.Store;\nusing System.IO;\n\n// Define a custom path within your application's directory structure\nstring customPath = Server.MapPath("~/App_Data/LuceneIndex");\n\n// Ensure the directory exists\nif (!Directory.Exists(customPath))\n{\n    Directory.CreateDirectory(customPath);\n}\n\n// Create the FSDirectory instance pointing to the custom path\nFSDirectory directory = FSDirectory.Open(new DirectoryInfo(customPath));\n\n// Use the directory instance for your Lucene operations