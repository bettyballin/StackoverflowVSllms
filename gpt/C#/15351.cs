public class PluginManager\n   {\n       [ImportMany]\n       public IEnumerable<Lazy<ITreeNode>> TreeNodes { get; set; }\n\n       [ImportMany]\n       public IEnumerable<Lazy<IContextAction>> ContextActions { get; set; }\n\n       public PluginManager()\n       {\n           var catalog = new AggregateCatalog();\n           catalog.Catalogs.Add(new AssemblyCatalog(typeof(PluginManager).Assembly)); // Current assembly\n           // Add other catalogs if needed\n\n           var container = new CompositionContainer(catalog);\n           container.ComposeParts(this);\n       }\n\n       public void LoadPlugins()\n       {\n           foreach (var node in TreeNodes)\n           {\n               // Add nodes to the tree view\n           }\n\n           foreach (var action in ContextActions)\n           {\n               // Add actions to the context menu\n           }\n       }\n   }