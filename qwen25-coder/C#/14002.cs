<#@ template debug="true" hostspecific="true"#>\n<#@ output extension=".cs"#>\n<#@ assembly name="System.Data"#>\n<#@ import namespace="System.Data.SqlClient"#>\n<#@ import namespace="System.Data"#>\n\n// Auto-generated class.\nusing System;\nusing System.Data;\nusing System.Data.SqlClient;\n\npublic static class DatabaseWrapper\n{\n<#\n    string connectionString = "your_connection_string_here";\n    using (SqlConnection conn = new SqlConnection(connectionString))\n    {\n        conn.Open();\n        SqlCommand cmd = new SqlCommand("SELECT * FROM INFORMATION_SCHEMA.ROUTINES WHERE ROUTINE_TYPE='PROCEDURE'", conn);\n        SqlDataReader reader = cmd.ExecuteReader();\n\n        var procsByName = new Dictionary<string, Routine>();\n        \n        while (reader.Read())\n        {\n            var routineName = reader["ROUTINE_NAME"].ToString();\n            \n            // For simplicity, assuming we want to use the same connection string for all.\n            var procParamsQuery = "SELECT * FROM INFORMATION_SCHEMA.PARAMETERS WHERE SPECIFIC_NAME='@0'";\n            using (var paramCmd = new SqlCommand(String.Format(procParamsQuery, routineName), conn))\n            {\n                var paramNameAccumulator = new List<string>();\n\n                // Execute the query to get parameters for this stored procedure\n                SqlDataReader paramsReader = paramCmd.ExecuteReader();\n                while (paramsReader.Read())\n                {\n                    var parameterDirection = (String) paramsReader["PARAMETER_MODE"];\n                    var isInputOrInOut = parameterDirection == "IN" || parameterDirection == "INOUT";\n                    \n                    paramString.Append($"    public {(isInputOrInOut ? "" : "out ")}object {paramsReader["PARAMETER_NAME"].ToString()},\n");\n                }\n                paramNameAccumulator.Add(paramsReader["PARAMETER_NAME"].ToString());\n            }\n\n            string paramListForMethodCall = String.Join(", ", paramNameConverter(paramNameAccumulator));\n            \n            #>\n    public static DataTable Execute<#= routineName #>(this SqlConnection connection, <#\n                var paramString = new StringBuilder();\n            if (paramString.Length > 0)\n            {\n                // trim the last comma and add the method signature\n                Write(paramString.ToString().TrimEnd(',', ' ') + $")\n    {{");\n            }\n            else\n            {\n                Write(")\n    {"); \n            }\n            #>\n        using (var command = new SqlCommand("<#= routineName #>", connection))\n        {\n            command.CommandType = CommandType.StoredProcedure;\n\n<#\n            foreach(var paramName in paramNameAccumulator)\n            {\n#>            \n            command.Parameters.AddWithValue("@<#= paramName #>", <#= paramName #>);\n<#\n            } \n#>\n\n            var adapter = new SqlDataAdapter(command);\n            DataTable dataTable = new DataTable();\n           \n            try\n            {\n                connection.Open();\n                adapter.Fill(dataTable);\n            }\n            catch (Exception ex)\n            {\n                // handle your exception.\n                throw;\n            }\n            \n            return dataTable;\n        }\n    }\n<#\n        }\n    }\n#>\n\n    static string[] paramNameConverter(List<string> paramNames)\n    {\n       return paramNames.Select(name => $"object {name}").ToArray();\n    }\n}\n\n// Routine class is a simple structure to maintain information about stored procedures\npublic struct Routine { public string Name; public List<ParameterInfo> Parameters; }\n\n// ParameterInfo class maintains information about parameters of stored procedures\npublic struct ParameterInfo\n{\n    public readonly ParameterDirection Direction;\n    public readonly bool IsNullable;\n    public readonly string DataType;\n    public readonly int MaxLength;\n\n    public ParameterInfo(ParameterDirection direction, bool isNullable, string dataType, int maxLength = 0)\n    {\n        Direction = direction;\n        IsNullable = isNullable;\n        DataType = dataType;\n        MaxLength = maxLength;\n    }\n}