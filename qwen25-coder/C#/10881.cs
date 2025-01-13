using System;\nusing System.Diagnostics;\n\nclass Logger\n{\n    public void Log(string message)\n    {\n        if (IsRunningInConsole())\n        {\n            Console.WriteLine(message);\n        }\n        else\n        {\n            // Log to Windows Event Viewer\n            using (EventLog eventLog = new EventLog("Application"))\n            {\n                eventLog.Source = "MyApp";\n                eventLog.WriteEntry(message, EventLogEntryType.Information);\n            }\n        }\n    }\n\n    private bool IsRunningInConsole()\n    {\n        bool isWindows = System.Runtime.InteropServices.RuntimeInformation.IsOSPlatform(System.Runtime.InteropServices.OSPlatform.Windows);\n        if (!isWindows)\n            return false;\n\n        bool isRedirected;\n        try\n        {\n            // Check if the standard output stream has been redirected\n            isRedirected = !System.IO.Console.OpenStandardOutput().Equals(System.IO.Stream.Null);\n        }\n        catch (Exception)\n        {\n            isRedirected = false;\n        }\n\n        // Return true if the application is running in an interactive session and stdout is not redirected.\n        return Environment.UserInteractive && isRedirected;\n    }\n}