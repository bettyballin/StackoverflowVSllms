protected void Application_Start()\n{\n    AreaRegistration.RegisterAllAreas();\n    RouteConfig.RegisterRoutes(RouteTable.Routes);\n\n    // Remove all default view engines\n    ViewEngines.Engines.Clear();\n\n    // Add the custom view engine\n    ViewEngines.Engines.Add(new CustomViewEngine());\n}