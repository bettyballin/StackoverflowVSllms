class ATL_NO_VTABLE CErrorInfo : public CComObjectRootEx<CComSingleThreadModel>,\n                                public IDispatchImpl<IErrorInfo, &IID_IErrorInfo, &LIBID_MyErrorLib>\n{\npublic:\n    CErrorInfo();\n\n    DECLARE_REGISTRY_RESOURCEID(IDR_ERRORINFO)\n\n    BEGIN_COM_MAP(CErrorInfo)\n        COM_INTERFACE_ENTRY(IErrorInfo)\n        COM_INTERFACE_ENTRY(IDispatch)\n    END_COM_MAP()\n\n    HRESULT FinalConstruct()\n    {\n        return S_OK;\n    }\n\n    void FinalRelease() {}\n\npublic:\n    STDMETHOD(GetErrorMessage)(/* [retval][out] */ BSTR* pMessage);\n    STDMETHOD(GetErrorCode)(/* [retval][out] */ LONG* pCode);\n\nprivate:\n    CComBSTR m_bstrErrorMessage;\n    HRESULT m_hrErrorCode;\n\npublic:\n    void SetErrorMessage(LPCWSTR pszMessage) { m_bstrErrorMessage = pszMessage; }\n    void SetErrorCode(HRESULT hr) { m_hrErrorCode = hr; }\n};