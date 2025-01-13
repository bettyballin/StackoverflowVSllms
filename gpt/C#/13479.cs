using System;\nusing System.Diagnostics;\nusing System.Runtime.InteropServices;\n\nclass Program\n{\n    [DllImport("kernel32.dll")]\n    private static extern uint GetProcessId(IntPtr handle);\n\n    static void Main()\n    {\n        IntPtr processHandle = // your process handle here\n\n        // Get the process ID from the handle\n        uint processId = GetProcessId(processHandle);\n        \n        // Get the process using the process ID\n        Process process = Process.GetProcessById((int)processId);\n\n        Console.WriteLine($"Process ID: {process.Id}");\n        Console.WriteLine($"Process Name: {process.ProcessName}");\n    }\n}