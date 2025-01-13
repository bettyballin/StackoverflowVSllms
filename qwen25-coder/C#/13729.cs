public class ErrorHandlerController : Controller\n{\n    public ActionResult NotFound()\n    {\n        string originalPath = Request.RawUrl;\n\n        // Define your old URL to new URL mappings here\n        var redirects = new Dictionary<string, string>\n        {\n            {"/old-page-1", "/new-page-1"},\n            {"/old-page-2", "/new-page-2"}\n        };\n\n        if (redirects.ContainsKey(originalPath))\n        {\n            Response.StatusCode = 301;\n            Response.StatusDescription = "Moved Permanently";\n            return RedirectPermanent(redirects[originalPath]);\n        }\n\n        // Log the error and return a custom not found view\n        return View("NotFound");\n    }\n}