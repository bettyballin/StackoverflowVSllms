using System;\nusing System.Runtime.InteropServices;\nusing Microsoft.Office.Interop.Excel;\n\nnamespace VSTOAddIn\n{\n    public partial class ThisAddIn\n    {\n        [DllImport("user32.dll")]\n        private static extern IntPtr GetForegroundWindow();\n\n        [DllImport("user32.dll", SetLastError = true)]\n        [return: MarshalAs(UnmanagedType.Bool)]\n        private static extern bool IsIconic(IntPtr hWnd);\n\n        private void CheckIfExcelIsTopmost()\n        {\n            IntPtr foregroundHwnd = GetForegroundWindow();\n            if (foregroundHwnd != IntPtr.Zero)\n            {\n                // Get the HWND of Excel's main application window\n                IntPtr excelMainWindowHwnd = new IntPtr(Globals.ThisAddIn.Application.Hwnd);\n                \n                if (foregroundHwnd == excelMainWindowHwnd && !IsIconic(foregroundHwnd))\n                {\n                    System.Windows.Forms.MessageBox.Show("Excel is active and in focus.");\n                }\n                else\n                {\n                    System.Windows.Forms.MessageBox.Show("Excel is not in focus or minimized.");\n                }\n            }\n        }\n    }\n}