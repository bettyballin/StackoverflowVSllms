HRESULT STDMETHODCALLTYPE QueryInterface(REFIID iid, void **ppvObject)\n{\n    if (iid == __uuidof(IUnknown) || iid == __uuidof(IS8SimulationEvents))\n    {\n        *ppvObject = (IS8SimulationEvents*)this;\n    } else {\n        *ppvObject = NULL;\n        return E_NOINTERFACE;\n    }\n    m_dwRefCount++;\n    return S_OK;\n};