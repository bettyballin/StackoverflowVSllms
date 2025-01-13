using System.ComponentModel.Composition;\n\n[Export(typeof(IPlugin))]\npublic class MyPlugin : IPlugin\n{\n    public void DoSomething()\n    {\n        Console.WriteLine("Hello from MyPlugin!");\n    }\n}\n\n[ImportMany(typeof(IPlugin))]\npublic class MyApplication\n{\n    private readonly IEnumerable<IPlugin> _plugins;\n\n    public MyApplication(IEnumerable<IPlugin> plugins)\n    {\n        _plugins = plugins;\n    }\n\n    public void Run()\n    {\n        foreach (var plugin in _plugins)\n        {\n            plugin.DoSomething();\n        }\n    }\n}