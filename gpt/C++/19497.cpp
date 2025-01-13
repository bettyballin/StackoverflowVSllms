class ATL_NO_VTABLE CHelloWorldBHO :\n    public CComObjectRootEx<CComSingleThreadModel>,\n    public CComCoClass<CHelloWorldBHO, &CLSID_HelloWorldBHO>,\n    public IObjectWithSiteImpl<CHelloWorldBHO>,\n    public IDispatchImpl<IHelloWorldBHO, &IID_IHelloWorldBHO, &LIBID_HelloWorldLib, /*wMajor =*/ 1, /*wMinor =*/ 0>,\n    public IDispEventImpl<1, CHelloWorldBHO, &DIID_DWebBrowserEvents2, &LIBID_SHDocVw, 1, 1>\n{\npublic:\n    // Define a separate class to handle HTMLElementEvents2\n    class HTMLElementEventsHandler : public IDispatch\n    {\n    public:\n        HTMLElementEventsHandler(CHelloWorldBHO* parent) : m_parent(parent) {}\n\n        STDMETHODIMP QueryInterface(REFIID riid, void** ppv)\n        {\n            if (riid == IID_IUnknown || riid == IID_IDispatch)\n            {\n                *ppv = static_cast<IDispatch*>(this);\n                AddRef();\n                return S_OK;\n            }\n            *ppv = nullptr;\n            return E_NOINTERFACE;\n        }\n\n        STDMETHODIMP_(ULONG) AddRef() { return m_parent->AddRef(); }\n        STDMETHODIMP_(ULONG) Release() { return m_parent->Release(); }\n\n        STDMETHODIMP GetTypeInfoCount(UINT* pctinfo) { return E_NOTIMPL; }\n        STDMETHODIMP GetTypeInfo(UINT iTInfo, LCID lcid, ITypeInfo** ppTInfo) { return E_NOTIMPL; }\n        \n        STDMETHODIMP GetIDsOfNames(REFIID riid, LPOLESTR* rgszNames, UINT cNames, LCID lcid, DISPID* rgDispId) { return E_NOTIMPL; }\n\n        STDMETHODIMP Invoke(DISPID dispIdMember, REFIID riid, LCID lcid, WORD wFlags, DISPPARAMS* pDispParams, VARIANT* pVarResult, EXCEPINFO* pExcepInfo, UINT* puArgErr)\n        {\n            // Handle HTMLElementEvents2 here\n            if (dispIdMember == DISPID_HTMLELEMENTEVENTS2_ONCLICK)\n            {\n                // Handle click event\n                // ...\n                return S_OK;\n            }\n            return E_NOTIMPL;\n        }\n\n    private:\n        CHelloWorldBHO* m_parent;\n    };\n\n    // Create an instance of the handler\n    HTMLElementEventsHandler m_htmlElementEventsHandler;\n\npublic:\n    CHelloWorldBHO() : m_htmlElementEventsHandler(this) {}\n\n    BEGIN_SINK_MAP(CHelloWorldBHO)\n        SINK_ENTRY_EX(1, DIID_DWebBrowserEvents2, DISPID_DOCUMENTCOMPLETE, OnDocumentComplete)\n        SINK_ENTRY_EX(1, DIID_DWebBrowserEvents2, DISPID_BEFORENAVIGATE2, BeforeNavigate2)\n    END_SINK_MAP()\n\n    // Example implementation of event handlers\n    void STDMETHODCALLTYPE OnDocumentComplete(IDispatch* pDisp, VARIANT* URL)\n    {\n        // Your code here\n    }\n\n    void STDMETHODCALLTYPE BeforeNavigate2(IDispatch* pDisp, VARIANT* URL, VARIANT* Flags, VARIANT* TargetFrameName, VARIANT* PostData, VARIANT* Headers, VARIANT_BOOL* Cancel)\n    {\n        // Your code here\n    }\n\n    // Method to connect to HTMLElementEvents2\n    HRESULT ConnectToHTMLElementEvents(IHTMLElement* pElement)\n    {\n        CComPtr<IConnectionPointContainer> spCPC;\n        HRESULT hr = pElement->QueryInterface(IID_IConnectionPointContainer, (void**)&spCPC);\n        if (SUCCEEDED(hr))\n        {\n            CComPtr<IConnectionPoint> spCP;\n            hr = spCPC->FindConnectionPoint(DIID_HTMLElementEvents2, &spCP);\n            if (SUCCEEDED(hr))\n            {\n                hr = spCP->Advise(static_cast<IDispatch*>(&m_htmlElementEventsHandler), &m_dwCookie);\n            }\n        }\n        return hr;\n    }\n\nprivate:\n    DWORD m_dwCookie;\n};