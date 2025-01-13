using System.ComponentModel.Composition;\n\n[Export(typeofILogger))]\npublic class Logger { }\n\n[Import(typeof(ILogger))]\npublic class MyComponent\n{\n    private readonly ILogger _logger;\n\n    public MyComponent(ILogger logger)\n    {\n        _logger = logger;\n    }\n\n    public void DoSomething()\n    {\n        _logger.Log("Doing something...");\n    }\n}