// Define a template for a search criterion\npublic class SearchCriterionTemplate\n{\n    public string FieldName { get; set; }\n    public string DbType { get; set; }\n    public string Template { get; set; }\n}\n\n// Define a template for a join\npublic class JoinTemplate\n{\n    public string TableName { get; set; }\n    public string JoinCondition { get; set; }\n    public string Template { get; set; }\n}\n\n// Use these templates to generate the SQL query\npublic class SearchService\n{\n    public IEnumerable SearchResult/Search(SearchCriteria[] criteria)\n    {\n        var query = new StringBuilder();\n        foreach (var criterion in criteria)\n        {\n            var template = SearchCriterionTemplate.GetTemplateForCriterion(criterion);\n            query.Append(template.Template.Replace("@field", criterion.FieldName));\n        }\n\n        var joins = JoinInfo.GetJoinsForCriteria(criteria);\n        foreach (var join in joins)\n        {\n            var template = JoinTemplate.GetTemplateForJoin(join);\n            query.Append(template.Template.Replace("@table", join.TableName));\n        }\n\n        // Execute the query and return the results\n        return db.ExecuteQuery(query.ToString());\n    }\n}