Solution\n│\n├── Core.Interfaces (Project)\n│   └── ICoreService.cs\n│\n├── Core (Project)\n│   └── CoreService.cs (implements ICoreService)\n│\n├── Plugin.Interfaces (Project)\n│   └── IPlugin.cs\n│\n├── Plugin (Project)\n│   └── PluginImplementation.cs (implements IPlugin)\n│\n├── MainApp (Project)\n│   └── Program.cs (references Core.Interfaces, Core, Plugin.Interfaces, Plugin)