// Example of initializing ActiveReports Web Report Designer in an ASP.NET MVC controller\npublic ActionResult ReportDesigner()\n{\n    ViewBag.DesignerUrl = Url.Content("~/web-reportdesigner/");\n    return View();\n}