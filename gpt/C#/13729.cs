using Microsoft.Win32;\nusing System;\nusing System.Runtime.InteropServices;\n\npublic class EnvironmentVariableUpdater\n{\n    [DllImport("kernel32.dll", SetLastError = true)]\n    private static extern bool SendMessageTimeout(\n        IntPtr hWnd, uint Msg, IntPtr wParam, IntPtr lParam,\n        uint fuFlags, uint uTimeout, out IntPtr lpdwResult);\n\n    private const int HWND_BROADCAST = 0xffff;\n    private const int WM_SETTINGCHANGE = 0x001A;\n    private const int SMTO_ABORTIFHUNG = 0x0002;\n    \n    public static void SetEnvironmentVariable()\n    {\n        try\n        {\n            using (RegistryKey reg = Registry.LocalMachine.OpenSubKey(@"SYSTEM\CurrentControlSet\Control\Session Manager\Environment", true))\n            {\n                if (reg != null)\n                {\n                    reg.SetValue("MYVAR", "SomeVal", RegistryValueKind.ExpandString);\n                }\n                else\n                {\n                    Console.WriteLine("Failed to open registry key.");\n                }\n            }\n\n            // Notify the system about the change\n            IntPtr result;\n            SendMessageTimeout(\n                (IntPtr)HWND_BROADCAST, WM_SETTINGCHANGE, IntPtr.Zero,\n                Marshal.StringToHGlobalUni("Environment"), \n                SMTO_ABORTIFHUNG, 100, out result);\n        }\n        catch (UnauthorizedAccessException ex)\n        {\n            Console.WriteLine("Access denied. Please run the application with administrative privileges.");\n            Console.WriteLine(ex.Message);\n        }\n        catch (Exception ex)\n        {\n            Console.WriteLine("An error occurred while setting the environment variable:");\n            Console.WriteLine(ex.Message);\n        }\n    }\n}