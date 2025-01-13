#include <windows.h>\n\nSERVICE_STATUS_HANDLE g_hSvcStatusHandle;\nSERVICE_STATUS        g_svcStatus;\n\nVOID WINAPI SvcCtrlHandler(DWORD dwCtrl)\n{\n    switch (dwCtrl) \n    {\n        case SERVICE_CONTROL_STOP:\n            // Do cleanup here.\n            \n            g_svcStatus.dwCurrentState = SERVICE_STOP_PENDING;\n            SetServiceStatus(g_hSvcStatusHandle, &g_svcStatus);\n\n            // Signal the main thread to exit\n            SetEvent(g_hevStop);\n            break;\n\n        default:\n            break;\n    }\n}\n\nVOID WINAPI SvcMain(DWORD argc, LPTSTR *argv)\n{\n    g_hSvcStatusHandle = RegisterServiceCtrlHandler(\n                                TEXT(SERVICE_NAME), \n                                SvcCtrlHandler);\n\n    if (!g_hSvcStatusHandle) return;\n\n    // Initialize service status\n    g_svcStatus.dwServiceType = SERVICE_WIN32_OWN_PROCESS; \n    g_svcStatus.dwControlsAccepted = SERVICE_ACCEPT_STOP;\n    g_svcStatus.dwCurrentState = SERVICE_RUNNING;\n    g_svcStatus.dwWin32ExitCode = 0;\n    g_svcStatus.dwServiceSpecificExitCode = 0;\n    g_svcStatus.dwCheckPoint = 0;\n\n    SetServiceStatus(g_hSvcStatusHandle, &g_svcStatus);\n\n    // Main service loop\n    while (WaitForSingleObject(g_hevStop, INFINITE) != WAIT_OBJECT_0)\n    {\n        // Service work here...\n    }\n\n    // Cleanup code...\n\n    g_svcStatus.dwCurrentState = SERVICE_STOPPED;\n    SetServiceStatus(g_hSvcStatusHandle, &g_svcStatus);\n}\n\nint main()\n{\n    SERVICE_TABLE_ENTRY dispatchTable[] =\n    {\n        { TEXT(SERVICE_NAME), (LPSERVICE_MAIN_FUNCTION) SvcMain },\n        { NULL, NULL}\n    };\n\n    if (!StartServiceCtrlDispatcher(dispatchTable))\n        return GetLastError();\n\n    return 0;\n}