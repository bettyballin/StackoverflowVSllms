using System.ServiceModel.Description;\n\npublic class MyServiceHost : ServiceHost\n{\n    // ...\n\n    protected override void OnStart(string[] args)\n    {\n        // ...\n\n        var credentials = new ServiceCredentials();\n        credentials.WindowsAuthentication.AllowAnonymousLogons = false;\n        credentials.WindowsAuthentication.IncludeWindowsGroups = true;\n        Description.Behaviors.Add(credentials);\n    }\n}