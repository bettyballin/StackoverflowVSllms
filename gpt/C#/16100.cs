using System.Web.Routing;\n\n   void Application_Start(object sender, EventArgs e)\n   {\n       RegisterRoutes(RouteTable.Routes);\n   }\n\n   public static void RegisterRoutes(RouteCollection routes)\n   {\n       routes.Ignore("{resource}.axd/{*pathInfo}");\n       routes.MapPageRoute("AskRoute", "questions/ask", "~/questions/ask.aspx");\n       // Add more routes as needed\n   }