#include <windows.h>\n#include <ole2.h> // OLE2 Definitions\n\nint main()\n{\n    CoInitialize(NULL); // Initialize the COM library.\n\n    CLSID clsid;\n    HRESULT hr = CLSIDFromProgID(L"Excel.Application", &clsid);\n    if (FAILED(hr)) {\n        // Handle error\n        return -1;\n    }\n\n    IDispatch* pXlApp = NULL;\n    hr = CoCreateInstance(clsid, NULL, CLSCTX_LOCAL_SERVER,\n                          IID_IDispatch, (void**) &pXlApp);\n    if (FAILED(hr)) {\n        // Handle error\n        CoUninitialize();\n        return -1;\n    }\n\n    // Make Excel visible or whatever you wish.\n    pXlApp->Release();\n\n    CoUninitialize();   // Uninitialize the COM library.\n\n    return 0;\n}