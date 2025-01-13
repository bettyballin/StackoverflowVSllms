using System;\nusing System.Data;\nusing System.Linq;\nusing System.Collections.Generic;\n\nclass TimeSeriesData\n{\n    public DateTime Timestamp { get; set; }\n    public double Value { get; set; }\n}\n\nclass Program\n{\n    static void Main()\n    {\n        // Example time-series data\n        List<TimeSeriesData> ts1 = new List<TimeSeriesData>\n        {\n            new TimeSeriesData { Timestamp = new DateTime(2023, 1, 1, 1, 0, 0), Value = 1 },\n            new TimeSeriesData { Timestamp = new DateTime(2023, 1, 1, 2, 0, 0), Value = 2 },\n            new TimeSeriesData { Timestamp = new DateTime(2023, 1, 1, 3, 0, 0), Value = 3 }\n        };\n\n        List<TimeSeriesData> ts2 = new List<TimeSeriesData>\n        {\n            new TimeSeriesData { Timestamp = new DateTime(2023, 1, 1, 2, 0, 0), Value = 4 },\n            new TimeSeriesData { Timestamp = new DateTime(2023, 1, 1, 3, 0, 0), Value = 5 },\n            new TimeSeriesData { Timestamp = new DateTime(2023, 1, 1, 4, 0, 0), Value = 6 }\n        };\n\n        List<TimeSeriesData> ts3 = new List<TimeSeriesData>\n        {\n            new TimeSeriesData { Timestamp = new DateTime(2023, 1, 1, 1, 0, 0), Value = 7 },\n            new TimeSeriesData { Timestamp = new DateTime(2023, 1, 1, 2, 0, 0), Value = 8 },\n            new TimeSeriesData { Timestamp = new DateTime(2023, 1, 1, 3, 0, 0), Value = 9 }\n        };\n\n        // Combine all timestamps\n        var allTimestamps = ts1.Select(t => t.Timestamp)\n                               .Union(ts2.Select(t => t.Timestamp))\n                               .Union(ts3.Select(t => t.Timestamp))\n                               .Distinct()\n                               .OrderBy(t => t)\n                               .ToList();\n\n        // Create DataTable\n        DataTable dataTable = new DataTable();\n        dataTable.Columns.Add("Timestamp", typeof(DateTime));\n        dataTable.Columns.Add("TS1", typeof(double));\n        dataTable.Columns.Add("TS2", typeof(double));\n        dataTable.Columns.Add("TS3", typeof(double));\n\n        // Populate DataTable\n        foreach (var timestamp in allTimestamps)\n        {\n            DataRow row = dataTable.NewRow();\n            row["Timestamp"] = timestamp;\n            row["TS1"] = ts1.FirstOrDefault(t => t.Timestamp == timestamp)?.Value ?? DBNull.Value;\n            row["TS2"] = ts2.FirstOrDefault(t => t.Timestamp == timestamp)?.Value ?? DBNull.Value;\n            row["TS3"] = ts3.FirstOrDefault(t => t.Timestamp == timestamp)?.Value ?? DBNull.Value;\n            dataTable.Rows.Add(row);\n        }\n\n        // Output DataTable to console (for demonstration purposes)\n        foreach (DataRow row in dataTable.Rows)\n        {\n            Console.WriteLine($"{row["Timestamp"]} {row["TS1"]} {row["TS2"]} {row["TS3"]}");\n        }\n    }\n}