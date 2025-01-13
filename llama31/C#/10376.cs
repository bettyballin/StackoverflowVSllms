[DllImport("kernel32.dll")]\nstatic extern IntPtr GetStdHandle(int nStdHandle);\n\n[DllImport("kernel32.dll")]\nstatic extern bool ReadFile(IntPtr hFile, [Out] byte[] lpBuffer, uint nNumberOfBytesToRead, out uint lpNumberOfBytesRead, IntPtr lpOverlapped);\n\nconst int STD_OUTPUT_HANDLE = -11;\n\nProcess parentProc = GetParentProc();\nif (parentProc != null)\n{\n    IntPtr outputHandle = GetStdHandle(STD_OUTPUT_HANDLE);\n    if (outputHandle != IntPtr.Zero)\n    {\n        byte[] buffer = new byte[1024];\n        uint bytesRead;\n        if (ReadFile(outputHandle, buffer, (uint)buffer.Length, out bytesRead, IntPtr.Zero))\n        {\n            string output = Encoding.UTF8.GetString(buffer, 0, (int)bytesRead);\n            // Use the output\n        }\n    }\n}