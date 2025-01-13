#define RETURN_ON_FAIL( expression ) \\nresult = ( expression );    \\nif ( FAILED( result ) )     \\n    return false;           \\nelse // To prevent danging else condition\n\nHRESULT result;\nCLSID clsid;\nCComPtr<IUnknown> punk = NULL;\n\nCComPtr<EnvDTE::_DTE> dte = NULL;\nRETURN_ON_FAIL( ::CLSIDFromProgID(L"VisualStudio.DTE", &clsid) );\nRETURN_ON_FAIL( ::CoCreateInstance( clsid, NULL, CLSCTX_LOCAL_SERVER, EnvDTE::IID__DTE, (LPVOID*)&punk ) );\ndte = punk;\ndte->put_UserControl( TRUE );