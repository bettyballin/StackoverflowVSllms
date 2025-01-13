using System.IO;\nusing System.IO.Compression;\n\n// ...\n\nbyte[] fileBytes = // generate your binary file bytes here\n\nResponse.Clear();\nResponse.Buffer = true;\nResponse.ContentType = "application/vnd.ms-excel";\nResponse.AppendHeader("Content-Disposition", "attachment; filename=file.xlsx");\n\nusing (MemoryStream ms = new MemoryStream())\n{\n    using (GZipStream gz = new GZipStream(ms, CompressionMode.Compress, true))\n    {\n        gz.Write(fileBytes, 0, fileBytes.Length);\n    }\n    byte[] compressedBytes = ms.ToArray();\n    Response.OutputStream.Write(compressedBytes, 0, compressedBytes.Length);\n}\nResponse.End();