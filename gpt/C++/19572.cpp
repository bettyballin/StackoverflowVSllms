class QueryBuilderFactory {\npublic:\n    static std::unique_ptr<QueryBuilder> createQueryBuilder(const std::string& dbType) {\n        if (dbType == "SQLServer") {\n            return std::make_unique<SqlServerQueryBuilder>();\n        } else if (dbType == "CustomDb") {\n            return std::make_unique<CustomDbQueryBuilder>();\n        }\n        // Add more database types as needed\n        throw std::runtime_error("Unsupported database type");\n    }\n};