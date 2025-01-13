using System;\n   using System.IO;\n   using System.Web.UI;\n\n   public partial class Default : Page\n   {\n       protected void Page_Load(object sender, EventArgs e)\n       {\n           // Load template\n           string templatePath = Server.MapPath("~/template.html");\n           string template = File.ReadAllText(templatePath);\n\n           // Replace placeholders with dynamic content\n           string title = "My CMS";\n           string menuHtml = "<ul><li>Home</li><li>About</li></ul>";\n           string contentHtml = "<p>Welcome to my website.</p>";\n\n           template = template.Replace("[title]", title);\n           template = template.Replace("[menu]", menuHtml);\n           template = template.Replace("[content]", contentHtml);\n\n           // Render final HTML\n           Response.Write(template);\n       }\n   }