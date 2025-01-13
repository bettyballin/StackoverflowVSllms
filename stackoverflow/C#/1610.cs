[AcceptVerbs(HttpVerbs.Get)]\npublic ActionResult Show(int id, bool? asHtml)\n{\n    var result = Stationery.Load(id);\n\n    if (asHtml.HasValue && asHtml.Value)\n        return Content(result.GetHtml());\n    else\n        return new XmlResult(result);\n}