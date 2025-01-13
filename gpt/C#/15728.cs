using System;\nusing System.Web;\nusing System.Runtime.Caching;\n\npublic class Global : HttpApplication\n{\n    private static MemoryCache _cache = MemoryCache.Default;\n\n    protected void Application_BeginRequest(Object sender, EventArgs e)\n    {\n        if (IsCategoryUrl())\n        {\n            string categoryName = ParseCategoryNameFromUrl(Request.Url);\n            string categoryId = GetCategoryIdByName(categoryName);\n            Context.RewritePath("/Category.aspx?id=" + categoryId);\n        }\n    }\n\n    private bool IsCategoryUrl()\n    {\n        // Implement your logic to check if URL is a category URL\n        return true;\n    }\n\n    private string ParseCategoryNameFromUrl(Uri url)\n    {\n        // Implement your logic to parse category name from URL\n        return "Dogs";\n    }\n\n    private string GetCategoryIdByName(string categoryName)\n    {\n        string cacheKey = "CategoryId_" + categoryName;\n        if (_cache.Contains(cacheKey))\n        {\n            return _cache.Get(cacheKey) as string;\n        }\n\n        string categoryId = GetCategoryIdByNameFromDB(categoryName);\n        _cache.Set(cacheKey, categoryId, DateTimeOffset.UtcNow.AddMinutes(30)); // Set cache duration as per your requirement\n\n        return categoryId;\n    }\n\n    private string GetCategoryIdByNameFromDB(string categoryName)\n    {\n        // Implement your database logic to get category ID by name\n        return "2"; // Example category ID\n    }\n}