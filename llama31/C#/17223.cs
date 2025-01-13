using System;\nusing System.Runtime.InteropServices;\nusing System.Text;\n\nnamespace WindowsSearchApiExample\n{\n    [ComImport]\n    [Guid("8A67185A-2F1F-42B4-8FA9-418AC9AC4F78")]\n    [InterfaceType(ComInterfaceType.InterfaceIsIUnknown)]\n    public interface ISearchQueryHelper\n    {\n        void GenerateSQLFromUserQuery(\n            [MarshalAs(UnmanagedType.LPWStr)] string query,\n            out string sqlQuery);\n    }\n\n    public class SearchQueryExample\n    {\n        public static void Main(string[] args)\n        {\n            // Create an instance of the search query helper\n            ISearchQueryHelper queryHelper = (ISearchQueryHelper)Activator.CreateInstance(\n                Type.GetTypeFromCLSID(new Guid("8A67185A-2F1F-42B4-8FA9-418AC9AC4F78")));\n\n            // Define the search query\n            string query = "SELECT TOP 10 * FROM SystemIndex WHERE SCOPE='file:C:/path/to/directory' AND CONTAINS('searchTerm')";\n\n            // Generate the SQL query\n            string sqlQuery;\n            queryHelper.GenerateSQLFromUserQuery(query, out sqlQuery);\n\n            // Execute the SQL query using ADO.NET\n            using (var connection = new System.Data.OleDb.OleDbConnection("Provider=Search.CollatorDSO.1;EXTENDED PROPERTIES='Application=Windows Search'"))\n            {\n                connection.Open();\n                using (var command = new System.Data.OleDb.OleDbCommand(sqlQuery, connection))\n                {\n                    using (var reader = command.ExecuteReader())\n                    {\n                        while (reader.Read())\n                        {\n                            Console.WriteLine(reader["URL"]);\n                        }\n                    }\n                }\n            }\n        }\n    }\n}