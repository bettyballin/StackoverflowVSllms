List<string> values = new List<string>();\n\nwhile (dataReader.Read())\n{\n    values.Clear();\n    values.Add(dataReader["Id"].ToString());\n    values.Add(dataReader["Name"].ToString());\n    values.Add(dataReader["Address"].ToString());\n    values.Add(dataReader["City"].ToString());\n    records.Add(values.ToArray());\n}