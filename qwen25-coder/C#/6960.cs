var projectedData = queryableData\n    .Select(s => new SelectedData { ID = s.ID, Name = s.Name })\n    .ToList();\n    \nreturn projectedData;