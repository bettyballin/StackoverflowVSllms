public class RouteConfig\n{\n    public static void RegisterRoutes(RouteCollection routes)\n    {\n        routes.IgnoreRoute("{resource}.axd/{*pathInfo}");\n\n        // Add a route for the profile page\n        routes.MapRoute(\n            name: "Profile",\n            url: "members/{username}",\n            defaults: new { controller = "Members", action = "Profile" },\n            constraints: new { username = @"^[a-zA-Z0-9]*$" } // Optional: Constraint for valid usernames\n        );\n\n        // Default route\n        routes.MapRoute(\n            name: "Default",\n            url: "{controller}/{action}/{id}",\n            defaults: new { controller = "Home", action = "Index", id = UrlParameter.Optional }\n        );\n    }\n}