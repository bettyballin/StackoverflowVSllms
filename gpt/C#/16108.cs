using (OracleConnection connection = new OracleConnection("your_connection_string"))\n    {\n        connection.Open();\n        using (OracleCommand command = connection.CreateCommand())\n        {\n            command.CommandText = "INSERT INTO my_table (id, column1) VALUES (my_sequence.NEXTVAL, :column1) RETURNING id INTO :id";\n            \n            command.Parameters.Add(new OracleParameter("column1", "value1"));\n            OracleParameter returnParameter = new OracleParameter("id", OracleDbType.Int32);\n            returnParameter.Direction = ParameterDirection.Output;\n            command.Parameters.Add(returnParameter);\n\n            command.ExecuteNonQuery();\n\n            int newId = Convert.ToInt32(returnParameter.Value);\n            Console.WriteLine("Inserted record ID: " + newId);\n        }\n    }