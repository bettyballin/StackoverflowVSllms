using System;\nusing System.Data;\nusing Microsoft.VisualStudio.Data;\nusing Microsoft.VisualStudio.Data.Services;\n\nnamespace OracleDataProvider\n{\n    [DataServiceProvider(typeof(OracleDataProviderFactory))]\n    public class OracleDataProvider : DataProvider\n    {\n        public override string Name\n        {\n            get { return "Oracle DB"; }\n        }\n\n        public override string Description\n        {\n            get { return "Oracle DB Provider"; }\n        }\n\n        public override string ConnectionString\n        {\n            get { return "Data Source=<your_oracle_db_connection_string>"; }\n        }\n\n        public override IConnection CreateConnection()\n        {\n            return new OracleConnection();\n        }\n    }\n\n    public class OracleDataProviderFactory : DataServiceProviderFactory\n    {\n        public override DataProvider CreateDataProvider()\n        {\n            return new OracleDataProvider();\n        }\n    }\n\n    public class OracleConnection : IConnection\n    {\n        public string ConnectionString { get; set; }\n\n        public void Open()\n        {\n            // Implement Oracle connection opening logic\n        }\n\n        public void Close()\n        {\n            // Implement Oracle connection closing logic\n        }\n\n        public DataTable ExecuteQuery(string query)\n        {\n            // Implement Oracle query execution logic\n        }\n    }\n}