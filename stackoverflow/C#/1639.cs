using System;\npublic class test\n{\n    public static void Main()\n    {\n        using ( CsvReader reader = new CsvReader( "data.csv" ) )\n        {\n            foreach( string[] values in reader.RowEnumerator )\n            {\n                Console.WriteLine( "Row {0} has {1} values.", reader.RowIndex, values.Length );\n            }\n        }\n        Console.ReadLine();\n    }\n}