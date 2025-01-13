public class PluginManager\n{\n    private readonly List<IPlugin> _plugins;\n\n    public PluginManager(string pluginFolderPath)\n    {\n        var loader = new PluginLoader();\n        _plugins = loader.LoadPlugins(pluginFolderPath);\n    }\n\n    public void ExecutePlugins()\n    {\n        foreach (var plugin in _plugins)\n        {\n            plugin.Execute();\n        }\n    }\n\n    public List<string> GetPluginNames()\n    {\n        return _plugins.Select(p => p.Name).ToList();\n    }\n}