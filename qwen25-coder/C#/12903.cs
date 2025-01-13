using System;\n   using System.Net;\n   using System.Configuration;\n\n   public class form : System.Windows.Forms.Form\n   {\n       public form()\n       {\n           InitializeComponent();\n           try\n           {\n               string ipAddress = ConfigurationManager.AppSettings["IPAddress"];\n               IP = IPAddress.Parse(ipAddress);\n           }\n           catch (ConfigurationErrorsException ex)\n           {\n               // Handle exception, log or set default value\n               Console.WriteLine("Configuration error: " + ex.Message);\n               IP = IPAddress.Parse("127.0.0.1"); // Default IP\n           }\n           catch (FormatException ex)\n           {\n               // Handle parsing error\n               Console.WriteLine("Format error in IP address: " + ex.Message);\n               IP = IPAddress.Parse("127.0.0.1"); // Default IP\n           }\n       }\n   }