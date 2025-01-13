using System.Web.Mvc;\n\npublic class HomeController : Controller\n{\n    public ActionResult Index()\n    {\n        bool isInIframe = false;\n\n        // Check if the "Referer" header is present\n        var referer = Request.Headers["Referer"];\n        if (!string.IsNullOrEmpty(referer))\n        {\n            // Optionally, you can perform additional checks on the referer value\n            isInIframe = true;\n        }\n\n        // Pass the iframe status to the view\n        ViewBag.IsInIframe = isInIframe;\n\n        return View();\n    }\n}