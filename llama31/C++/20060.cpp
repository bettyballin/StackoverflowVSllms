HRESULT CompareComInterfaces(IUnknown* pUnk1, IUnknown* pUnk2)\n{\n    CComPtr<IUnknown> pUnk1Base;\n    CComPtr<IUnknown> pUnk2Base;\n\n    HRESULT hr = pUnk1->QueryInterface(IID_IUnknown, (void**)&pUnk1Base);\n    if (FAILED(hr))\n        return hr;\n\n    hr = pUnk2->QueryInterface(IID_IUnknown, (void**)&pUnk2Base);\n    if (FAILED(hr))\n        return hr;\n\n    return (pUnk1Base.p == pUnk2Base.p);\n}