using System;\nusing System.Collections.Generic;\nusing System.Data.SqlClient;\n\nclass Program\n{\n    static void Main()\n    {\n        string connectionString = "your_connection_string_here";\n        string query = "SELECT ID, Category, Weight FROM YourTable";\n\n        Dictionary<int, LookupItem> lookupTable = new Dictionary<int, LookupItem>();\n\n        using (SqlConnection connection = new SqlConnection(connectionString))\n        {\n            SqlCommand command = new SqlCommand(query, connection);\n            connection.Open();\n            SqlDataReader reader = command.ExecuteReader();\n\n            while (reader.Read())\n            {\n                int id = reader.GetInt32(0);\n                string category = reader.GetString(1);\n                int weight = reader.GetInt32(2);\n\n                LookupItem item = new LookupItem\n                {\n                    ID = id,\n                    Category = category,\n                    Weight = weight\n                };\n\n                lookupTable[id] = item;\n            }\n            reader.Close();\n        }\n\n        // Example usage\n        if (lookupTable.TryGetValue(1, out LookupItem lookupItem))\n        {\n            Console.WriteLine($"ID: {lookupItem.ID}, Category: {lookupItem.Category}, Weight: {lookupItem.Weight}");\n        }\n    }\n}