using System.Runtime.InteropServices;\n\nstatic class Program\n{\n    [STAThread]\n    static void Main(string[] args)\n    {\n        bool consoleMode = Boolean.Parse(args[0]);\n\n        if (consoleMode)\n        {\n            AllocConsole();\n            Console.WriteLine("consolemode started");\n            // ...\n        }\n        else\n        {\n            Application.EnableVisualStyles();\n            Application.SetCompatibleTextRenderingDefault(false);\n            Application.Run(new Form1());\n        }\n    }\n\n    [DllImport("kernel32.dll")]\n    static extern bool AllocConsole();\n}