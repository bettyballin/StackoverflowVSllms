public class MyRoute : RouteBase\n{\n    private List<Route> _routes = new List<Route>();\n\n    public MyRoute(string resource)\n    {\n        // make a Resource property, not shown in this example\n        this.Resource = resource;\n\n        // Generate all your routes here\n        _routes.Add(\n            new Route("some/url/{param1}",\n            new McvRouteHandler {\n                Defaults = new RouteValueDictionary(new {\n                    controller = resource,\n                    action = actionName\n                }),\n            Constraints = new RouteValueDictionary()\n        );\n        _routes.Add(...); // another new route   \n    }\n\n    public override RouteData GetRouteData(HttpContextBase context)\n    {\n        foreach (var route in _routes)\n        {\n            var data = route.GetRouteData(context);\n            if (data != null)\n            { \n                return data;\n            }\n        }\n        return null;\n    }\n\n    public override VirtualPathData GetVirtualPath(RequestContext context, RouteValueDictionary rvd)\n    {\n        foreach (var route in _routes)\n        {\n            var path = route.GetVirtualPath(context, rvd);\n            if (path != null)\n            { \n                return path;\n            }\n        }\n        return null;\n    }\n}