using System.DirectoryServices;\nusing System;\n \npublic class IISAdmin\n{\n    /// <summary>\n    /// Adds a host header value to a specified website. WARNING: NO ERROR CHECKING IS PERFORMED IN THIS EXAMPLE. \n    /// YOU ARE RESPONSIBLE FOR THAT EVERY ENTRY IS UNIQUE\n    /// </summary>\n    /// <param name="hostHeader">The host header. Must be in the form IP:Port:Hostname </param>\n    /// <param name="websiteID">The ID of the website the host header should be added to </param>\n    public static void AddHostHeader(string hostHeader, string websiteID)\n    {\n        \n        DirectoryEntry site = new DirectoryEntry("IIS://localhost/w3svc/" + websiteID );\n        try\n        {                        \n            //Get everything currently in the serverbindings propery. \n            PropertyValueCollection serverBindings = site.Properties["ServerBindings"];\n            \n            //Add the new binding\n            serverBindings.Add(hostHeader);\n            \n            //Create an object array and copy the content to this array\n            Object [] newList = new Object[serverBindings.Count];\n            serverBindings.CopyTo(newList, 0);\n            \n            //Write to metabase\n            site.Properties["ServerBindings"].Value = newList;            \n                        \n            //Commit the changes\n            site.CommitChanges();\n                        \n        }\n        catch (Exception e)\n        {\n            Console.WriteLine(e);\n        }\n        \n    }\n}\n \npublic class TestApp\n{\n    public static void Main(string[] args)\n    {\n        IISAdmin.AddHostHeader(":80:test.com", "1");\n    }\n}