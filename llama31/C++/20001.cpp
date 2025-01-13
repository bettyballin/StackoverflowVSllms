bool IsIEContainer(IOleClientSite* pClientSite)\n{\n    IOleContainer* pContainer;\n    HRESULT hr = pClientSite->GetContainer(&pContainer);\n    if (FAILED(hr))\n        return false;\n\n    IHtmlDocument2* pHtmlDoc;\n    hr = pContainer->QueryInterface(IID_IHtmlDocument2, (void**)&pHtmlDoc);\n    if (SUCCEEDED(hr))\n    {\n        pHtmlDoc->Release();\n        return true;\n    }\n\n    // Recursively check the ancestors\n    IOleClientSite* pParentSite;\n    hr = pContainer->QueryInterface(IID_IOleClientSite, (void**)&pParentSite);\n    if (SUCCEEDED(hr))\n    {\n        bool bIsIE = IsIEContainer(pParentSite);\n        pParentSite->Release();\n        return bIsIE;\n    }\n\n    pContainer->Release();\n    return false;\n}