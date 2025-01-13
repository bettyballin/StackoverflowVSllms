using (DbDataReader reader = command.ExecuteReader())\n{\n    if (reader.Read())\n    {\n        if (!reader.IsDBNull(0))\n        {\n            List<byte> picture = new List<byte>();\n            byte[] buffer = new byte[8000];\n            int bytesRead;\n            long fieldOffset = 0;\n\n            while ((bytesRead = (int)reader.GetBytes(0, fieldOffset, buffer, 0, buffer.Length)) > 0)\n            {\n                picture.AddRange(buffer.Take(bytesRead));\n                fieldOffset += bytesRead;\n            }\n\n            // Now 'picture' contains the image data as byte array\n            // byte[] imageData = picture.ToArray();\n        }\n    }\n}