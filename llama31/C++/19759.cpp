// Define the callback function\nvoid CALLBACK RapiInitCallback(DWORD dwEvent, DWORD dwParam)\n{\n    switch (dwEvent)\n    {\n    case RAPI_INIT_EVENT_SUCCESS:\n        // Initialization complete, close the dialog\n        EndDialog(hDlg, TRUE);\n        break;\n    case RAPI_INIT_EVENT_FAILED:\n        // Initialization failed, display an error message\n        MessageBox(hDlg, "Connection failed", "Error", MB_ICONERROR);\n        break;\n    case RAPI_INIT_EVENT_CANCELLED:\n        // User cancelled the operation, close the dialog\n        EndDialog(hDlg, FALSE);\n        break;\n    }\n}\n\n// Define the dialog procedure\nINT_PTR CALLBACK ConnectingDlgProc(HWND hDlg, UINT uMsg, WPARAM wParam, LPARAM lParam)\n{\n    switch (uMsg)\n    {\n    case WM_INITDIALOG:\n        // Initialize the RAPI connection\n        CeRapiInitEx(RapiInitCallback, NULL, 0);\n        return TRUE;\n    case WM_COMMAND:\n        if (LOWORD(wParam) == IDCANCEL)\n        {\n            // User clicked the cancel button, cancel the RAPI initialization\n            CeRapiUninit();\n            EndDialog(hDlg, FALSE);\n        }\n        break;\n    }\n    return FALSE;\n}