public override IEnumerable<T> SelectQuery(Dictionary<string, (string value, string op)> criteriaDictionary)\n{\n    string t = typeof(T).Name;\n    string criteria = string.Empty;\n\n    foreach (var item in criteriaDictionary)\n    {\n        string propertyName = item.Key;\n        string value = item.Value.value;\n        string op = item.Value.op;\n\n        var propertyType = typeof(T).GetProperty(propertyName)?.PropertyType;\n\n        if (criteria != string.Empty)\n        {\n            criteria += " " + op + " ";\n        }\n\n        if (propertyType == typeof(string) || propertyType == typeof(DateTime))\n        {\n            criteria += propertyName + " = '" + value + "'";\n        }\n        else if (propertyType == typeof(int) || propertyType == typeof(double) || propertyType == typeof(float) || propertyType.IsEnum)\n        {\n            criteria += propertyName + " = " + value;\n        }\n        else\n        {\n            throw new NotSupportedException("Unsupported property type: " + propertyType);\n        }\n    }\n\n    string query = "from " + t;\n\n    if (criteria != string.Empty)\n    {\n        query += " where " + criteria;\n    }\n\n    return FindByHql(query);\n}