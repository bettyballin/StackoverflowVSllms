extern CAtlModule _AtlModule;\n\nSTDAPI DllRegisterServer(void)\n{\n    HRESULT hr = _AtlModule.RegisterServer(TRUE);\n\n    if (SUCCEEDED(hr))\n    {\n        // Manually add the win64 key if necessary\n        // This is just a placeholder for the actual registry manipulation code\n        // You can use the Windows Registry API to add the required keys\n    }\n\n    return hr;\n}