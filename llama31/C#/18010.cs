public override IEnumerable<T> SelectQuery(List<QueryCondition> conditions)\n{\n    string t = Convert.ToString(typeof(T).Name);\n    string criteria = string.Empty;\n\n    foreach (var condition in conditions)\n    {\n        var propertyInfo = typeof(T).GetProperty(condition.PropertyName);\n        var dataType = propertyInfo.PropertyType;\n\n        // Handle different data types\n        string formattedValue;\n        if (dataType == typeof(int))\n        {\n            formattedValue = condition.Value.ToString();\n        }\n        else\n        {\n            formattedValue = "'" + condition.Value.ToString() + "'";\n        }\n\n        // Build the criteria string\n        if (criteria != string.Empty)\n        {\n            criteria += condition.Operator == LogicalOperator.And ? " and " : " or ";\n        }\n        criteria += condition.PropertyName + " = " + formattedValue;\n    }\n\n    string query = " from " + t;\n\n    if (criteria != string.Empty)\n        query += " where " + criteria;\n\n    return FindByHql(query);\n}