using System;\n   using System.Data.SqlClient;\n   using System.Runtime.Caching;\n\n   public class SqlCacheDependencyExample\n   {\n       private static readonly string connectionString = "your_connection_string";\n       private static readonly ObjectCache cache = MemoryCache.Default;\n\n       public static void Main()\n       {\n           // Start the SqlDependency\n           SqlDependency.Start(connectionString);\n\n           // Call the method to set up the dependency\n           GetDataWithDependency(1); //assuming 1 is the specific row id you are interested in\n\n           // ... your application logic ...\n       }\n\n       private static void GetDataWithDependency(int rowId)\n       {\n           string cacheKey = $"Data_{rowId}";\n\n           if (cache[cacheKey] == null)\n           {\n               string query = "SELECT YourColumns FROM YourTable WHERE Id = @Id";\n               \n               using (SqlConnection connection = new SqlConnection(connectionString))\n               using (SqlCommand command = new SqlCommand(query, connection))\n               {\n                   command.Parameters.AddWithValue("@Id", rowId);\n\n                   SqlDependency dependency = new SqlDependency(command);\n                   dependency.OnChange += new OnChangeEventHandler(OnDependencyChange);\n\n                   connection.Open();\n\n                   using (SqlDataReader reader = command.ExecuteReader())\n                   {\n                       if (reader.Read())\n                       {\n                           // Assume YourColumns is one column for simplicity\n                           string data = reader["YourColumns"].ToString();\n                           cache.Set(cacheKey, data, new CacheItemPolicy());\n                       }\n                   }\n               }\n           }\n\n           // Retrieve from cache\n           string cachedData = (string)cache[cacheKey];\n           Console.WriteLine("Cached Data: " + cachedData);\n       }\n\n       private static void OnDependencyChange(object sender, SqlNotificationEventArgs e)\n       {\n           // Handle the change event\n           if (e.Type == SqlNotificationType.Change)\n           {\n               SqlDependency dependency = (SqlDependency)sender;\n\n               // Invalidate the cache\n               string cacheKey = $"Data_{dependency.Id}";\n               cache.Remove(cacheKey);\n\n               // Optionally, re-fetch the data\n               GetDataWithDependency(Convert.ToInt32(dependency.Id));\n           }\n       }\n\n       ~SqlCacheDependencyExample()\n       {\n           // Stop the SqlDependency\n           SqlDependency.Stop(connectionString);\n       }\n   }