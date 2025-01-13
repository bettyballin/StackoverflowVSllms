using System.ComponentModel.Composition.Hosting;\n\n// Create a catalog that will hold the plugins\nvar catalog = new AggregateCatalog();\n\n// Add the current assembly (your add-in) to the catalog\ncatalog.Catalogs.Add(new AssemblyCatalog(Assembly.GetExecutingAssembly()));