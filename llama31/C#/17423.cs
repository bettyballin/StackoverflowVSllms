using (SqlConnection conn = new SqlConnection(connectionString))\n{\n    conn.Open();\n    SqlCommand cmd = new SqlCommand("SELECT * FROM table", conn);\n    using (SqlDataReader reader = cmd.ExecuteReader())\n    {\n        List<MyData> dataList = new List<MyData>();\n        while (reader.Read())\n        {\n            MyData data = new MyData\n            {\n                Id = reader["Id"].ToString(),\n                Name = reader["Name"].ToString()\n            };\n            dataList.Add(data);\n        }\n        return dataList;\n    }\n}