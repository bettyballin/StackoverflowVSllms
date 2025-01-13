using System;\nusing System.IO;\nusing Microsoft.Deployment.WindowsInstaller;\n\npublic class CustomActions\n{\n    [CustomAction]\n    public static ActionResult CleanupDlls(Session session)\n    {\n        string installPath = session["INSTALLDIR"];\n        try\n        {\n            foreach (string dllName in new[] { "OldDll1.dll", "OldDll2.dll" })\n            {\n                string filePath = Path.Combine(installPath, dllName);\n                if (File.Exists(filePath))\n                {\n                    File.Delete(filePath);\n                }\n            }\n            return ActionResult.Success;\n        }\n        catch (Exception ex)\n        {\n            session.Log("Cleanup failed: {0}", ex.Message);\n            return ActionResult.Failure;\n        }\n    }\n}