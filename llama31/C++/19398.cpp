// Example of setting up DCOM security using CoInitializeSecurity()\nHRESULT hr = CoInitializeSecurity(\n    NULL,                           // pSecDesc\n    -1,                             // cAuthSvc\n    NULL,                           // asAuthSvc\n    NULL,                           // pReserved1\n    RPC_C_AUTHN_LEVEL_PKT_PRIVACY,  // dwAuthnLevel\n    RPC_C_IMP_LEVEL_IMPERSONATE,    // dwImpLevel\n    NULL,                           // pAuthList\n    EOAC_DYNAMIC_CLOAKING,          // dwCapabilities\n    NULL                            // pReserved3\n);\n\nif (FAILED(hr)) {\n    // Handle error\n}\n\n// ...