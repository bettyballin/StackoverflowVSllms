using System;\nusing System.Runtime.InteropServices;\n\npublic class ComLoader\n{\n    [DllImport("kernel32.dll", SetLastError = true)]\n    private static extern IntPtr LoadLibrary(string dllToLoad);\n\n    [DllImport("kernel32.dll", SetLastError = true)]\n    private static extern IntPtr GetProcAddress(IntPtr hModule, string procedureName);\n\n    [DllImport("kernel32.dll", SetLastError = true)]\n    [return: MarshalAs(UnmanagedType.Bool)]\n    private static extern bool FreeLibrary(IntPtr hModule);\n\n    [ComImport, Guid("00000001-0000-0000-C000-000000000046")]\n    [InterfaceType(ComInterfaceType.InterfaceIsIUnknown)]\n    private interface IClassFactory\n    {\n        void CreateInstance([MarshalAs(UnmanagedType.IUnknown)] object pUnkOuter,\n                            [MarshalAs(UnmanagedType.LPStruct)] Guid riid,\n                            out IntPtr ppvObject);\n        void LockServer(bool fLock);\n    }\n\n    public static object LoadComObject(string dllPath, string clsidString, string interfaceGuidString)\n    {\n        IntPtr hModule = LoadLibrary(dllPath);\n        if (hModule == IntPtr.Zero)\n        {\n            throw new Exception("Failed to load the library.");\n        }\n\n        try\n        {\n            Guid clsid = new Guid(clsidString);\n            Guid iid = new Guid(interfaceGuidString);\n            IntPtr classFactoryPtr = GetProcAddress(hModule, "DllGetClassObject");\n            if (classFactoryPtr == IntPtr.Zero)\n            {\n                throw new Exception("Failed to get DllGetClassObject address.");\n            }\n\n            var dllGetClassObject = Marshal.GetDelegateForFunctionPointer<DllGetClassObjectDelegate>(classFactoryPtr);\n            dllGetClassObject(ref clsid, ref iid, out IntPtr factoryPtr);\n\n            var classFactory = (IClassFactory)Marshal.GetObjectForIUnknown(factoryPtr);\n            classFactory.CreateInstance(null, ref iid, out IntPtr comObjectPtr);\n\n            return Marshal.GetObjectForIUnknown(comObjectPtr);\n        }\n        finally\n        {\n            FreeLibrary(hModule);\n        }\n    }\n\n    [UnmanagedFunctionPointer(CallingConvention.StdCall)]\n    private delegate int DllGetClassObjectDelegate(ref Guid clsid, ref Guid iid, out IntPtr ppv);\n}