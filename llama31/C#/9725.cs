using System;\nusing System.Runtime.InteropServices;\n\nclass AxWrapperGenerator\n{\n    [DllImport("mscoree.dll", CharSet = CharSet.Unicode)]\n    static extern int Ax Imp(\n        [MarshalAs(UnmanagedType.LPWStr)] string inputAssemblyPath,\n        [MarshalAs(UnmanagedType.LPWStr)] string outputAssemblyPath,\n        [MarshalAs(UnmanagedType.LPWStr)] string namespaceName\n    );\n\n    static void Main(string[] args)\n    {\n        string inputAssemblyPath = @"C:\Path\To\AxABClib.dll";\n        string outputAssemblyPath = @"C:\Path\To\AxAxABClib.dll";\n        string namespaceName = "MyNamespace";\n\n        int result = AxImp(inputAssemblyPath, outputAssemblyPath, namespaceName);\n        if (result != 0)\n        {\n            Console.WriteLine("Error generating ActiveX wrapper: " + result);\n        }\n    }\n}