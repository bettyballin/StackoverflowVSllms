#include <afxwin.h>\n#include <afxsock.h>\n\nclass CMySocket : public CAsyncSocket\n{\npublic:\n    void OnConnect(int nErrorCode)\n    {\n        if (nErrorCode != 0)\n        {\n            AfxMessageBox(_T("Connection attempt failed with error: ") + std::to_wstring(nErrorCode).c_str());\n        }\n        else\n        {\n            AfxMessageBox(_T("Connected successfully"));\n        }\n    }\n};\n\nvoid TestConnectionTimeout()\n{\n    // Initialize MFC and check for errors\n    if (!AfxSocketInit())\n    {\n        AfxMessageBox(_T("Failed to initialize sockets"));\n        return;\n    }\n\n    CMySocket mySocket;\n\n    // Set a reasonable timeout for testing (e.g., 5 seconds)\n    mySocket.SetSockOpt(SO_RCVTIMEO, 5000, SOL_SOCKET);\n\n    // Attempt to connect to a non-existent port on a known server\n    if (!mySocket.Create())\n    {\n        AfxMessageBox(_T("Socket creation failed"));\n        return;\n    }\n\n    // Replace "your.server.address" with a known server address\n    // Replace 81 with a port number that is not open on the server\n    if (!mySocket.Connect(_T("your.server.address"), 81))\n    {\n        int error = GetLastError();\n        if (error != WSAEWOULDBLOCK)\n        {\n            AfxMessageBox(_T("Connection attempt failed immediately with error: ") + std::to_wstring(error).c_str());\n        }\n    }\n}