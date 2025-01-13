using System;\nusing System.Threading;\nusing System.Windows.Forms;\n\nnamespace YourNamespace\n{\n    static class Program\n    {\n        [STAThread]\n        static void Main(string[] args)\n        {\n            // Allocate console for output if not already allocated\n            bool hasConsole = AttachConsole(-1);\n            if (!hasConsole)\n                AllocConsole();\n\n            foreach (string s in args) {\n                System.Windows.Forms.MessageBox.Show(s);\n                Console.WriteLine("String: " + s);\n            }\n\n            Mutex appSingleton = new System.Threading.Mutex(false, "WinSyncSingalInstanceMutx");\n            if (appSingleton.WaitOne(0, false)) {\n                try {\n                    Application.EnableVisualStyles();\n                    Application.SetCompatibleTextRenderingDefault(false);\n\n                    //start logger\n                    Logger.singleton.makeOpen(true);\n                    Application.Run(new MainForm(false));\n                } catch (Exception) {\n                } finally {\n                    appSingleton.Close(); \n                    Logger.singleton.makeOpen(false); \n                }\n            } else {\n                System.Windows.Forms.MessageBox.Show("Sorry, only one instance of WinSync can be ran at once.");\n            }\n\n            // Free the console if it was allocated\n            if (!hasConsole)\n                FreeConsole();\n        }\n\n        [System.Runtime.InteropServices.DllImport("kernel32.dll", SetLastError = true)]\n        private static extern bool AllocConsole();\n\n        [System.Runtime.InteropServices.DllImport("kernel32.dll")]\n        private static extern bool AttachConsole(int dwProcessId);\n\n        [System.Runtime.InteropServices.DllImport("kernel32.dll", SetLastError=true, ExactSpelling=true)]\n        private static extern bool FreeConsole();\n    }\n}