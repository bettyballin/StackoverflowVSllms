using System;\nusing System.Security;\n\nclass CustomSecurityManager : HostSecurityManager\n{\n    public override bool IsGranted(Assembly assembly, SecurityAction action, PermissionSet permissionSet)\n    {\n        // Restrict the use of Assert\n        if (action == SecurityAction.Assert)\n        {\n            return false;\n        }\n\n        // Delegate to the default security manager\n        return base.IsGranted(assembly, action, permissionSet);\n    }\n}