using System;\n   using System.Data;\n   using System.Data.SqlClient;\n\n   class Program\n   {\n       static void Main()\n       {\n           string connectionString = "your_connection_string_here";\n           using (SqlConnection conn = new SqlConnection(connectionString))\n           {\n              (conn.Open();\n\n               using (var sCommand = new SqlCommand("GetTagsByNames", conn) { CommandType = CommandType.StoredProcedure })\n               {\n                   var param = sCommand.Parameters.AddWithValue("@TagNames", CreateDataTable(new[] {"ruby", "rails", "scruffy", "rubyonrails"}));\n                   param.SqlDbType = SqlDbType.Structured;\n\n                   using (var reader = sCommand.ExecuteReader())\n                   {\n                       while (reader.Read())\n                       {\n                           Console.WriteLine(reader["Name"]);\n                       }\n                   }\n               }\n           }\n       }\n\n       private static DataTable CreateDataTable(IEnumerable<string> tagNames)\n       {\n           var dataTable = new DataTable();\n           dataTable.Columns.Add("TagName");\n\n           foreach (var tagName in tagNames)\n           {\n               dataTable.Rows.Add(tagName);\n           }\n\n           return dataTable;\n       }\n   }