SC_HANDLE schService = CreateService(\n    schSCManager,\n    strNameNoSpaces,\n    strServiceName,\n    SERVICE_ALL_ACCESS,\n    SERVICE_WIN32_OWN_PROCESS,\n    SERVICE_AUTO_START,\n    SERVICE_ERROR_NORMAL,\n    szPath,\n    NULL,\n    NULL,\n    NULL,\n    NULL,\n    L"NT AUTHORITY\\LocalSystem");