#include <iostream>\n#include <Windows.h>\n#include <Ole2.h>\n#include <comdef.h>\n\n// Replace with your OCX's CLSID and the interface you want to use\nconst CLSID CLSID_MyOCX = { /* your OCX CLSID here */ };\nconst IID IID_IMyOCXInterface = { /* your OCX interface IID here */ };\n\nint main() {\n    HRESULT hr;\n    IUnknown* pUnknown = nullptr;\n\n    // Initialize COM library\n    hr = CoInitialize(NULL);\n    if (FAILED(hr)) {\n        std::cerr << "Failed to initialize COM library" << std::endl;\n        return 1;\n    }\n\n    // Create an instance of the OCX\n    hr = CoCreateInstance(CLSID_MyOCX, NULL, CLSCTX_INPROC_SERVER, IID_IMyOCXInterface, (void**)&pUnknown);\n    if (FAILED(hr)) {\n        std::cerr << "Failed to create OCX instance" << std::endl;\n        CoUninitialize();\n        return 1;\n    }\n\n    // Query for the interface you need\n    IMyOCXInterface* pMyOCX = nullptr;\n    hr = pUnknown->QueryInterface(IID_IMyOCXInterface, (void**)&pMyOCX);\n    if (FAILED(hr)) {\n        std::cerr << "Failed to query interface" << std::endl;\n        pUnknown->Release();\n        CoUninitialize();\n        return 1;\n    }\n\n    // Now you can use the OCX through pMyOCX\n    // Example: pMyOCX->SomeMethod();\n\n    // Clean up\n    pMyOCX->Release();\n    pUnknown->Release();\n    CoUninitialize();\n\n    return 0;\n}