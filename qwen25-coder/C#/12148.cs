var results = context.YourTableName\n    .Select(item => new {\n        DisplayName = item.IsCompany ? item.CompanyName : $"{item.LastName}, {item.FirstName}",\n        IsCompany = item.IsCompany\n    })\n    .OrderBy(item => item.IsCompany)\n    .ThenBy(item => item.IsCompany ? item.DisplayName : null)\n    .ToList();