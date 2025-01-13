using System;\nusing System.Data;\nusing System.IO;\nusing System.Web;\n\npublic void WriteCsvStream(DataTable dataTable, HttpResponse response)\n{\n    response.ContentType = "text/csv";\n    response.AddHeader("Content-Disposition", "attachment;filename=data.csv");\n\n    using (var writer = new StreamWriter(response.OutputStream))\n    {\n        // Write the column headers\n        for (int i = 0; i < dataTable.Columns.Count; i++)\n        {\n            string columnName = dataTable.Columns[i].ColumnName;\n            if (i > 0)\n                writer.Write(",");\n\n            WriteCsvField(writer, columnName);\n        }\n        writer.WriteLine();\n\n        // Write each row of data\n        foreach (DataRow row in dataTable.Rows)\n        {\n            for (int i = 0; i < dataTable.Columns.Count; i++)\n            {\n                if (i > 0)\n                    writer.Write(",");\n\n                string value = Convert.ToString(row[i]);\n                WriteCsvField(writer, value);\n            }\n            writer.WriteLine();\n        }\n    }\n}\n\nprivate void WriteCsvField(StreamWriter writer, string field)\n{\n    // If there are commas or special characters in the field, enclose it in double quotes\n    if (field.IndexOfAny(new char[] { ',', '\"', '\r', '\n' }) >= 0)\n    {\n        // Escape any existing double quotes by doubling them to comply with CSV standards\n        field = field.Replace("\"", "\"\"");\n        writer.Write($"\"{field}\"");\n    }\n    else\n    {\n        writer.Write(field);\n    }\n}