using System;\nusing System.Runtime.InteropServices;\nusing System.Timers;\n\nclass Program\n{\n    [DllImport("user32.dll")]\n    static extern bool GetLastInputInfo(ref LASTINPUTINFO plii);\n\n    [StructLayout(LayoutKind.Sequential)]\n    struct LASTINPUTINFO\n    {\n        public uint cbSize;\n        public uint dwTime;\n    }\n\n    static void Main(string[] args)\n    {\n        Timer timer = new Timer(5000); // Check every 5 seconds\n        timer.Elapsed += CheckUserActivity;\n        timer.Start();\n\n        Console.WriteLine("Monitoring user activity. Press Enter to exit.");\n        Console.ReadLine();\n    }\n\n    static void CheckUserActivity(Object source, ElapsedEventArgs e)\n    {\n        LASTINPUTINFO lastInputInfo = new LASTINPUTINFO();\n        lastInputInfo.cbSize = (uint)Marshal.SizeOf(lastInputInfo);\n\n        if (GetLastInputInfo(ref lastInputInfo))\n        {\n            uint idleTime = (uint)Environment.TickCount - lastInputInfo.dwTime;\n            uint idleSeconds = idleTime / 1000;\n\n            if (idleSeconds > 300) // User inactive for more than 5 minutes\n            {\n                Console.WriteLine("User is idle for more than 5 minutes.");\n                // Here you can set the user's status to "Not Available"\n            }\n            else\n            {\n                Console.WriteLine("User is active.");\n                // Here you can set the user's status to "Available"\n            }\n        }\n    }\n}