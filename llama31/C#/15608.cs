using System;\nusing System.DirectoryServices;\n\nclass AddWebsiteToIIS\n{\n    static void Main(string[] args)\n    {\n        // Set the website properties\n        string websiteName = "MyNewWebsite";\n        string physicalPath = @"C:\inetpub\wwwroot\MyNewWebsite";\n        int port = 80;\n\n        // Create a new DirectoryEntry for the IIS metabase\n        DirectoryEntry iisRoot = new DirectoryEntry("IIS://localhost/W3SVC");\n\n        // Create a new website\n        DirectoryEntry newWebsite = iisRoot.Children.Add(websiteName, "IIsWebServer");\n\n        // Set the website properties\n        newWebsite.Properties["ServerComment"].Value = websiteName;\n        newWebsite.Properties["DefaultDoc"].Value = "Default.aspx";\n        newWebsite.Properties["Path"].Value = physicalPath;\n        newWebsite.Properties["Port"].Value = port;\n\n        // Save the changes\n        newWebsite.CommitChanges();\n    }\n}