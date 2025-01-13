protected void Application_BeginRequest(Object sender, EventArgs e)\n{\n    if (IsCategoryUrl())\n    {\n        string CategoryName = ParseCategoryNameFromUrl(Request.Url);\n        string CategoryId = GetCategoryIdByNameFromDB(CategoryName);\n        Context.RewritePath("/Category.aspx?id=" + CategoryId);\n        Response.TrySkipIisCustomErrors = true; // Add this line\n    }\n}