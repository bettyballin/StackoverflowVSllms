// Example of invoking CeRapiInvoke() in C#\n[DllImport("rapi.dll", CharSet = CharSet.Unicode)]\npublic static extern int CeRapiInvoke(\n    string pDllPath,\n    string pFunctionName,\n    int cbInput,\n    byte[] pInput,\n    ref int pcbOutput,\n    ref IntPtr ppOutput,\n    IntPtr ppIRAPIStream\n);\n\n// Usage\nbyte[] input = new byte[] { /* input data */ };\nint outputSize = 0;\nIntPtr outputPtr = IntPtr.Zero;\n\nint result = CeRapiInvoke(\n    "MyDll.dll",\n    "MyFunction",\n    input.Length,\n    input,\n    ref outputSize,\n    ref outputPtr,\n    IntPtr.Zero\n);