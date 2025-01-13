using System;\nusing System.IO;\nusing System.Reflection;\n\npublic static class PluginManager\n{\n    private static List<IPlugin> plugins = new List<IPlugin>();\n\n    public static void LoadPlugins()\n    {\n        var pluginPath = Path.Combine(AppDomain.CurrentDomain.BaseDirectory, "Plugins");\n\n        foreach (var file in Directory.GetFiles(pluginPath, "*.dll"))\n        {\n            Assembly assembly = Assembly.LoadFrom(file);\n            foreach (Type type in assembly.GetTypes())\n            {\n                if (typeof(IPlugin).IsAssignableFrom(type) && !type.IsInterface)\n                {\n                    IPlugin pluginInstance = Activator.CreateInstance(type) as IPlugin;\n                    plugins.Add(pluginInstance);\n                }\n            }\n        }\n    }\n\n    public static void ExecutePlugins()\n    {\n        foreach (var plugin in plugins)\n        {\n            plugin.Execute();\n        }\n    }\n}