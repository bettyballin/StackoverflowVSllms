using System.Data.SqlClient;\n\n// Assuming you have a SqlConnection object named 'conn'\nusing (SqlCommand cmd = new SqlCommand("SELECT A.column1, B.column2, C.column3 FROM A JOIN B ON A.common_column = B.common_column JOIN C ON A.common_column = C.common_column", conn))\n{\n    conn.Open();\n    using (SqlDataReader reader = cmd.ExecuteReader())\n    {\n        List<string> listA = new List<string>();\n        List<string> listB = new List<string>();\n        List<string> listC = new List<string>();\n\n        while (reader.Read())\n        {\n            listA.Add(reader["column1"].ToString());\n            listB.Add(reader["column2"].ToString());\n            listC.Add(reader["column3"].ToString());\n        }\n    }\n}