using System;\nusing System.Data;\nusing System.Data.SqlClient;\nusing Oracle.ManagedDataAccess.Client;\n\nclass Program\n{\n    static void Main()\n    {\n        string oracleConnString = "User Id=your_user;Password=your_password;Data Source=your_oracle_source";\n        string sqlServerConnString = "Server=your_sql_server;Database=your_db;User Id=your_user;Password=your_password";\n\n        using (OracleConnection oracleConn = new OracleConnection(oracleConnString))\n        {\n            oracleConn.Open();\n            using (OracleCommand cmd = new OracleCommand("GetEmployees", oracleConn))\n            {\n                cmd.CommandType = CommandType.StoredProcedure;\n                OracleParameter refCursorParam = new OracleParameter("emp_cursor", OracleDbType.RefCursor);\n                refCursorParam.Direction = ParameterDirection.Output;\n                cmd.Parameters.Add(refCursorParam);\n\n                using (OracleDataReader reader = cmd.ExecuteReader())\n                {\n                    using (SqlConnection sqlConn = new SqlConnection(sqlServerConnString))\n                    {\n                        sqlConn.Open();\n                        using (SqlBulkCopy bulkCopy = new SqlBulkCopy(sqlConn))\n                        {\n                            DataTable dataTable = new DataTable();\n                            dataTable.Load(reader);\n\n                            bulkCopy.DestinationTableName = "dbo.TempEmployees";\n                            bulkCopy.WriteToServer(dataTable);\n                        }\n                    }\n                }\n            }\n        }\n    }\n}