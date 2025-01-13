public async Task<List<YourEntityDto>> GetYourEntitiesAsync()\n{\n    // Using projection to load only necessary fields\n    return await context.YourEntities\n        .Select(e => new YourEntityDto\n        {\n            Property1 = e.Property1,\n            Property2 = e.Property2,\n            // Include other necessary properties\n        })\n        .AsSplitQuery() // Split query to manage large includes\n        .ToListAsync();\n}