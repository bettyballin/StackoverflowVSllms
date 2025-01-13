// C++ COM add-in\n#import "MyCSharpLibrary.tlb"\n\nclass MyCallback : public ICallback\n{\npublic:\n    HRESULT __stdcall MyMethod()\n    {\n        // implementation\n    }\n};\n\nint main()\n{\n    // Create an instance of the C# class\n    CLSID clsid;\n    HRESULT hr = CLSIDFromString(L"MyCSharpLibrary.MyCSharpClass", &clsid);\n    if (SUCCEEDED(hr))\n    {\n        IDispatch* pDispatch;\n        hr = CoCreateInstance(clsid, NULL, CLSCTX_INPROC_SERVER, IID_PPV_ARGS(&pDispatch));\n        if (SUCCEEDED(hr))\n        {\n            // Get a pointer to the callback interface\n            MyCallback* pCallback = new MyCallback();\n            ICallback* pICallback;\n            hr = pCallback->QueryInterface(IID_PPV_ARGS(&pICallback));\n            if (SUCCEEDED(hr))\n            {\n                // Pass the callback interface pointer to the C# library\n                VARIANT var;\n                var.vt = VT_DISPATCH;\n                var.pdispVal = pICallback;\n                hr = pDispatch->Invoke(DISPID_DOSOMETHING, IID_NULL, LOCALE_USER_DEFAULT, DISPATCH_METHOD, &var, NULL, NULL, NULL);\n                if (SUCCEEDED(hr))\n                {\n                    // Do something\n                }\n            }\n        }\n    }\n    return 0;\n}