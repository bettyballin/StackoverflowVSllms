DWORD dwCookie = (DWORD)lpParameter;\nIUnknown* pInterface;\nhr = pGIT->GetInterfaceFromGlobal(dwCookie, IID_IUnknown, (void**)&pInterface);\nif (FAILED(hr)) { /* handle error */ }