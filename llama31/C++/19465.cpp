[uuid(your-uuid-here)]\ninterface IMyInterface : IUnknown\n{\n    HRESULT Method1([out, retval] BSTR* result);\n    HRESULT Method2([in] BSTR input_str, [out, retval] BSTR* result);\n}