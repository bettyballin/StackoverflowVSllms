using NHibernate.Cfg;\nusing NHibernate.Cfg.Loquacious;\nusing NHibernate.Dialect;\nusing NHibernate.Mapping.ByCode;\n\npublic class CustomNamingStrategy : INamingStrategy\n{\n    private readonly string _schema;\n\n    public CustomNamingStrategy(string schema)\n    {\n        _schema = schema;\n    }\n\n    public string ClassToTableName(string className)\n    {\n        return $"{_schema}.{className}";\n    }\n\n    // Implement other INamingStrategy methods as needed.\n    // For simplicity, we are only dealing with ClassToTableName here.\n    // You can implement additional methods if you use other mappings.\n\n    public string TableName(string tableName)\n    {\n        return $"{_schema}.{tableName}";\n    }\n\n    public string PropertyToColumnName(string propertyName)\n    {\n        return propertyName;\n    }\n    \n    public string ColumnName(string columnName)\n    {\n        return columnName;\n    }\n    \n    public string PropertyToTableName(string className, string propertyName)\n    {\n        return PropertyToColumnName(propertyName);\n    }\n    \n    public string LogicalColumnName(string columnName, string propertyName)\n    {\n        return string.IsNullOrEmpty(columnName) ? propertyName : columnName;\n    }\n}