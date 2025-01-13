// Example: Setting up MFC application for interactive use (simplified)\n   INT APIENTRY wWinMain(HINSTANCE hInstance, HINSTANCE hPrevInstance, LPTSTR lpCmdLine, int nCmdShow) {\n       HMODULE hResourceModule = NULL;\n       if (!AfxWinInit(hInstance, hPrevInstance, lpCmdLine, nCmdShow))\n           return FALSE;\n\n       // Ensure it's running in an interactive session\n       if (!CheckInteractiveSession()) {\n           std::cerr << "This application must run in an interactive user session." << std::endl;\n           return -1;\n       }\n\n       CYourDialog dlg;\n       INT_PTR ptr = dlg.DoModal();\n       if (ptr == IDOK) {\n           // Handle OK\n       } else if (ptr == IDCANCEL) {\n           // Handle Cancel\n       }\n\n       return 0;\n   }