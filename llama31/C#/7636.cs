public JsonResult GetList()\n{\n    // ... create model ...\n    var html = new StringWriter();\n    Html.RenderPartial("CategoryList", model, html);\n    return Json(new { html = html.ToString() });\n}