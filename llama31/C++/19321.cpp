HWND hWnd = FindWindow(NULL, "Your Window Title"); // Find the window you want to send the message to\nif (hWnd != NULL) {\n    SendMessage(hWnd, WM_QUERYENDSESSION, 0, ENDSESSION_CLOSEAPP);\n}