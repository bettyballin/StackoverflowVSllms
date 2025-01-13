using System.Data.Linq.Mapping;\n\n// Assume 'db' is your LINQ to SQL DataContext\nvar columnMetadata = db.Mapping.GetMetaType(typeof(YourTableName));\nforeach (var column in columnMetadata.DataMembers)\n{\n    if (column.DbType.Contains("varchar") || column.DbType.Contains("nvarchar"))\n    {\n        int maxLength = int.Parse(column.DbType.Split('(')[1].Split(')')[0]);\n        // Use maxLength to set the MaxLength property of the corresponding TextBox\n        // or to validate the string length in your API\n    }\n}