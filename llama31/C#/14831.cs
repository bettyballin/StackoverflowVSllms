[AcceptVerbs(HttpVerbs.Post)]\npublic ActionResult GenericPostHandler(NewAccountInfo info)\n{\n    try\n    {\n        string currentView = Path.GetFileName(Request.UrlReferrer.AbsolutePath);\n        Persist();\n\n        return RedirectToAction(StepManager.GetNextStep(currentView));\n    }\n    catch\n    {\n        return View();\n    }\n}