using System.IO;\n    using System.Web.Mvc;\n\n    public class HomeController : Controller\n    {\n        [HttpPost]\n        public ActionResult UploadXml()\n        {\n            using (var reader = new StreamReader(Request.InputStream))\n            {\n                var xmlData = reader.ReadToEnd();\n                // Process the XML data here\n\n                // Respond with a success message\n                return Content("Upload successful");\n            }\n        }\n    }