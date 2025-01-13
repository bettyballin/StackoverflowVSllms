using System;\nusing System.Runtime.InteropServices;\n\npublic class OcxLoader\n{\n    [DllImport("kernel32.dll", SetLastError = true, CharSet = CharSet.Auto)]\n    private static extern IntPtr LoadLibrary(string lpFileName);\n\n    [DllImport("kernel32.dll", SetLastError = true)]\n    private static extern bool FreeLibrary(IntPtr hModule);\n\n    [DllImport("kernel32.dll", SetLastError = true)]\n    private static extern IntPtr GetProcAddress(IntPtr hModule, string lpProcName);\n\n    private IntPtr _hModule;\n\n    public bool LoadOcx(string ocxPath)\n    {\n        _hModule = LoadLibrary(ocxPath);\n        return _hModule != IntPtr.Zero;\n    }\n\n    public void UnloadOcx()\n    {\n        if (_hModule != IntPtr.Zero)\n        {\n            FreeLibrary(_hModule);\n            _hModule = IntPtr.Zero;\n        }\n    }\n\n    public IntPtr GetOcxProcAddress(string procName)\n    {\n        if (_hModule == IntPtr.Zero)\n        {\n            throw new InvalidOperationException("OCX is not loaded.");\n        }\n\n        return GetProcAddress(_hModule, procName);\n    }\n}