using System;\nusing System.Collections.Generic;\nusing SharpSvn;\n\nclass Program\n{\n    static void Main()\n    {\n        var url = "http://svn.example.com/repo"; // Replace with your SVN repository URL\n        var directoryPath = "/trunk/source";\n\n        using (var client = new SvnClient())\n        {\n            try\n            {\n                List<string> allFiles = new List<string>();\n                GetAllFiles(client, new Uri(url + directoryPath), ref allFiles);\n\n                foreach (var file in allFiles)\n                {\n                    Console.WriteLine(file);\n                }\n            }\n            catch (Exception e)\n            {\n                Console.Error.WriteLine("Error: " + e.Message);\n            }\n        }\n    }\n\n    static void GetAllFiles(SvnClient client, Uri uri, ref List<string> files)\n    {\n        var result = new SvnListResult();\n        if (client.List(uri, out Collection<SvnListItem> list))\n        {\n            foreach (var item in list)\n            {\n                var itemUri = new Uri(uri, item.Name);\n                if (item.Kind == SvnNodeKind.Directory)\n                {\n                    GetAllFiles(client, itemUri, ref files);\n                }\n                else if (item.Kind == SvnNodeKind.File)\n                {\n                    files.Add(itemUri.AbsolutePath);\n                }\n            }\n        }\n    }\n}