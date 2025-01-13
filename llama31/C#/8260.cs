using System.Web.Http;\n\nnamespace MyApi\n{\n    public static class WebApiConfig\n    {\n        public static void Register(HttpConfiguration config)\n        {\n            config.MapHttpAttributeRoutes();\n\n            config.Routes.MapHttpRoute(\n                name: "DefaultApi",\n                routeTemplate: "api/{controller}/{id}",\n                defaults: new { id = RouteParameter.Optional }\n            );\n        }\n    }\n}