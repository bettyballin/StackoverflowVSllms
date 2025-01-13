using System.IO;\nusing System.Web;\nusing System.Web.Mvc;\n\npublic class CachedViewPage : ViewPage\n{\n    public string RenderToString()\n    {\n        var stringWriter = new StringWriter();\n        var htmlTextWriter = new HtmlTextWriter(stringWriter);\n        var viewContext = new ViewContext(ControllerContext, new WebFormView(this), ViewData, TempData, output: null);\n        var buildManager = new BuildManager();\n        var page = (ViewPage)buildManager.CreateInstanceFromVirtualPath(VirtualPath, typeof(ViewPage));\n        page.RenderView(viewContext);\n        page.RenderControl(htmlTextWriter);\n        return stringWriter.ToString();\n    }\n}