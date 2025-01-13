HRESULT extractFriendlyName( IMoniker* pMk, std::wstring& str )\n{\n  assert( pMk != 0 );\n  IPropertyBag* pBag = 0;\n  HRESULT hr = pMk->BindToStorage(0, 0, IID_IPropertyBag, (void **)&pBag );\n  if( FAILED( hr ) || pBag == 0 )\n  {\n    return hr;\n  }\n  VARIANT var;\n  var.vt = VT_BSTR;\n  hr = pBag->Read(L"FriendlyName", &var, NULL);\n  if( SUCCEEDED( hr ) && var.bstrVal != 0 )\n  {\n    str = reinterpret_cast<wchar_t*>( var.bstrVal );\n    SysFreeString(var.bstrVal);\n  }\n  pBag->Release();\n  return hr;\n}\n\n\nHRESULT enumerateDShowFilterList( const CLSID& category )\n{\n  HRESULT rval = S_OK;\n  HRESULT hr;\n  ICreateDevEnum* pCreateDevEnum = 0; // volatile, will be destroyed at the end\n  hr = ::CoCreateInstance( CLSID_SystemDeviceEnum, NULL, CLSCTX_INPROC_SERVER, IID_ICreateDevEnum, reinterpret_cast<void**>( &pCreateDevEnum ) );\n\n  assert( SUCCEEDED( hr ) && pCreateDevEnum != 0 );\n  if( FAILED( hr ) || pCreateDevEnum == 0 )\n  {\n    return hr;\n  }\n\n  IEnumMoniker* pEm = 0;\n  hr = pCreateDevEnum->CreateClassEnumerator( category, &pEm, 0 );\n\n  // If hr == S_FALSE, no error is occured. In this case pEm is NULL, because\n  // a filter does not exist e.g no video capture devives are connected to\n  // the computer or no codecs are installed.\n  assert( SUCCEEDED( hr ) && ((hr == S_OK && pEm != 0 ) || hr == S_FALSE) );\n  if( FAILED( hr ) )\n  {\n    pCreateDevEnum->Release();\n    return hr;\n  }\n\n  if( hr == S_OK && pEm != 0 ) // In this case pEm is != NULL\n  {\n    pEm->Reset();\n    ULONG cFetched;\n    IMoniker* pM = 0;\n    while( pEm->Next(1, &pM, &cFetched) == S_OK && pM != 0 )\n    {\n       std::wstring str;\n\n       if( SUCCEEDED( extractFriendlyName( pM, str ) )\n       {\n          // str contains the friendly name of the filter\n          // pM->BindToObject creates the filter\n          std::wcout << str << std::endl;\n       }\n\n       pM->Release();\n    }\n    pEm->Release();\n  }\n  pCreateDevEnum->Release();\n  return rval;\n}