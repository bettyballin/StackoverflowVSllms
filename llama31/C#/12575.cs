using System.Runtime.InteropServices;\n\n// Get the COM interface pointer\nIntPtr comPtr = Marshal.GetComInterfaceForObject(mytype, "MyCOMApp.Application");\n\n// Define the interface method you want to call\n[InterfaceType(ComInterfaceType.InterfaceIsIDispatch)]\n[Guid("...")] // replace with the actual GUID of the interface\npublic interface IMyCOMApp\n{\n    void MyMethod();\n}\n\n// Create a managed interface pointer\nIMyCOMApp comInterface = (IMyCOMApp)Marshal.PtrToStructure(comPtr, typeof(IMyCOMApp));\n\n// Call the method\ncomInterface.MyMethod();