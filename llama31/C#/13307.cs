// DataProviderFactory.cs\npublic static class DataProviderFactory\n{\n    public static IDataProvider CreateDataProvider(string providerType)\n    {\n        string connectionString = ConfigurationManager.ConnectionStrings[providerType].ConnectionString;\n        // ...\n    }\n}