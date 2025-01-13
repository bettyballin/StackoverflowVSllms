using System;\nusing System.Collections.Generic;\nusing System.IO;\nusing System.Web.Caching;\n\npublic class TemplateEngine\n{\n    private static readonly Dictionary<string, string> TemplateCache = new Dictionary<string, string>();\n    private static readonly string TemplatesDirectory = "Path/To/Templates";\n\n    public string GetTemplate(string templateName)\n    {\n        if (string.IsNullOrEmpty(templateName)) throw new ArgumentNullException(nameof(templateName));\n\n        // First, check in-memory cache\n        if (HttpRuntime.Cache[templateName] != null)\n        {\n            return HttpRuntime.Cache[templateName] as string;\n        }\n\n        // If not in memory, load from disk or database\n        var templatePath = Path.Combine(TemplatesDirectory, $"{templateName}.xml");\n        if (File.Exists(templatePath))\n        {\n            var templateContent = File.ReadAllText(templatePath);\n            \n            // Store in cache for future requests\n            HttpRuntime.Cache.Add(\n                templateName,\n                templateContent,\n                null,\n                DateTime.UtcNow.AddMinutes(10),  // Adjust sliding expiration as needed\n                System.Web.Caching.Cache.NoSlidingExpiration, \n                CacheItemPriority.High,\n                OnTemplateRemoved);\n\n            return templateContent;\n        }\n\n        throw new FileNotFoundException($"Template {templateName} not found.");\n    }\n\n    private static void OnTemplateRemoved(string key, object value, CacheItemRemovedReason reason)\n    {\n        // Optionally remove from in-memory dictionary to free up space\n        if (reason == CacheItemRemovedReason.Expired || reason == CacheItemRemovedReason.RemovedViaCacheSpecificApi)\n        {\n            TemplateCache.Remove(key);\n        }\n    }\n}