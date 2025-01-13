using System;\nusing System.Linq;\n\npublic void DeleteMessages(string idsString)\n{\n    if (idsString != null)\n    {\n        // Convert the comma-separated string to an array of strings.\n        string[] idStrings = idsString.Split(',');\n\n        // Filter out potential empty strings and convert to long.\n        var ids = idStrings.Where(s => !string.IsNullOrEmpty(s)).Select(long.Parse).ToList();\n\n        if (ids.Any())\n        {\n            // Create a parameterized query with placeholders for each ID.\n            string placeholders = string.Join(",", Enumerable.Repeat("?", ids.Count));\n            string sql = "DELETE FROM messages WHERE msgId IN (" + placeholders + ")";\n\n            using (var conn = new SQLiteConnection("path/to/your/database.db"))\n            {\n                conn.Open();\n                using (var cmd = new SQLiteCommand(sql, conn))\n                {\n                    // Add each ID as a parameter to the command.\n                    for (int i = 0; i < ids.Count; i++)\n                    {\n                        cmd.Parameters.AddWithValue($"@p{i}", ids[i]);\n                    }\n\n                    cmd.ExecuteNonQuery();\n                }\n            }\n        }\n    }\n}