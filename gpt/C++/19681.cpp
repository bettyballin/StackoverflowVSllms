class Outer : public IUnknown {\n    Inner* m_inner;\npublic:\n    Outer() {\n        m_inner = new Inner();\n    }\n    virtual HRESULT STDMETHODCALLTYPE QueryInterface(REFIID riid, void** ppvObject) override {\n        // Forward specific interfaces to the inner object\n        if (riid == IID_IKnownInterface) {\n            return m_inner->QueryInterface(riid, ppvObject);\n        }\n        // Handle other interfaces\n        // ...\n        return E_NOINTERFACE;\n    }\n    virtual ULONG STDMETHODCALLTYPE AddRef() override {\n        return m_inner->AddRef();\n    }\n    virtual ULONG STDMETHODCALLTYPE Release() override {\n        return m_inner->Release();\n    }\n    // Other methods\n    // ...\n};\n\nclass Inner : public IUnknown {\npublic:\n    virtual HRESULT STDMETHODCALLTYPE QueryInterface(REFIID riid, void** ppvObject) override {\n        // Handle interface requests\n        // ...\n        return E_NOINTERFACE;\n    }\n    virtual ULONG STDMETHODCALLTYPE AddRef() override {\n        // Implement reference counting\n        // ...\n        return 1;\n    }\n    virtual ULONG STDMETHODCALLTYPE Release() override {\n        // Implement reference counting\n        // ...\n        return 1;\n    }\n    // Other methods\n    // ...\n};