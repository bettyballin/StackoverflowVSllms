using System.Security.Principal;\nusing System.Threading;\n\npublic void WriteFileWithAppPoolIdentity(string filePath, string content)\n{\n    WindowsImpersonationContext impersonationContext = null;\n    \n    try\n    {\n        // Revert to original app pool identity\n        impersonationContext = WindowsIdentity.Impersonate(IntPtr.Zero);\n        \n        // Code that requires app pool permissions\n        System.IO.File.WriteAllText(filePath, content);\n    }\n    catch (Exception ex)\n    {\n        // Handle exceptions\n        throw;\n    }\n    finally\n    {\n        if (impersonationContext != null)\n        {\n            impersonationContext.Undo();\n        }\n    }\n}