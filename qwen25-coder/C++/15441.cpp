// Used by Foo method, so appears in the type library\ntypedef enum FOO\n{\n    FOO_1,\n    FOO_2,\n} FOO;\n\n// Not used by any method, but now will appear in the type library due to IndirectUsage method\ntypedef enum BAR\n{\n    BAR_1,\n    BAR_2,\n} BAR;\n\n[id(1)] HRESULT Foo([in] FOO eFoo);\n\n// Dummy method to reference BAR and ensure it appears in the type library\n[id(999)] HRESULT IndirectUsage([out, retval] BAR* pBar);