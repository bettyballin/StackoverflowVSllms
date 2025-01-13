using Microsoft.SqlServer.Management.Smo;\n\n// Connect to the database\nServer server = new Server("your_server_name");\nDatabase database = server.Databases["your_database_name"];\n\n// Create a new table\nTable table = new Table(database, "your_table_name");\ntable.Columns.Add(new Column(table, "First name", DataType.VarChar(100)));\ntable.Columns.Add(new Column(table, "Last name", DataType.VarChar(100)));\ntable.Create();\n\n// Check if a column exists\nif (table.Columns.Contains("Company"))\n{\n    // Remove the column\n    Column companyColumn = table.Columns["Company"];\n    companyColumn.Drop();\n}\n\n// Add an index\nIndex index = new Index(table, "your_index_name");\nindex.IndexedColumns.Add(new IndexedColumn(index, "First name"));\nindex.Create();\n\n// Add a foreign key\nForeignKey foreignKey = new ForeignKey(table, "your_foreign_key_name");\nforeignKey.Columns.Add(new ForeignKeyColumn(foreignKey, "your_column_name"));\nforeignKey.ReferencedTable = "your_referenced_table_name";\nforeignKey.ReferencedColumns.Add("your_referenced_column_name");\nforeignKey.Create();