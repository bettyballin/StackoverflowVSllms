public class SearchTemplate\n{\n    public string SelectFields { get; set; }\n    public List<string> WhereClauses { get; set; }\n    public string JoinClause { get; set; }\n\n    // Other properties as required...\n}\n\n// Define these templates in a static place like code or config.\nprivate Dictionary<int, SearchTemplate> _searchTemplates = new Dictionary<int, SearchTemplate>\n{\n    { 1, new SearchTemplate { SelectFields = "Table1.FieldA", WhereClauses = new List<string> { "Table1.FieldB = @Param1" }, JoinClause = "" } },\n    // More templates...\n};\n\nprivate string BuildQuery(int templateId)\n{\n    if (!_searchTemplates.ContainsKey(templateId))\n        throw new ArgumentException("Invalid template ID");\n\n    var template = _searchTemplates[templateId];\n    var query = $"SELECT {template.SelectFields} FROM Table1 {template.JoinClause}";\n\n    if (template.WhereClauses.Count > 0)\n    {\n        query += " WHERE " + string.Join(" AND ", template.WhereClauses);\n    }\n\n    return query;\n}