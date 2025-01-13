public class CompositionHelper\n{\n    private static CompositionContainer _container;\n\n    public static CompositionContainer Container\n    {\n        get\n        {\n            if (_container == null)\n            {\n                var catalog = new AggregateCatalog();\n                catalog.Catalogs.Add(new AssemblyCatalog(System.Reflection.Assembly.GetExecutingAssembly()));\n                catalog.Catalogs.Add(new DirectoryCatalog("."));\n                _container = new CompositionContainer(catalog);\n            }\n            return _container;\n        }\n    }\n\n    public static void ComposeParts(params object[] attributedParts)\n    {\n        var batch = new CompositionBatch();\n        foreach (var part in attributedParts)\n        {\n            batch.AddPart(part);\n        }\n        Container.Compose(batch);\n    }\n}