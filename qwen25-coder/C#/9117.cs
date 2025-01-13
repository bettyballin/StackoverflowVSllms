using System.Diagnostics;\nusing System.Security.Principal;\n\npublic static void CreateEventSource()\n{\n    WindowsIdentity identity = WindowsIdentity.GetCurrent();\n    using (WindowsImpersonationContext wic = identity.Impersonate())\n    {\n        if (!EventLog.SourceExists("MyCustomApp"))\n        {\n            EventLog.CreateEventSource("MyCustomApp", "Application");\n        }\n    }\n}