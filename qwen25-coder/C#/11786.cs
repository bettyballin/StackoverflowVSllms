public class RouteConfig\n{\n    public static void RegisterRoutes(RouteCollection routes)\n    {\n        routes.MapPageRoute(\n            "ProductRoute",\n            "products/{ProductId}",\n            "~/Products/ProductDetails.aspx"\n        );\n    }\n}