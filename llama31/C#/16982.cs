DataSet dataSet = ...; // your DataSet instance\n\n// Get the SqlCommand associated with the GetNotYoungPeople query\nSqlCommand command = dataSet.Tables["GetNotYoungPeople"].ExtendedProperties["Command"] as SqlCommand;\n\n// Modify the CommandText property\ncommand.CommandText = "select * from people where age > 17";