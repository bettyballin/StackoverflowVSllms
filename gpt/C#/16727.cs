using System.Web;\n    using System.Web.Routing;\n\n    public class WikiRouteConstraint : IRouteConstraint\n    {\n        public bool Match(HttpContextBase httpContext, Route route, string parameterName, RouteValueDictionary values, RouteDirection routeDirection)\n        {\n            string path = httpContext.Request.Path;\n\n            // Check if the path ends with "wiki"\n            return path.EndsWith("wiki", StringComparison.OrdinalIgnoreCase);\n        }\n    }