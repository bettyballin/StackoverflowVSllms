using System.Web.Routing;\n\n   public class Global : System.Web.HttpApplication\n   {\n       void Application_Start(object sender, EventArgs e)\n       {\n           RegisterRoutes(RouteTable.Routes);\n       }\n\n       public static void RegisterRoutes(RouteCollection routes)\n       {\n           // Add routes here\n           routes.MapPageRoute("TestRoute", "test", "~/test.aspx");\n           \n           // Add more routes as needed\n       }\n   }