#include <iostream>\n#include <Windows.h>\n\nbool AreSameInstance(IUnknown* pUnk1, IUnknown* pUnk2) {\n    if (pUnk1 == nullptr || pUnk2 == nullptr) {\n        return false;\n    }\n\n    IUnknown* pIUnknown1 = nullptr;\n    IUnknown* pIUnknown2 = nullptr;\n\n    // Query IUnknown interface on both references\n    HRESULT hr1 = pUnk1->QueryInterface(IID_IUnknown, (void**)&pIUnknown1);\n    HRESULT hr2 = pUnk2->QueryInterface(IID_IUnknown, (void**)&pIUnknown2);\n\n    // Compare the IUnknown pointers\n    bool result = (SUCCEEDED(hr1) && SUCCEEDED(hr2) && pIUnknown1 == pIUnknown2);\n\n    // Release the IUnknown interfaces\n    if (pIUnknown1) {\n        pIUnknown1->Release();\n    }\n    if (pIUnknown2) {\n        pIUnknown2->Release();\n    }\n\n    return result;\n}\n\nint main() {\n    // Example usage\n    IUnknown* pInterface1 = ...; // Obtain the first COM interface reference\n    IUnknown* pInterface2 = ...; // Obtain the second COM interface reference\n\n    bool sameInstance = AreSameInstance(pInterface1, pInterface2);\n    std::cout << "Are the two interfaces from the same instance? " << (sameInstance ? "Yes" : "No") << std::endl;\n\n    return 0;\n}