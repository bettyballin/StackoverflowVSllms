public ActionResult SendReport(string date)\n{\n    // DO Stuff\n    Response.Headers["Content-Type"] = "text/javascript";\n    return new JsonResult\n    {\n        Data = new { result = "OK" }\n    };\n}