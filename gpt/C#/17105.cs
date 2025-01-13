public class RouteConfig\n{\n    public static void RegisterRoutes(RouteCollection routes)\n    {\n        routes.IgnoreRoute("{resource}.axd/{*pathInfo}");\n\n        routes.MapRoute(\n            name: "Default",\n            url: "{controller}/{action}/{id}",\n            defaults: new { controller = "Home", action = "Index", id = UrlParameter.Optional }\n        );\n\n        routes.MapRoute(\n            name: "UserDetails",\n            url: "User/Details/{name}",\n            defaults: new { controller = "User", action = "Details", name = UrlParameter.Optional }\n        );\n    }\n}