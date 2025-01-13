using (DbDataReader reader = command.ExecuteReader())\n{\n    if (reader.HasRows)\n    {\n        reader.Read(); // Move to the first row\n        if (!reader.IsDBNull(0))\n        {\n            byte[] buffer = new byte[8000];\n            while (reader.GetBytes(0, 0, buffer, 0, 8000) > 0)\n                picture.AddRange(buffer);\n        }\n    }\n}