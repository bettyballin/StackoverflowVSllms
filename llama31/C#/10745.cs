public ActionResult GetData()\n{\n    var jsonData = new { foo = "bar" };\n    return Json(jsonData, JsonRequestBehavior.AllowGet);\n}