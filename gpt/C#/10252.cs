public static void RegisterRoutes(RouteCollection routes)\n   {\n       MetaModel model = new MetaModel();\n       model.RegisterContext(\n           new LinqToSqlDataModelProvider(() => new YourDataContext()),\n           new ContextConfiguration() { ScaffoldAllTables = true });\n\n       routes.Add(new DynamicDataRoute("{table}/{action}.aspx")\n       {\n           Constraints = new RouteValueDictionary(new { action = "List|Details|Edit|Insert" }),\n           Model = model\n       });\n   }\n\n   protected void Application_Start(object sender, EventArgs e)\n   {\n       RegisterRoutes(RouteTable.Routes);\n   }