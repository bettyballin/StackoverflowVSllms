Public Const SW_SHOW = 5\nPublic Const SW_HIDE = 0\n\nSub ShowAndActivateWindow(ByVal windowHandle As IntPtr)\n    ' Show the window\n    ShowWindow(windowHandle, SW_SHOW)\n    \n    ' Set the window as the foreground window\n    SetForegroundWindow(windowHandle)\nEnd Sub