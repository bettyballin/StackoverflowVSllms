int WINAPI WinMain(HINSTANCE hinstance, HINSTANCE hprevinstance, LPSTR lpcmdline, int nshowcmd)\n{\n    bool quit = false;\n    MSG msg;\n\n    createWindow(hinstance, SCRW, SCRH, SCRD, WINDOWED);\n\n    // Main loop\n    while (!quit)\n    {       \n        if (PeekMessage(&msg, NULL, NULL, NULL, PM_REMOVE))\n        {\n            if (msg.message == WM_QUIT)\n                quit = true;\n\n            TranslateMessage(&msg);\n            DispatchMessage(&msg);\n        }\n\n        // Check for continuous key press\n        if (GetAsyncKeyState(VK_RIGHT) & 0x8000) \n        {\n            key_RIGHT();\n        }\n\n        renderFrame();        // processes graphics\n        SwapBuffers(hdc);\n    }\n    return msg.lParam;\n}