Guid clsid = new Guid("your-com-component-clsid");\nGuid riid = new Guid("your-com-component-riid");\n\nCOSERVERINFO serverInfo = new COSERVERINFO();\nserverInfo.pwszName = "your-remote-server-name";\nserverInfo.pContext = IntPtr.Zero;\nserverInfo.dwReserved1 = 0;\nserverInfo.dwReserved2 = 0;\n\nIntPtr punkOuter = IntPtr.Zero;\nuint context = 1; // CLSCTX_REMOTE_SERVER\nbyte[] result = new byte[1024];\nuint pcount;\nIntPtr ppv;\n\nint hr = CoCreateInstanceEx(ref clsid, punkOuter, context, riid, result, out pcount, (IntPtr)(&serverInfo), out ppv);\nif (hr != 0)\n{\n    // Handle the error\n}\n\n// Use the created COM object