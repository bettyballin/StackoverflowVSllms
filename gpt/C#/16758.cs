[Export]\n   public class ForumsController : Controller\n   {\n       // Your controller methods here...\n   }\n\n   protected void Application_Start()\n   {\n       // Initialize MEF\n       var catalog = new AggregateCatalog();\n       catalog.Catalogs.Add(new DirectoryCatalog("bin"));\n       var container = new CompositionContainer(catalog);\n       var batch = new CompositionBatch();\n       batch.AddPart(this);\n       container.Compose(batch);\n\n       // Other initialization code...\n   }