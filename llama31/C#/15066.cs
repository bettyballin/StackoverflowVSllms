// Add the template as an embedded resource\n// Template.txt is the file name, and TemplateResource is the resource name\n[assembly: System.Web.UI.WebResource("Template.txt", "text/plain", PerformSubstitution = true)]\n\n// Access the template\nstring template = new StreamReader(Assembly.GetExecutingAssembly().GetManifestResourceStream("TemplateResource")).ReadToEnd();