IWebBrowser2* pBrowser = ...;\nBSTR url = SysAllocString(L"https://example.com");\nBSTR userAgent = SysAllocString(L"Your Custom User-Agent String");\nVARIANT headers;\nheaders.vt = VT_BSTR;\nheaders.bstrVal = userAgent;\n\npBrowser->Navigate(url, &headers, NULL, NULL, NULL);\nSysFreeString(url);\nSysFreeString(userAgent);