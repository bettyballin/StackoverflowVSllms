using (SqlCommand command = new SqlCommand("SELECT * FROM table", connection))\n{\n    using (SqlDataReader data = command.ExecuteReader())\n    {\n        while (data.Read())\n        {\n            DateTime birthday = data.GetDateTime(data.GetOrdinal("Birth"));\n            list.Add(birthday);\n        }\n    }\n}