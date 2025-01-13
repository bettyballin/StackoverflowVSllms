public static SqlCommand getCommand(string procedure, SqlParameter[] parameters)\n{\n    using (SqlCommand cmd = new SqlCommand(procedure))\n    {\n        cmd.CommandType = CommandType.StoredProcedure;\n        if (parameters != null)\n        {\n            cmd.Parameters.AddRange(parameters);\n        }\n        return cmd;\n    }\n}\n\n// Usage:\nSqlParameterCollection prmCollection = new SqlCommand().Parameters;\nprmCollection.Add(p1);\nprmCollection.Add(p2);\nprmCollection.Add(p3);\nprmCollection.Add(p4);\nprmCollection.Add(p5);\n\n// Convert SqlParameterCollection to an array\nSqlParameter[] parametersArray = new SqlParameter[prmCollection.Count];\nprmCollection.CopyTo(parametersArray, 0);\n\nSqlCommand cmd = getCommand("YourProcedureName", parametersArray);