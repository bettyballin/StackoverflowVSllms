public class Storage\n{\n    public string FilePath { get; set; }\n}\n\n// In Startup.cs or Program.cs (for ASP.NET Core)\npublic void ConfigureServices(IServiceCollection services)\n{\n    services.AddSingleton<Storage>();\n}\n\n// Usage in a controller or service\npublic class MyClass\n{\n    private readonly Storage _storage;\n\n    public MyClass(Storage storage)\n    {\n        _storage = storage;\n    }\n\n    public void DoSomething()\n    {\n        _storage.FilePath = "path/to/file.txt";\n        Console.WriteLine(_storage.FilePath);\n    }\n}