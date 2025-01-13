using System;\nusing Microsoft.Web.Administration;\n\npublic class SubdomainCreator {\n    public static void CreateSubdomain(string subDomain, string siteName) {\n        ServerManager serverManager = new ServerManager();\n        Site site = serverManager.Sites[siteName];\n        \n        foreach (Binding binding in site.Bindings) {\n            if (binding.Host == $"{subDomain}.example.com") {\n                Console.WriteLine("This sub-domain already exists.");\n                return;\n            }\n        }\n\n        Binding b = site.Bindings.Add("*:80:" + subDomain + ".example.com");\n        serverManager.CommitChanges();\n        Console.WriteLine($"Subdomain {subDomain}.example.com created successfully.");\n    }\n}