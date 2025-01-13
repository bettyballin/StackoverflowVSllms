using System;\nusing System.Net.Http;\nusing System.Data.SqlClient;\n\nclass Program\n{\n    static void Main(string[] args)\n    {\n        // Connect to the internet\n        using (var httpClient = new HttpClient())\n        {\n            var response = httpClient.GetAsync("https://example.com").Result;\n            Console.WriteLine(response.StatusCode);\n        }\n\n        // Work with a database\n        using (var connection = new SqlConnection("Data Source=your_database;Initial Catalog=your_database;Integrated Security=True"))\n        {\n            connection.Open();\n            using (var command = new SqlCommand("SELECT * FROM your_table", connection))\n            {\n                using (var reader = command.ExecuteReader())\n                {\n                    while (reader.Read())\n                    {\n                        Console.WriteLine(reader[0].ToString());\n                    }\n                }\n            }\n        }\n    }\n}