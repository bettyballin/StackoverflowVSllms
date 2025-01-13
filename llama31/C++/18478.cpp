HRESULT hr = E_FAIL;\nIConnectionPointContainer* pContainer = NULL;\nIEnumConnectionPoints* pEnum = NULL;\n\n// Get the container's IConnectionPointContainer interface\nhr = pis8->QueryInterface(__uuidof(IConnectionPointContainer), (void**)&pContainer);\nif (SUCCEEDED(hr))\n{\n    // Enumerate the connection points\n    hr = pContainer->EnumConnectionPoints(&pEnum);\n    if (SUCCEEDED(hr))\n    {\n        CONNECTDATA data;\n        while (pEnum->Next(1, &data, NULL) == S_OK)\n        {\n            // Check if the connection point supports multiple connections\n            IConnectionPoint* pConnection = data.pUnk;\n            DWORD dwMaxConnections;\n            hr = pConnection->GetMaxConnections(&dwMaxConnections);\n            if (SUCCEEDED(hr) && dwMaxConnections > 1)\n            {\n                // The connection point supports multiple connections\n                break;\n            }\n        }\n        pEnum->Release();\n    }\n    pContainer->Release();\n}