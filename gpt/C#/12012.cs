// Example of a partial view in ASP.NET MVC\n   public ActionResult MyPartialView()\n   {\n       var model = GetModelData();\n       return PartialView("_MyPartialView", model);\n   }