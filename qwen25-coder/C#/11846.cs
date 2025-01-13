// Assuming ds is your DataSet after calling ReadXml\nif (ds.Tables.Contains("item"))\n{\n    DataTable itemTable = ds.Tables["item"];\n    foreach (DataRow row in itemTable.Rows)\n    {\n        // Accessing the attribute 'attr'\n        string attrValue = row["attr"]?.ToString();\n\n        // Accessing child element 'description'\n        string descriptionValue = row["description"]?.ToString();\n        \n        Console.WriteLine($"Attribute: {attrValue}, Description: {descriptionValue}");\n    }\n}