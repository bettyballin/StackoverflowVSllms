#include <windows.h>\n#include <comdef.h>\n#include <iostream>\n#import "C:\\Program Files\\Common Files\\Microsoft Shared\\OFFICE14\\MSO.DLL" no_namespace\n#import "C:\\Program Files\\Microsoft Office\\Office14\\EXCEL.EXE" auto_search auto_rename\n\nint main() {\n    // Initialize COM library\n    HRESULT hr = CoInitialize(NULL);\n    if (FAILED(hr)) {\n        std::cerr << "Failed to initialize COM library." << std::endl;\n        return 1;\n    }\n\n    // Get CLSID for Excel.Application\n    CLSID clsid;\n    hr = CLSIDFromProgID(L"Excel.Application", &clsid);\n    if (FAILED(hr)) {\n        std::cerr << "Failed to get CLSID for Excel.Application." << std::endl;\n        CoUninitialize();\n        return 1;\n    }\n\n    // Create an instance of Excel\n    IDispatch* pExcel = NULL;\n    hr = CoCreateInstance(clsid, NULL, CLSCTX_LOCAL_SERVER, IID_IDispatch, (void**)&pExcel);\n    if (FAILED(hr)) {\n        std::cerr << "Failed to create Excel instance." << std::endl;\n        CoUninitialize();\n        return 1;\n    }\n\n    // Make Excel visible\n    {\n        VARIANT x;\n        x.vt = VT_I4;\n        x.lVal = 1; // true\n        DISPID dispID;\n        OLECHAR* name = L"Visible";\n        hr = pExcel->GetIDsOfNames(IID_NULL, &name, 1, LOCALE_USER_DEFAULT, &dispID);\n        if (SUCCEEDED(hr)) {\n            DISPPARAMS dispParams = { &x, NULL, 1, 0 };\n            pExcel->Invoke(dispID, IID_NULL, LOCALE_USER_DEFAULT, DISPATCH_PROPERTYPUT, &dispParams, NULL, NULL, NULL);\n        }\n    }\n\n    // Release Excel instance\n    pExcel->Release();\n    pExcel = NULL;\n\n    // Uninitialize COM library\n    CoUninitialize();\n\n    return 0;\n}