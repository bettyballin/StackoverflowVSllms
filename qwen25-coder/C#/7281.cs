using System;\nusing System.Data;\n\nclass Program\n{\n    static void Main()\n    {\n        // Create a new DataSet and DataTables\n        DataSet ds = new DataSet();\n\n        // Define parent and child tables\n        DataTable parentTable = new DataTable("Node");\n        parentTable.Columns.Add(new DataColumn("id", typeof(int)));\n\n        DataTable childTable = new DataTable("SubNode");\n        childTable.Columns.Add(new DataColumn("ParentId", typeof(int)));\n        childTable.Columns.Add(new DataColumn("id", typeof(int)));\n\n        // Add tables to the DataSet\n        ds.Tables.Add(parentTable);\n        ds.Tables.Add(childTable);\n\n        // Create relationships between parent and child table\n        DataRelation relation = new DataRelation("NodeSubNodeRelation",\n                                                  parentTable.Columns["id"],\n                                                  childTable.Columns["ParentId"]);\n        ds.Relations.Add(relation);\n\n        // Insert data into tables (example)\n        DataRow parentRow = parentTable.NewRow();\n        parentRow["id"] = 0;\n        parentTable.Rows.Add(parentRow);\n\n        DataRow childRow = childTable.NewRow();\n        childRow["ParentId"] = 0; // Pointing to the parent\n        childRow["id"] = 1;\n        childTable.Rows.Add(childRow);\n\n        // Write XML with indentation for readability\n        ds.WriteXml("output.xml", XmlWriteMode.WriteSchema, true);\n    }\n}