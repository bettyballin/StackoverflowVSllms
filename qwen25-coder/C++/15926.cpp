IClassFactory* pFactory = nullptr;\n  HRESULT hr = CoGetClassObject(clsid, CLSCTX_INPROC_SERVER, nullptr, IID_PPV_ARGS(&pFactory));\n  if (SUCCEEDED(hr)) {\n      hr = pFactory->CreateInstance(NULL, IID_PPV_ARGS(&pInterface));\n      pFactory->Release();\n  }