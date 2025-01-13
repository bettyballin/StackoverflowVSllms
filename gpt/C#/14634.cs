private static void CreateVDir(string metabasePath, string vDirName, string physicalPath)\n{\n    //  metabasePath is of the form "IIS://<servername>/<service>/<siteID>/Root[/<vdir>]"\n    //    for example "IIS://localhost/W3SVC/1/Root".\n    //  vDirName is of the form "<name>", for example, "MyNewVDir".\n    //  physicalPath is of the form "<drive>:\<path>", for example, "C:\Inetpub\Wwwroot".\n    Console.WriteLine("\nCreating virtual directory {0}/{1}, mapping the Root application to {2}:",\n                      metabasePath, vDirName, physicalPath);\n\n    DirectoryEntry site = new DirectoryEntry(metabasePath);\n    string className = site.SchemaClassName;\n    if ((className.EndsWith("Server")) || (className.EndsWith("VirtualDir")))\n    {\n        DirectoryEntries vdirs = site.Children;\n        DirectoryEntry newVDir = vdirs.Add(vDirName, (className.Replace("Service", "VirtualDir")));\n        newVDir.Properties["Path"][0] = physicalPath;\n        newVDir.Properties["AccessScript"][0] = true;\n        // These properties are necessary for an application to be created.\n        newVDir.Properties["AppFriendlyName"][0] = vDirName;\n        newVDir.Properties["AppIsolated"][0] = "1";\n        newVDir.Properties["AppRoot"][0] = \n           "/LM" +\n           metabasePath.Substring(metabasePath.IndexOf("/", ("IIS://".Length)));\n        newVDir.CommitChanges();\n\n        // Set the .NET Framework version to 2.0\n        newVDir.Properties["ScriptMaps"].Add(@".aspx,C:\Windows\Microsoft.NET\Framework\v2.0.50727\aspnet_isapi.dll,1,GET,HEAD,POST,DEBUG");\n        newVDir.CommitChanges();\n\n        Console.WriteLine(" Done.");\n    }\n    else\n    {\n        Console.WriteLine(\n            " Failed. A virtual directory can only be created in a site or virtual directory node.");\n    }\n}