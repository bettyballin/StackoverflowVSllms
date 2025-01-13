using System;\nusing System.Collections.Generic;\nusing System.Data;\nusing System.Data.SqlClient;\nusing System.Xml;\n\nclass Program\n{\n    static void Main()\n    {\n        string xmlFilePath = "path_to_your_2_5_gb_xml_file.xml";\n        string connectionString = "your_sql_server_connection_string";\n\n        using (var reader = XmlReader.Create(xmlFilePath))\n        {\n            var dataTable = new DataTable();\n            dataTable.Columns.Add("Item", typeof(string));\n            dataTable.Columns.Add("Link", typeof(string));\n\n            var rowsToAdd = new List<DataRow>();\n\n            while (reader.Read())\n            {\n                if (!reader.IsStartElement()) continue;\n\n                switch (reader.Name)\n                {\n                    case "Item":\n                        string itemValue = reader["id"];\n                        reader.Read(); // Move to the next node, which should be <Link>\n                        while (reader.NodeType == XmlNodeType.Element && reader.Name == "Link")\n                        {\n                            var newRow = dataTable.NewRow();\n                            newRow["Item"] = itemValue;\n                            newRow["Link"] = reader.ReadInnerXml().Trim();\n                            rowsToAdd.Add(newRow);\n\n                            // If the batch size is large enough, insert to SQL\n                            if (rowsToAdd.Count >= 1000) // Batch size can be adjusted\n                            {\n                                InsertBatch(connectionString, dataTable, rowsToAdd);\n                                rowsToAdd.Clear(); // Clear list for next batch\n                            }\n                        }\n                        break;\n                }\n            }\n\n            // Insert the remaining rows if any\n            if (rowsToAdd.Any())\n            {\n                InsertBatch(connectionString, dataTable, rowsToAdd);\n            }\n        }\n    }\n\n    static void InsertBatch(string connectionString, DataTable dataTable, List<DataRow> rows)\n    {\n        using (var bulkCopy = new SqlBulkCopy(connectionString))\n        {\n            bulkCopy.DestinationTableName = "YourDestinationTable"; // Specify your table name\n            foreach (DataColumn column in dataTable.Columns)\n            {\n                bulkCopy.ColumnMappings.Add(column.ColumnName, column.ColumnName);\n            }\n\n            using (DataTable batchTable = dataTable.Clone())\n            {\n                foreach (DataRow row in rows)\n                {\n                    batchTable.ImportRow(row);\n                }\n                bulkCopy.WriteToServer(batchTable);\n            }\n        }\n    }\n}