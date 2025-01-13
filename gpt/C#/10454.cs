public class Product\n   {\n       [AutoIncrement]\n       public int Id { get; set; }\n       public string Name { get; set; }\n       public decimal Price { get; set; }\n   }\n\n   var dbFactory = new OrmLiteConnectionFactory(connectionString, SqlServerDialect.Provider);\n   using (var db = dbFactory.Open())\n   {\n       db.CreateTableIfNotExists<Product>();\n   }