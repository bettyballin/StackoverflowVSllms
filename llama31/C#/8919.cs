using System.Text.RegularExpressions;\n\npublic class TableNameExtractor\n{\n    public static string[] ExtractTableNames(string sqlQuery)\n    {\n        string pattern = @"FROM\s+([\w\s,]+)(?:\s+WHERE|\s+GROUP BY|\s+ORDER BY|$)";\n        Match match = Regex.Match(sqlQuery, pattern, RegexOptions.IgnoreCase);\n\n        if (match.Success)\n        {\n            string tableNames = match.Groups[1].Value;\n            return tableNames.Split(new[] { ',' }, StringSplitOptions.RemoveEmptyEntries);\n        }\n\n        return new string[0];\n    }\n}