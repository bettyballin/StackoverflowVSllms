public class CustomRouteHandler : IRouteHandler\n   {\n       public IHttpHandler GetHttpHandler(RequestContext requestContext)\n       {\n           if (requestContext == null || requestContext.HttpContext == null)\n           {\n               // Add logging here to help diagnose when/why this happens.\n               return new HttpNotFoundHandler();\n           }\n\n           // Proceed with your existing handler logic...\n       }\n   }