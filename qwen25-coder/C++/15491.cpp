#import "path_to_mstscax.dll" no_namespace\n\n#include <iostream>\n\nvoid ConnectToRemoteDesktop(BSTR server, BSTR username, BSTR domain) {\n    MsRdpClient9NonScriptable4Ptr pRdpNs(CLSID_MsTscAx);\n    MsRdpClient9AdvancedSettings5Ptr pAdvSet(pRdpNs->GetAdvancedSettings(CComBSTR(L"")));\n    MsRdpClient9Ptr pRdp(CLSID_MsTscAx);\n\n    // Ensure CredSSP is enabled\n    ((IMsRdpAdvancedSettings*)pAdvSet)->put_EnableCredSspSupport(true);\n    pRdpNs->put_NegotiateSecurityLayer(true);  // Important for NLA\n\n    // Set RDP properties (server address)\n    pRdp->put_Server(server);\n\n    if (username) {\n        pAdvSet->put_Username(username);\n    }\n    if (domain) {\n        pAdvSet->put_Domain(domain);\n    }\n\n    // Connect to the remote desktop\n    try {\n        pRdp->Connect();\n    } catch (_com_error &e) {\n        std::wcerr << "Failed to connect: " << e.ErrorMessage() << std::endl;\n    }\n}\n\nint main() {\n    ConnectToRemoteDesktop(CComBSTR(L"remotehost"), CComBSTR(L"user"), CComBSTR(L"domain"));\n    return 0;\n}