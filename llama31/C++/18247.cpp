#include <Windows.h>\n#include <Security.h>\n\nint main() {\n    HANDLE hToken;\n    BOOL bResult;\n\n    // Attempt to log on the user.\n    bResult = LogonUser(\n        L"username",  // Username of the account to log on.\n        L".",         // Domain name or server name. "." for local account.\n        L"password",  // Password of the account to log on.\n        LOGON_TYPE_NEW_CREDENTIALS,  // Logon type.\n        LOGON32_PROVIDER_DEFAULT,    // Logon provider.\n        &hToken                     // Handle to the user's token.\n    );\n\n    if (!bResult) {\n        // Handle the error.\n        return 1;\n    }\n\n    // Impersonate the logged-on user.\n    bResult = ImpersonateLoggedOnUser(hToken);\n    if (!bResult) {\n        // Handle the error.\n        CloseHandle(hToken);\n        return 1;\n    }\n\n    // Now you are impersonating the user.\n\n    // Clean up.\n    RevertToSelf();\n    CloseHandle(hToken);\n\n    return 0;\n}