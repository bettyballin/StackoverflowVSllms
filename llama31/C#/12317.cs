AppDomainSetup setup = new AppDomainSetup();\nsetup.ApplicationBase = Path.GetDirectoryName(typeof(MyApp).Assembly.Location);\n\nPermissionSet permissionSet = new PermissionSet(PermissionState.None);\npermissionSet.AddPermission(new SecurityPermission(SecurityPermissionFlag.Execution));\n\nAppDomain sandboxDomain = AppDomain.CreateDomain("SandboxDomain", null, setup, permissionSet);