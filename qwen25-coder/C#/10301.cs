using Microsoft.Web.Administration;\n\nprivate static void DeleteIISVDirAndAppPool(string siteName, string vDirName, string appPoolName)\n{\n    using (ServerManager serverManager = new ServerManager())\n    {\n        Site site = serverManager.Sites[siteName];\n        if (site != null)\n        {\n            var vDir = site.Applications["/"].VirtualDirectories[vDirName];\n            if (vDir != null)\n            {\n                // Delete Virtual Directory\n                site.Applications["/"].VirtualDirectories.Remove(vDir);\n                Console.WriteLine($"Removed virtual directory {vDirName}");\n            }\n\n            ApplicationPool appPool = serverManager.ApplicationPools[appPoolName];\n            if (appPool != null)\n            {\n                // Delete Application Pool\n                serverManager.ApplicationPools.Remove(appPool);\n                Console.WriteLine($"Removed application pool {appPoolName}");\n            }\n        }\n        else\n        {\n            Console.WriteLine("Site not found.");\n        }\n\n        serverManager.CommitChanges();\n    }\n}