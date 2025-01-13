using System;\nusing System.Collections.Generic;\nusing Microsoft.Deployment.WindowsInstaller;\n\nclass CustomActions\n{\n    [CustomAction]\n    public static ActionResult ChangeProductCode(Session session)\n    {\n        session["ProductCode"] = Guid.NewGuid().ToString();\n        return ActionResult.Success;\n    }\n}