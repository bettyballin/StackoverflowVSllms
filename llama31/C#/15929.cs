using System;\nusing System.Runtime.InteropServices;\n\npublic class ConsoleOutputCapture\n{\n    [DllImport("kernel32.dll")]\n    static extern bool AttachConsole(uint dwProcessId);\n\n    [DllImport("kernel32.dll")]\n    static extern bool ReadConsoleOutput(IntPtr hConsoleOutput, [Out] char[] lpBuffer, uint nBufferSize, out uint lpNumberOfCharsRead, IntPtr lpReadRegion);\n\n    public static void CaptureConsoleOutput(uint processId)\n    {\n        if (AttachConsole(processId))\n        {\n            var buffer = new char[1024];\n            uint bytesRead;\n            var handle = GetStdHandle(STD_OUTPUT_HANDLE);\n            while (ReadConsoleOutput(handle, buffer, (uint)buffer.Length, out bytesRead, IntPtr.Zero))\n            {\n                var output = new string(buffer, 0, (int)bytesRead);\n                // Do something with the captured output...\n                File.AppendAllText("console_output.log", output);\n            }\n        }\n    }\n\n    const uint STD_OUTPUT_HANDLE = 0xFFFFFFF5;\n    [DllImport("kernel32.dll")]\n    static extern IntPtr GetStdHandle(uint nStdHandle);\n}