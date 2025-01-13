using System;\nusing System.Collections.Generic;\nusing System.Data;\nusing System.Reflection;\n\npublic class ListToDataSetConverter\n{\n    public static DataSet ToDataSet<T>(List<T> list)\n    {\n        DataSet ds = new DataSet();\n        DataTable dt = new DataTable(typeof(T).Name);\n\n        // Get all the properties of the object\n        PropertyInfo[] properties = typeof(T).GetProperties();\n\n        // Create the DataTable columns\n        foreach (PropertyInfo property in properties)\n        {\n            dt.Columns.Add(property.Name, property.PropertyType);\n        }\n\n        // Populate the DataTable rows\n        foreach (T item in list)\n        {\n            DataRow row = dt.NewRow();\n            foreach (PropertyInfo property in properties)\n            {\n                row[property.Name] = property.GetValue(item, null);\n            }\n            dt.Rows.Add(row);\n        }\n\n        // Add the DataTable to the DataSet\n        ds.Tables.Add(dt);\n\n        return ds;\n    }\n}