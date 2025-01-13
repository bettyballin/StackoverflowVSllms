using System.Web.Routing;\n\npublic class NickRoute : RouteBase\n{\n    public override RouteData GetRouteData(HttpContextBase httpContext)\n    {\n        var path = httpContext.Request.Path.Trim('/');\n\n        // Ignore requests to .aspx files, images, and folders\n        if (path.Contains(".") || path.Contains("/"))\n            return null;\n\n        var routeData = new RouteData(this, new MvcRouteHandler());\n        routeData.Values.Add("nick", path);\n        return routeData;\n    }\n\n    public override VirtualPathData GetVirtualPath(RequestContext requestContext, RouteValueDictionary values)\n    {\n        return null;\n    }\n}