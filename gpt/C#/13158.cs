using System;\nusing System.Data;\n\npublic class DataTableExample\n{\n    public static void Main()\n    {\n        DataTable table = new DataTable();\n\n        // Adding columns with specific data types\n        DataColumn uniqueIdentifierColumn = new DataColumn("UniqueIdentifierColumn", typeof(Guid));\n        DataColumn nvarcharColumn = new DataColumn("NvarcharColumn", typeof(string));\n        DataColumn datetimeColumn = new DataColumn("DatetimeColumn", typeof(DateTime));\n        DataColumn varbinaryColumn = new DataColumn("VarbinaryColumn", typeof(byte[]));\n\n        // Adding columns to the DataTable\n        table.Columns.Add(uniqueIdentifierColumn);\n        table.Columns.Add(nvarcharColumn);\n        table.Columns.Add(datetimeColumn);\n        table.Columns.Add(varbinaryColumn);\n\n        // Adding a sample row\n        DataRow row = table.NewRow();\n        row["UniqueIdentifierColumn"] = Guid.NewGuid();\n        row["NvarcharColumn"] = "Sample String";\n        row["DatetimeColumn"] = DateTime.Now;\n        row["VarbinaryColumn"] = new byte[] { 0x01, 0x02, 0x03 };\n\n        table.Rows.Add(row);\n\n        // Displaying the data\n        foreach (DataRow dataRow in table.Rows)\n        {\n            Console.WriteLine($"UniqueIdentifierColumn: {dataRow["UniqueIdentifierColumn"]}");\n            Console.WriteLine($"NvarcharColumn: {dataRow["NvarcharColumn"]}");\n            Console.WriteLine($"DatetimeColumn: {dataRow["DatetimeColumn"]}");\n            Console.WriteLine($"VarbinaryColumn: {BitConverter.ToString((byte[])dataRow["VarbinaryColumn"])}");\n        }\n    }\n}