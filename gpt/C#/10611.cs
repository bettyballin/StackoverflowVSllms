public ActionResult MainView()\n{\n    if (Request.IsAjaxRequest())\n    {\n        return UpdatePanels();\n    }\n\n    // Full page load\n    return View();\n}