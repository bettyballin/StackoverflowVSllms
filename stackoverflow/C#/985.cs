public ActionResult ContinueToCorr(string Number, string Rev)\n{\n    ViewData["DivIsVisible"] = true;\n    return RedirectToAction("../Wizard/Index/1");\n}