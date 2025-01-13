using Microsoft.Practices.Unity;\nusing System;\nusing System.IO;\nusing System.Reflection;\nusing System.Threading.Tasks;\nusing System.Web;\n\npublic class DynamicHttpModuleLoader : IHttpModule\n{\n    private static readonly object lockObject = new object();\n    private IUnityContainer container;\n    private FileSystemWatcher watcher;\n\n    public void Init(HttpApplication context)\n    {\n        container = new UnityContainer();\n\n        LoadModulesFromDirectory("path_to_modules");\n\n        SetupFileSystemWatcher("path_to_modules");\n    }\n\n    private void LoadModulesFromDirectory(string path)\n    {\n        lock (lockObject)\n        {\n            var files = Directory.GetFiles(path, "*.dll");\n\n            foreach (var file in files)\n            {\n                try\n                {\n                    var assembly = Assembly.LoadFrom(file);\n                    var types = assembly.GetTypes();\n\n                    foreach (var type in types)\n                    {\n                        if (typeof(IHttpModule).IsAssignableFrom(type) && !type.IsInterface && !type.IsAbstract)\n                        {\n                            container.RegisterType<IHttpModule>(type.Name, type);\n                            context.AddModule(container.Resolve<IHttpModule>(type.Name));\n                        }\n                    }\n                }\n                catch (Exception ex)\n                {\n                    // Log exception\n                    Console.WriteLine("Failed to load module from " + file);\n                    Console.WriteLine(ex.Message);\n                }\n            }\n        }\n    }\n\n    private void SetupFileSystemWatcher(string path)\n    {\n        watcher = new FileSystemWatcher(path)\n        {\n            EnableRaisingEvents = true,\n            IncludeSubdirectories = false,\n            NotifyFilter = NotifyFilters.LastWrite | NotifyFilters.FileName\n        };\n\n        watcher.Changed += async (sender, e) =>\n        {\n            await Task.Delay(2000); // Debounce to ensure file is not locked\n            LoadModulesFromDirectory(path);\n        };\n    }\n\n    public void Dispose() => container.Dispose();\n}