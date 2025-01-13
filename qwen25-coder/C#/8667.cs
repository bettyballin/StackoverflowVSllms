using System;\nusing System.Runtime.InteropServices;\n\nclass Program\n{\n    static void Main()\n    {\n        // Get the type from ProgID, not CLSID, to handle changes in GUIDs\n        Type comType = Type.GetTypeFromProgID("MyCOMApp.Application");\n\n        // Create an instance of the COM object as dynamic\n        dynamic comObject = Activator.CreateInstance(comType);\n\n        // Call a method on the COM object\n        try\n        {\n            var result = comObject.SomeMethod();\n            Console.WriteLine(result);\n        }\n        catch (Exception ex)\n        {\n            Console.WriteLine("An error occurred: " + ex.Message);\n        }\n\n        // Release COM resources if necessary\n        Marshal.ReleaseComObject(comObject);\n    }\n}