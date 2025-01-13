using System;\nusing System.Diagnostics;\nusing System.IO;\nusing System.Reflection;\n\npublic class ProductInfoRetriever\n{\n    public static string GetCallingExecutableProductName()\n    {\n        // Get the process that is calling the .NET DLL\n        Process currentProcess = Process.GetCurrentProcess();\n        string callingExecutablePath = currentProcess.MainModule.FileName;\n\n        // Load the version info from the executable\n        var versionInfo = FileVersionInfo.GetVersionInfo(callingExecutablePath);\n\n        // Retrieve the product name\n        return versionInfo.ProductName;\n    }\n\n    public static string GetCallingExecutableVersion()\n    {\n        // Get the process that is calling the .NET DLL\n        Process currentProcess = Process.GetCurrentProcess();\n        string callingExecutablePath = currentProcess.MainModule.FileName;\n\n        // Load the version info from the executable\n        var versionInfo = FileVersionInfo.GetVersionInfo(callingExecutablePath);\n\n        // Retrieve the version\n        return versionInfo.FileVersion;\n    }\n}