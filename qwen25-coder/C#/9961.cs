using System.IO;\nusing IOPath = System.IO.Path; // Alias for System.IO.Path\n\nclass Foo\n{\n   public string Path;\n\n   void Bar()\n   {\n       var combinedPath = IOPath.Combine("", ""); // Use the alias here\n   }\n}