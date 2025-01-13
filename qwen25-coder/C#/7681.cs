using EnvDTE;\nusing System;\n\npublic class CheckAddIns\n{\n    public static void Main()\n    {\n        DTE2 dte = new DTE2();\n        AddIns addins = dte.AddIns;\n\n        int count = addins.Count;\n        Console.WriteLine("Number of Add-ins: " + count);\n\n        foreach (AddIn addin in addins)\n        {\n            Console.WriteLine("Add-in Name: " + addin.Name);\n            Console.WriteLine("Connect: " + addin.Connect);\n            Console.WriteLine("Description: " + addin.Description);\n            Console.WriteLine("-----------------------------------");\n        }\n    }\n}