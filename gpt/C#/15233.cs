public class Program\n{\n    static void Main(string[] args)\n    {\n        string csvFilePath = "path_to_your_csv_file.csv";\n        string tableName = "YourTableName";\n\n        CsvToSql csvToSql = new CsvToSql();\n        DataTable dataTable = csvToSql.ReadCsvFile(csvFilePath);\n\n        SqlGenerator sqlGenerator = new SqlGenerator();\n        string createTableSql = sqlGenerator.GenerateCreateTableStatement(dataTable, tableName);\n        string insertStatementsSql = sqlGenerator.GenerateInsertStatements(dataTable, tableName);\n\n        Console.WriteLine(createTableSql);\n        Console.WriteLine(insertStatementsSql);\n    }\n}