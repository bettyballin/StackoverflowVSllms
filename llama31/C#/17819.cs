using System;\nusing System.Collections.Generic;\nusing Microsoft.Deployment.WindowsInstaller;\n\npublic class ConfigureIIS : CustomAction\n{\n  public override void Execute(Session session)\n  {\n    // Get the IIS directory path\n    string iisDir = session.GetTargetPath("IIS_DIR");\n\n    // Create an IIS application pool\n    using (var appPool = new ApplicationPool("MyWcfServiceAppPool"))\n    {\n      appPool.AutoStart = true;\n      appPool.ManagedPipelineMode = ManagedPipelineMode.Integrated;\n    }\n\n    // Create an IIS website\n    using (var website = new Website("MyWcfServiceWebsite"))\n    {\n      website.ApplicationDefaults.ApplicationPoolName = "MyWcfServiceAppPool";\n      website.Bindings.Add(new Binding("http", "*:80:", iisDir));\n    }\n\n    // Create an IIS application\n    using (var app = new Application("MyWcfServiceApp", "/MyWcfService"))\n    {\n      app.ApplicationPoolName = "MyWcfServiceAppPool";\n      app.VirtualDirectoryDefaults.PhysicalPath = iisDir;\n    }\n  }\n}