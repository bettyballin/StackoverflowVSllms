using System.Web.Http;\nusing System.Data.SqlClient;\n\nnamespace MyApi.Controllers\n{\n    public class MyController : ApiController\n    {\n        private readonly string _connectionString = "your_connection_string";\n\n        [HttpGet]\n        public IHttpActionResult GetData()\n        {\n            using (var connection = new SqlConnection(_connectionString))\n            {\n                connection.Open();\n                var command = new SqlCommand("SELECT * FROM your_table", connection);\n                var reader = command.ExecuteReader();\n                var data = new List<object>();\n\n                while (reader.Read())\n                {\n                    data.Add(new\n                    {\n                        // map your columns here\n                        Id = reader["id"],\n                        Name = reader["name"]\n                    });\n                }\n\n                return Ok(data);\n            }\n        }\n    }\n}