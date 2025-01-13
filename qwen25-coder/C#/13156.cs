using System;\nusing System.IO;\nusing System.Reflection;\nusing System.Collections.Generic;\nusing System.Linq;\nusing ProbeContract;\nusing System.ComponentModel.Composition;\nusing System.ComponentModel.Composition.Hosting;\n\nnamespace MEFTest\n{\n    class Program\n    {\n        // Change this to a Lazy collection\n        [ImportMany]\n        public Lazy<IEnumerable<IProbe>> ProberSet { get; set; }\n\n        CompositionContainer exportContainer;\n        DirectoryCatalog pluginCatalog;\n        AggregateCatalog catalog;\n\n        private void Run()\n        {\n            catalog = new AggregateCatalog();\n            catalog.Catalogs.Add(new AssemblyCatalog(Assembly.GetExecutingAssembly()));\n            string myExecName = Assembly.GetExecutingAssembly().Location;\n            string myPath = Path.GetDirectoryName(myExecName);\n            pluginCatalog = new DirectoryCatalog(myPath + "/Plugins");\n            catalog.Catalogs.Add(pluginCatalog);\n            exportContainer = new CompositionContainer(catalog);\n\n            CompositionBatch compBatch = new CompositionBatch();\n            compBatch.AddPart(this);\n            exportContainer.Compose(compBatch);\n\n            for (; ; )\n            {\n                Console.Write("Press any key to run all probes: ");\n                Console.ReadKey(true);\n                Console.WriteLine();\n                pluginCatalog.Refresh();\n                // Access the Value property of Lazy<IEnumerable<IProbe>> to get the collection\n                foreach (var Prober in ProberSet.Value)\n                {\n                    Prober.DoProbe("gizmo");\n                }\n            }\n        }\n\n        static void Main(string[] args)\n        {\n            Program p = new Program();\n            p.Run();\n        }\n    }\n}