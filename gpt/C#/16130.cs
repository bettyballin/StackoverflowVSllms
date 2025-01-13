using System;\nusing System.Runtime.InteropServices;\n\nclass Program\n{\n    [StructLayout(LayoutKind.Explicit, CharSet = CharSet.Unicode)]\n    public struct INPUT_RECORD\n    {\n        [FieldOffset(0)]\n        public ushort EventType;\n        [FieldOffset(4)]\n        public KEY_EVENT_RECORD KeyEvent;\n    }\n\n    [StructLayout(LayoutKind.Sequential, CharSet = CharSet.Unicode)]\n    public struct KEY_EVENT_RECORD\n    {\n        public bool bKeyDown;\n        public ushort wRepeatCount;\n        public ushort wVirtualKeyCode;\n        public ushort wVirtualScanCode;\n        public char UnicodeChar;\n        public uint dwControlKeyState;\n    }\n\n    [DllImport("kernel32.dll", CharSet = CharSet.Auto, SetLastError = true)]\n    public static extern IntPtr GetStdHandle(int nStdHandle);\n\n    [DllImport("kernel32.dll", CharSet = CharSet.Auto, SetLastError = true)]\n    public static extern bool WriteConsoleInput(\n        IntPtr hConsoleInput,\n        [Out] INPUT_RECORD[] lpBuffer,\n        int nLength,\n        out int lpNumberOfEventsWritten);\n\n    const int STD_INPUT_HANDLE = -10;\n\n    public static void WriteConsoleInput()\n    {\n        IntPtr hConsoleInput = GetStdHandle(STD_INPUT_HANDLE);\n\n        INPUT_RECORD[] lpBuffer = new INPUT_RECORD[2];\n\n        lpBuffer[0].EventType = 0x0001; // KEY_EVENT\n        lpBuffer[0].KeyEvent.bKeyDown = true;\n        lpBuffer[0].KeyEvent.wVirtualKeyCode = 0x41; // A\n        lpBuffer[0].KeyEvent.UnicodeChar = 'A';\n        lpBuffer[0].KeyEvent.dwControlKeyState = 0;\n\n        lpBuffer[1].EventType = 0x0001; // KEY_EVENT\n        lpBuffer[1].KeyEvent.bKeyDown = true;\n        lpBuffer[1].KeyEvent.wVirtualKeyCode = 0x5A; // Z\n        lpBuffer[1].KeyEvent.UnicodeChar = 'Z';\n        lpBuffer[1].KeyEvent.dwControlKeyState = 0;\n\n        int nLength = lpBuffer.Length;\n        int lpNumberOfEventsWritten;\n        if (!WriteConsoleInput(\n            hConsoleInput,\n            lpBuffer,\n            nLength,\n            out lpNumberOfEventsWritten))\n        {\n            Console.WriteLine("Error: {0}", Marshal.GetLastWin32Error());\n        }\n    }\n\n    static void Main()\n    {\n        Console.Write("Input something: ");\n        WriteConsoleInput();\n        string input = Console.ReadLine();\n        Console.WriteLine("input = {0}", input);\n    }\n}