DECLARE\n  hwnd NUMBER;\nBEGIN\n  -- Get the handle of the Word window\n  hwnd := CLIENT_OLE2.GET_WINDOW_HANDLE(MY_APPLICATION);\n\n  -- Bring the Word window to the front\n  CLIENT_OLE2.SET_FOREGROUND_WINDOW(hwnd);\nEND;