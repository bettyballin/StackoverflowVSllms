STDMETHODIMP CErrorInfo::GetErrorMessage(/* [retval][out] */ BSTR* pMessage)\n{\n    if (!pMessage) return E_POINTER;\n    *pMessage = m_bstrErrorMessage.Copy();\n    return (*pMessage) ? S_OK : E_OUTOFMEMORY;\n}\n\nSTDMETHODIMP CErrorInfo::GetErrorCode(/* [retval][out] */ LONG* pCode)\n{\n    if (!pCode) return E_POINTER;\n    *pCode = (LONG)m_hrErrorCode;\n    return S_OK;\n}