DataTable dataTable = new DataTable();\n\n// Assume 'data' is the result from the web service\nforeach (var item in data)\n{\n    DataRow row = dataTable.NewRow();\n    row["Column1"] = item.Property1;\n    row["Column2"] = item.Property2;\n    dataTable.Rows.Add(row);\n}