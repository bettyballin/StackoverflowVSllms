HRESULT hr;\nISomeInterface* pInterface = nullptr;\n\nhr = CoCreateInstance(CLSID_SomeComponent, \n                      nullptr, \n                      CLSCTX_INPROC_SERVER, \n                      IID_ISomeInterface, \n                      (void**)&pInterface);\n\nif (SUCCEEDED(hr)) {\n    // pInterface is already AddRef'd, use the interface...\n}\n\n// Remember to release it when done\nif (pInterface) {\n    pInterface->Release();\n}