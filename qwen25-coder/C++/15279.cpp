typedef void (*MyFunction)();\nMyFunction pFunc = nullptr;\n\nvoid InitializeFunctions() {\n    pFunc = reinterpret_cast<MyFunction>(GetProcAddress(GetModuleHandle("YourDll.dll"), "InternalFunctionName"));\n}\n\nvoid CallInternalFunction() {\n    if (pFunc) {\n        pFunc();\n    }\n}