class CNumberFactory : public INumberFactory\n{\npublic:\n    STDMETHODIMP GetNumber(BSTR numberName, INumber** ppNumber)\n    {\n        if (numberName == L"One")\n        {\n            CComObject<COne>* pOne = new CComObject<COne>();\n            pOne->AddRef();\n            *ppNumber = pOne;\n            return S_OK;\n        }\n        return E_FAIL;\n    }\n};