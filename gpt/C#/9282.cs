using System.Configuration;\n   using System.Data.SqlClient;\n   using Dapper;\n\n   public class MyRepository\n   {\n       private readonly string _connectionString;\n       private readonly string _tablePrefix;\n\n       public MyRepository()\n       {\n           _connectionString = ConfigurationManager.ConnectionStrings["DefaultConnection"].ConnectionString;\n           _tablePrefix = ConfigurationManager.AppSettings["TablePrefix"] ?? "DefaultPrefix_";\n       }\n\n       public IEnumerable<MyEntity> GetEntities()\n       {\n           using (var connection = new SqlConnection(_connectionString))\n           {\n               string query = $"SELECT * FROM {_tablePrefix}MyEntities";\n               return connection.Query<MyEntity>(query);\n           }\n       }\n   }\n\n   public class MyEntity\n   {\n       public int Id { get; set; }\n       public string Name { get; set; }\n   }