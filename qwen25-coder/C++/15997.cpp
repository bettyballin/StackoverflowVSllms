#include <windows.h>\n#include <comutil.h> // For _bstr_t\n\nint main() {\n    const char* pemRequest = \n        "-----BEGIN NEW CERTIFICATE REQUEST-----\n"\n        "MIIBTjCBuAIBADARMQ8wDQYDVQQDEwZ3dTAwMzEwgZ0wDQYJKoZIhvcNAQEBBQAD\n"\n        "gYsAMIGHAoGBAKP48eljetv3fVicT6g6hKjmLpsySJaZ/NnepEJEqtQQNbwsluhW\n"\n        "yWxhHWzPoNPV9uqjZBW7EnqYjxyPp1A0vOK35uxmmcNrgmuSjO1WBkD0YVZwzh2u\n"\n        "OovRCOwJKklQtJnQWoM+yT8CyBVk7raVJOrLDMC8FR5AMknVCIlt7HppAgEDoAAw\n"\n        "DQYJKoZIhvcNAQEFBQADgYEAAK5G10e39GxiNiPXdrOAwtuIiLd1UTWn3VYY7nYY\n"\n        "74LhydUBjo0Xi6HBTTNVlPNoRB9GOe5P1Qgq0EJ6gLIriFY+Gxdl2Y4lSo7FmpxB\n"\n        "+87bRCLpC3mxQltNm97ZysmS4I4diYhPDSS/2acKeH2cBgAtQVG9KsuZ41qxUQ10\n"\n        "EY8=\n"\n        "-----END NEW CERTIFICATE REQUEST-----";\n\n    // Convert ASCII string to BSTR\n    _bstr_t bstrRequest = pemRequest;\n\n    // Now you can use bstrRequest in ICertRequest2::Submit\n\n    return 0;\n}