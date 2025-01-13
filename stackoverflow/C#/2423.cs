[DllImport("user32.dll")]\npublic static extern int SendMessage(IntPtr hWnd, Int32 wMsg, bool wParam, Int32 lParam);\n\nprivate const int WM_SETREDRAW = 11; \n\npublic static void SuspendDrawing(Control target)\n{\n    SendMessage(target.Handle, WM_SETREDRAW, false, 0);\n}\n\npublic static void ResumeDrawing(Control target)\n{\n    SendMessage(target.Handle, WM_SETREDRAW, true, 0);\n    target.Refresh();\n}