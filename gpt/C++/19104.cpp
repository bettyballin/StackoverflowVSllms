// COM Interface Definition\ninterface IMyInterface : IUnknown {\n    virtual HRESULT __stdcall MyMethod() = 0;\n};\n\n// COM Class Implementation\nclass MyClass : public IMyInterface {\npublic:\n    MyClass() : refCount(0) {}\n    virtual ~MyClass() {}\n\n    // IUnknown methods\n    HRESULT __stdcall QueryInterface(REFIID riid, void** ppv) {\n        if (riid == IID_IUnknown || riid == __uuidof(IMyInterface)) {\n            *ppv = static_cast<IMyInterface*>(this);\n            AddRef();\n            return S_OK;\n        }\n        *ppv = nullptr;\n        return E_NOINTERFACE;\n    }\n\n    ULONG __stdcall AddRef() {\n        return InterlockedIncrement(&refCount);\n    }\n\n    ULONG __stdcall Release() {\n        ULONG count = InterlockedDecrement(&refCount);\n        if (count == 0) {\n            delete this;\n        }\n        return count;\n    }\n\n    // IMyInterface method\n    HRESULT __stdcall MyMethod() {\n        // Method implementation\n        return S_OK;\n    }\n\nprivate:\n    ULONG refCount;\n};