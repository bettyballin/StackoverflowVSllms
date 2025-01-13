using System;\nusing Microsoft.SharePoint;\n\nclass Program\n{\n    static void Main()\n    {\n        string siteUrl = "http://your-site-url";\n        string libraryName = "YourDocumentLibrary";\n\n        using (SPSite site = new SPSite(siteUrl))\n        {\n            using (SPWeb web = site.OpenWeb())\n            {\n                SPFolder folder = web.Folders[libraryName];\n                \n                // Assuming you have a directory with HTML files\n                string[] filePaths = System.IO.Directory.GetFiles("path-to-your-html-files", "*.html");\n                \n                foreach (string file in filePaths)\n                {\n                    byte[] binFile = System.IO.File.ReadAllBytes(file);\n                    string fileName = System.IO.Path.GetFileName(file);\n                    \n                    SPFile spfile = folder.Files.Add(fileName, binFile, true);\n                    spfile.Update();\n                }\n            }\n        }\n    }\n}