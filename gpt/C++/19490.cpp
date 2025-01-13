HRESULT hr;\n   hr = CoInitializeSecurity(\n       NULL,                        // Security descriptor    \n       -1,                          // COM negotiates authentication service\n       NULL,                        // Authentication services\n       NULL,                        // Reserved\n       RPC_C_AUTHN_LEVEL_DEFAULT,   // Default authentication level for proxies\n       RPC_C_IMP_LEVEL_IMPERSONATE, // Default Impersonation level for proxies\n       NULL,                        // Authentication info\n       EOAC_NONE,                   // Additional capabilities\n       NULL                         // Reserved\n   );\n\n   if (FAILED(hr)) {\n       // Handle the error\n   }\n\n   // Set proxy blanket\n   hr = CoSetProxyBlanket(\n       pProxy,                      // Indicates the proxy to set\n       RPC_C_AUTHN_WINNT,           // RPC_C_AUTHN_xxx\n       RPC_C_AUTHZ_NONE,            // RPC_C_AUTHZ_xxx\n       NULL,                        // Server principal name\n       RPC_C_AUTHN_LEVEL_CALL,      // RPC_C_AUTHN_LEVEL_xxx \n       RPC_C_IMP_LEVEL_IMPERSONATE, // RPC_C_IMP_LEVEL_xxx\n       NULL,                        // client identity\n       EOAC_NONE                    // proxy capabilities \n   );\n\n   if (FAILED(hr)) {\n       // Handle the error\n   }