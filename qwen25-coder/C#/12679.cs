[AllowAnonymous]\npublic ActionResult KeepSessionAlive()\n{\n    return Json(new { success = true }, JsonRequestBehavior.AllowGet);\n}