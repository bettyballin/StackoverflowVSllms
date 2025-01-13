using Microsoft.Web.Administration;\n\nclass CreateVirtualDirectory\n{\n    static void Main(string[] args)\n    {\n        using (ServerManager serverManager = new ServerManager())\n        {\n            Site site = serverManager.Sites["YourSiteName"];\n            Application app = site.Applications["/"];\n\n            VirtualDirectory vdir = app.VirtualDirectories.Add("/YourVirtualDirectoryName", @"C:\Path\To\Physical\Directory");\n            serverManager.CommitChanges();\n        }\n    }\n}