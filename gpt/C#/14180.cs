using System;\nusing System.Collections.Generic;\nusing System.Data;\nusing System.Reflection;\n\npublic static class ListToDataTableConverter\n{\n    public static DataTable ToDataTable<T>(this List<T> items)\n    {\n        DataTable dataTable = new DataTable(typeof(T).Name);\n\n        // Get all the properties\n        PropertyInfo[] props = typeof(T).GetProperties(BindingFlags.Public | BindingFlags.Instance);\n\n        // Create the columns for the DataTable\n        foreach (PropertyInfo prop in props)\n        {\n            dataTable.Columns.Add(prop.Name, Nullable.GetUnderlyingType(prop.PropertyType) ?? prop.PropertyType);\n        }\n\n        // Populate the DataTable\n        foreach (T item in items)\n        {\n            var values = new object[props.Length];\n            for (int i = 0; i < props.Length; i++)\n            {\n                values[i] = props[i].GetValue(item, null);\n            }\n            dataTable.Rows.Add(values);\n        }\n\n        return dataTable;\n    }\n}\n\n// Usage example:\npublic class Whatever\n{\n    public int Id { get; set; }\n    public string Name { get; set; }\n}\n\npublic class Program\n{\n    public static void Main()\n    {\n        List<Whatever> whateverList = new List<Whatever>\n        {\n            new Whatever { Id = 1, Name = "Item1" },\n            new Whatever { Id = 2, Name = "Item2" }\n        };\n\n        DataTable dt = whateverList.ToDataTable();\n\n        // Display DataTable content\n        foreach (DataRow row in dt.Rows)\n        {\n            foreach (DataColumn col in dt.Columns)\n            {\n                Console.Write(row[col] + "\t");\n            }\n            Console.WriteLine();\n        }\n    }\n}