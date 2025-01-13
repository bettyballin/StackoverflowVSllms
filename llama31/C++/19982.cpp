// assuming pDispatch is a pointer to the IDispatch interface\nDISPID dispid;\nHRESULT hr = pDispatch->GetIDsOfNames(\n    IID_NULL, \n    &L"MethodName", \n    1, \n    LOCALE_USER_DEFAULT, \n    &dispid\n);\n\nif (SUCCEEDED(hr)) {\n    VARIANTARG* args = NULL;\n    EXCEPINFO* excepInfo = NULL;\n    hr = pDispatch->Invoke(\n        dispid, \n        IID_NULL, \n        LOCALE_USER_DEFAULT, \n        DISPATCH_METHOD, \n        &args, \n        NULL, \n        NULL, \n        NULL\n    );\n}