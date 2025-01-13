if (((newVal.vt & VT_ARRAY) == VT_ARRAY) && ((newVal.vt & VT_BSTR) == VT_BSTR))\n{\n    SAFEARRAY* paArray = newVal.parray;\n    BSTR * str = NULL;\n    SafeArrayAccessData(paArray, (void**)&str);\n\n    long lLBound = 0;\n    long lUBound = 0;\n    long nCount = 0;\n\n    if (FAILED(SafeArrayGetLBound(paArray, 1, &lLBound)) ||\n        FAILED(SafeArrayGetUBound(paArray, 1, &lUBound)))\n    {\n        ASSERT(false);\n        return FALSE;\n    }\n\n    nCount = (lUBound - lLBound + 1);\n    for (int i = 0; i < nCount; i++)\n    {\n        m_cstrList.AddString(W2T(str[i]));\n        SysFreeString(str[i]); // Release the BSTR pointer\n    }\n\n    SafeArrayUnaccessData(paArray);\n}