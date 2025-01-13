#include <atlbase.h>\n#include <exdisp.h>\n\nHRESULT IsContainerOrAncestorInternetExplorer(IOleClientSite* pClientSite, BOOL& bIsIE) {\n    if (!pClientSite) return E_POINTER;\n    bIsIE = FALSE;\n\n    // Start with the immediate container.\n    CComPtr<IOleContainer> spContainer;\n    HRESULT hr = pClientSite->GetContainer(&spContainer);\n    if (FAILED(hr)) return hr;\n\n    // Iterate through potential ancestors.\n    CComPtr<IUnknown> spCurrentContainer(spContainer);\n    while (spCurrentContainer) {\n        // Check if the current container implements IHTMLDocument or related interfaces.\n        if (SUCCEEDED(spCurrentContainer->QueryInterface(IID_IHTMLDocument2, nullptr))) {\n            bIsIE = TRUE;\n            break;\n        }\n\n        // Move to the parent container.\n        CComPtr<IOleClientSite> spParentSite;\n        hr = spCurrentContainer->QueryInterface(IID_IOleClientSite, (void**)&spParentSite);\n        if (FAILED(hr)) break;\n\n        CComPtr<IOleContainer> spParentContainer;\n        if (SUCCEEDED(spParentSite->GetContainer(&spParentContainer))) {\n            spCurrentContainer.Swap(spParentContainer);\n        } else {\n            // No more containers to check.\n            break;\n        }\n    }\n\n    return S_OK;\n}