HRESULT CMyInterface::DispatchError(CErrorInfo* pCustomError, LPCTSTR pszMethodName, REFIID riid)\n{\n    _com_error err(pCustomError->SetErrorCode());\n    err.ErrorMessage() = (LPCWSTR)pCustomError->GetErrorMessage();\n    return Error(err.ErrorDescription().c_str(), riid, err.m_hr);\n}