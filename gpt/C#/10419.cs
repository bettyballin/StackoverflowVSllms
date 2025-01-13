using System;\nusing System.Runtime.InteropServices;\n\nclass PrinterInstaller\n{\n    [DllImport("printui.dll", SetLastError = true, CharSet = CharSet.Auto)]\n    public static extern int PrintUIEntry(IntPtr hwnd, IntPtr hinst, string lpszCmdLine, int nCmdShow);\n\n    public static void InstallPrinter(string infPath)\n    {\n        string command = $"/if /b \"Virtual Printer\" /f \"{infPath}\" /r \"FILE:\" /m \"Generic / Text Only\"";\n        int result = PrintUIEntry(IntPtr.Zero, IntPtr.Zero, command, 0);\n        if (result != 0)\n        {\n            throw new ApplicationException("Printer installation failed.");\n        }\n    }\n\n    static void Main(string[] args)\n    {\n        try\n        {\n            InstallPrinter(@"C:\path\to\your\printer.inf");\n            Console.WriteLine("Printer installed successfully.");\n        }\n        catch (Exception ex)\n        {\n            Console.WriteLine($"Error: {ex.Message}");\n        }\n    }\n}