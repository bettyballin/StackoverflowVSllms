routes.MapRoute("wikiRoute",\n                "{*path}",\n                new { controller = "Wiki", action = "page" })\n                .RouteHandler = new WikiRouteHandler();