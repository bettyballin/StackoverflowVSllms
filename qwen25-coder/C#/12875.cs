using System.Configuration;\n   \n   public class form : System.Windows.Forms.Form\n   {\n       public form()\n       {\n           InitializeComponent();\n           string ipAddress = ConfigurationManager.AppSettings["IPAddress"];\n           IP = IPAddress.Parse(ipAddress);\n       }\n   }