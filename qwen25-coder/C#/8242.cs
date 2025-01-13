using System;\nusing System.Data;\nusing System.IO;\n\npublic class CsvToDataTableExample\n{\n    public static DataTable ReadCsvFileIntoDataTable(string filePath)\n    {\n        DataTable dataTable = new DataTable();\n\n        using (StreamReader sr = new StreamReader(filePath))\n        {\n            string[] headers = sr.ReadLine().Split(',');\n            foreach (string header in headers)\n            {\n                dataTable.Columns.Add(header);\n            }\n\n            while (!sr.EndOfStream)\n            {\n                string[] rows = sr.ReadLine().Split(',');\n                DataRow dr = dataTable.NewRow();\n                for (int i = 0; i < headers.Length; i++)\n                {\n                    dr[i] = rows[i];\n                }\n                dataTable.Rows.Add(dr);\n            }\n        }\n\n        return dataTable;\n    }\n\n    static void Main(string[] args)\n    {\n        string csvFilePath = "yourfile.csv";\n        DataTable dataTable = ReadCsvFileIntoDataTable(csvFilePath);\n\n        // Example of accessing data\n        foreach (DataRow row in dataTable.Rows)\n        {\n            Console.WriteLine(string.Join(", ", row.ItemArray));\n        }\n    }\n}