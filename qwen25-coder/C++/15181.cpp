#include <comdef.h>\n#include <objbase.h>\n\n// Assume this is your event sink interface ID that matches what you're looking for.\nconst IID IID_TheOneYouAreLookingFor = { /* put the correct GUID here */ };\n\nclass CEventSink : public IUnknown \n{\nprivate:\n    ULONG m_cRef;\npublic:\n    // Constructor\n    CEventSink() : m_cRef(1) {}\n\n    // HRESULT methods...\n    STDMETHODIMP QueryInterface(REFIID riid, void** ppv)\n    {\n        if (riid == IID_IUnknown || riid == IID_TheOneYouAreLookingFor)\n            *ppv = static_cast<IUnknown*>(this);\n        else \n            return E_NOINTERFACE;\n\n        AddRef();\n        return S_OK;\n    }\n\n    STDMETHODIMP_(ULONG) AddRef()\n    {\n        return InterlockedIncrement(&m_cRef);\n    }\n\n    STDMETHODIMP_(ULONG) Release()\n    {\n        ULONG result = InterlockedDecrement(&m_cRef);\n        if (result == 0)\n            delete this;\n\n        return result;\n    }\n\n    // Event handler(s)... implement this following the event signature from your control.\n    HRESULT STDMETHODCALLTYPE OnReadyStateChange(long state);\n};\n\nHRESULT ConnectEvents(IUnknown* pUnkControl, CEventSink** ppSink)\n{\n    *ppSink = new CEventSink();\n    IConnectionPointContainer* pCPC;\n    HRESULT hr = pUnkControl->QueryInterface(IID_IConnectionPointContainer, (void**)&pCPC);\n    if (SUCCEEDED(hr))\n    {\n        IConnectionPoint* pCP;\n        hr = pCPC->FindConnectionPoint(IID_TheOneYouAreLookingFor, &pCP);\n        pCPC->Release();\n        if (SUCCEEDED(hr)) \n        {\n            DWORD dwCookie;\n            hr = pCP->Advise(*ppSink, &dwCookie);\n            pCP->Release();\n            return hr; // Now listening for events.\n        }\n    }\n\n    return E_FAIL;\n}\n\nHRESULT DisconnectEvents(IConnectionPoint* pCP, DWORD dwCookie, CEventSink* pSink)\n{\n    HRESULT hr = pCP->Unadvise(dwCookie);\n    if (SUCCEEDED(hr))\n        delete pSink;\n\n    return hr;\n}