#include <atlbase.h>\n#include <comdef.h>\n\n// Include generated tlh file for the C# interface\n#import "path_to_your_tlb_file.tlb" no_namespace\n\nclass ATL_NO_VTABLE MyCallback : public ICallback {\npublic:\n    STDMETHODIMP OnCallback() override {\n        // Callback implementation\n        OutputDebugString(L"OnCallback called from C#!");\n        return S_OK;\n    }\n};\n\nvoid CallManagedCode() {\n    CComPtr<ICallback> callback = new MyCallback();\n    CComPtr<ISomeClass> managedObject;\n    \n    HRESULT hr = managedObject.CoCreateInstance(CLSID_SomeClass);\n    if (SUCCEEDED(hr)) {\n        managedObject->SetCallback(callback);\n        managedObject->DoWork();\n    }\n}