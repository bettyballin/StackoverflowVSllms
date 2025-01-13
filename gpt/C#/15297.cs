using System.IO;\n    using System.Web;\n\n    public class ContentBox\n    {\n        public static string DrawTop(string title, string textColour, string backgroundColour)\n        {\n            string templatePath = HttpContext.Current.Server.MapPath("~/Resources/AvonAndSomerset/Admin/UI/TopTemplate.html");\n            string template = File.ReadAllText(templatePath);\n            // Add your logic to replace placeholders with actual values (title, textColour, backgroundColour)\n            return template;\n        }\n\n        public static string DrawBottom()\n        {\n            string templatePath = HttpContext.Current.Server.MapPath("~/Resources/AvonAndSomerset/Admin/UI/BottomTemplate.html");\n            string template = File.ReadAllText(templatePath);\n            // Add your logic to process the template if needed\n            return template;\n        }\n    }