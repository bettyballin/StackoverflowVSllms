if (arg_gui || Environment.UserInteractive || Debugger.IsAttached)\n{\n    Application.EnableVisualStyles();\n    Application.SetCompatibleTextRenderingDefault(false);\n    Application.Run(new Form1());\n}\nelse\n{\n    rethrow = true; // so that windows sees error...\n    ServiceBase[] services = { new Service1() };\n    ServiceBase.Run(services);\n    rethrow = false;\n}