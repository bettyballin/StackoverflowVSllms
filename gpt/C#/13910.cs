using System;\nusing System.IO;\nusing System.Runtime.InteropServices;\nusing System.Text;\n\nclass Program\n{\n    const uint GENERIC_READ = 0x80000000;\n    const uint FILE_SHARE_READ = 0x00000001;\n    const uint FILE_SHARE_WRITE = 0x00000002;\n    const uint OPEN_EXISTING = 3;\n\n    [DllImport("kernel32.dll", SetLastError = true, CharSet = CharSet.Auto)]\n    static extern IntPtr CreateFile(\n        string lpFileName,\n        uint dwDesiredAccess,\n        uint dwShareMode,\n        IntPtr lpSecurityAttributes,\n        uint dwCreationDisposition,\n        uint dwFlagsAndAttributes,\n        IntPtr hTemplateFile);\n\n    [DllImport("kernel32.dll", SetLastError = true)]\n    [return: MarshalAs(UnmanagedType.Bool)]\n    static extern bool CloseHandle(IntPtr hObject);\n\n    static void Main()\n    {\n        string filePath = "path_to_your_utf8_file.txt";\n        IntPtr handle = CreateFile(filePath, GENERIC_READ, FILE_SHARE_READ | FILE_SHARE_WRITE, IntPtr.Zero, OPEN_EXISTING, 0, IntPtr.Zero);\n\n        if (handle.ToInt64() != -1)\n        {\n            using (FileStream fs = new FileStream(handle, FileAccess.Read))\n            using (StreamReader reader = new StreamReader(fs, Encoding.UTF8))\n            {\n                string content = reader.ReadToEnd();\n                Console.WriteLine(content);\n            }\n            \n            CloseHandle(handle);\n        }\n        else\n        {\n            Console.WriteLine("Error: Unable to open file.");\n        }\n    }\n}