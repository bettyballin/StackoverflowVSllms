public ActionResult GetSimilarIssues(string title)\n{\n    var issues = _db.GetSimilarIssues(title).ToList();\n    if (title == null || issues.Count() == 0)\n        return PartialView("NoData");\n\n    return PartialView("SimilarIssues", issues);\n}