using System;\nusing System.Data.SqlClient;\n\nclass Program\n{\n    static void Main()\n    {\n        string query = "SELECT * FROM Table WHERE Foo=@Foo AND Bar=@Bar";\n        \n        using (SqlCommand command = new SqlCommand(query))\n        {\n            // Adding parameters by name and setting values by index\n            command.Parameters.Add("@Foo");\n            command.Parameters[0].Value = "someValue";\n            command.Parameters.Add("@Bar");\n            command.Parameters[1].Value = "anotherValue";\n\n            // Alternatively, adding and setting values by name\n            //command.Parameters.AddWithValue("@Foo", "someValue");\n            //command.Parameters.AddWithValue("@Bar", "anotherValue");\n\n            // Setting values directly using parameter names for clarity\n            command.Parameters["@Foo"].Value = "directAccess";\n            command.Parameters["@Bar"].Value = "directAccess";\n        }\n    }\n}