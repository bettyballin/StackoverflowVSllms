using System;\nusing Microsoft.Web.Administration; // Ensure to add a reference to System.Web.Management.dll\n\npublic int GetSiteId()\n{\n    string currentSiteName = Server.ServerVariables["SERVER_NAME"];\n    using (ServerManager serverManager = new ServerManager())\n    {\n        foreach (Site site in serverManager.Sites)\n        {\n            if (site.Bindings.CollectionContains(currentSiteName))\n            {\n                return site.Id;\n            }\n        }\n        throw new Exception("Site ID not found");\n    }\n}