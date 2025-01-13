private static void DeleteTree(string metabasePath)\n{\n    // metabasePath is of the form "IIS://<servername>/<path>"\n    // for example "IIS://localhost/W3SVC/1/Root/MyVDir" \n    // or "IIS://localhost/W3SVC/AppPools/MyAppPool"\n    Console.WriteLine("Deleting {0}:", metabasePath);\n\n    try\n    {\n        DirectoryEntry tree = new DirectoryEntry(metabasePath);\n        tree.DeleteTree();\n        Console.WriteLine("Done.");\n    }\n    catch (DirectoryNotFoundException)\n    {\n        Console.WriteLine("Not found.");\n    }\n}