HRESULT MyComMethod()\n{\n    ICreateErrorInfo* pCreateErrorInfo;\n    IErrorInfo* pErrorInfo;\n    HRESULT hr = CreateErrorInfo(&pCreateErrorInfo);\n    if (SUCCEEDED(hr))\n    {\n        pCreateErrorInfo->SetDescription(L"C++ Exception");\n        hr = pCreateErrorInfo->QueryInterface(IID_IErrorInfo, (LPVOID FAR*)&pErrorInfo);\n        if (SUCCEEDED(hr))\n        {\n            SetErrorInfo(0, pErrorInfo);\n            pErrorInfo->Release();\n        }\n        pCreateErrorInfo->Release();\n    }\n    return E_FAIL; // or a more specific error code\n}