#include <atlbase.h>\n\nvoid update( HRESULT (IDispatch::*com_uint_getter)(UINT*), IDispatch* pDispatch, UINT& u )\n{\n    UINT tmp;\n    if ( S_OK == (pDispatch->*com_uint_getter)( &tmp ) ) {\n        u = tmp;\n    }\n}\n\nint main(int, char*[])\n{\n    CComPtr< IDispatch > ptr;\n    UINT u;\n    update( &IDispatch::GetTypeInfoCount, ptr, u );\n    return 0;\n}