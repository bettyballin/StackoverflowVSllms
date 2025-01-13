using System;\nusing System.Runtime.InteropServices;\n\nclass Program\n{\n    [DllImport("kernel32")]\n    static extern bool GenerateConsoleCtrlEvent(uint dwCtrlEvent, uint dwProcessGroupId);\n\n    const uint CTRL_C_EVENT = 0;\n\n    ProcessStartInfo info = new ProcessStartInfo(exe, args);\n    info.RedirectStandardError = true;\n    info.RedirectStandardInput = true;\n    info.RedirectStandardOutput = true;\n    info.UseShellExecute = false;\n    Process p = Process.Start(info);\n\n    p.StandardInput.AutoFlush = true;\n    p.StandardInput.WriteLine(scriptcode);\n\n    uint processGroupId = (uint)p.Id;\n    GenerateConsoleCtrlEvent(CTRL_C_EVENT, processGroupId);\n\n    string error = p.StandardError.ReadToEnd();\n    if (!String.IsNullOrEmpty(error))\n    {\n        throw new Exception(error);\n    }\n    string output = p.StandardOutput.ReadToEnd();\n}