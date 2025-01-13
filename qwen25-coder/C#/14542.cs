using System;\nusing System.Runtime.InteropServices;\n\n[ComVisible(true)]\n[Guid("YOUR-GUID-HERE")]\npublic interface IYourInterface\n{\n    int YourMethod();\n}\n\n[ComVisible(true)]\n[Guid("ANOTHER-GUID-HERE")]\npublic class YourClass : IYourInterface\n{\n    public int YourMethod()\n    {\n        try\n        {\n            // Your logic here\n            return 0; // S_OK in HRESULT terms\n        }\n        catch (Exception ex)\n        {\n            // Log the exception if needed\n            Console.WriteLine("Exception occurred: " + ex.Message);\n            return -2147024894; // E_FAIL in HRESULT terms\n        }\n    }\n}