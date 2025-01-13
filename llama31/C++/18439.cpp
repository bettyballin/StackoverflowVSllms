CLSID clsid;\nHRESULT hr = CLSIDFromProgID(L"YourProgID", &clsid);\nif (SUCCEEDED(hr)) {\n    IUnknown* pUnk = NULL;\n    hr = CoCreateInstance(clsid, NULL, CLSCTX_ALL, IID_IUnknown, (void**)&pUnk);\n    if (SUCCEEDED(hr)) {\n        // Try to query for a specific interface\n        IYourInterface* pInterface = NULL;\n        hr = pUnk->QueryInterface(IID_IYourInterface, (void**)&pInterface);\n        if (SUCCEEDED(hr)) {\n            // Use the interface\n            pInterface->Release();\n        }\n        pUnk->Release();\n    }\n}