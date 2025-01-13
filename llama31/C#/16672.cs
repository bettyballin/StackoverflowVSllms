[DllImport("kernel32.dll")]\nstatic extern IntPtr GetConsoleWindow();\n\n[DllImport("user32.dll")]\nstatic extern bool ShowWindow(IntPtr hWnd, int nCmdShow);\n\nconst int SW_NORMAL = 1;\n\nstatic void Main(string[] args)\n{\n    IntPtr hWnd = GetConsoleWindow();\n    if (hWnd != IntPtr.Zero)\n    {\n        ShowWindow(hWnd, SW_NORMAL);\n    }\n    // Rest of your code...\n}