public async Task GetUsersAsync()\n    {\n        for (int i = 0; i < total - 1; i++)\n        {\n            var objPara = new SqlParameter[]\n            {\n                new SqlParameter("@CompanyID", companies[i]),\n                // other parameters...\n            };\n\n            using (var connection = new SqlConnection(ConfigurationManager.ConnectionStrings["connstr"].ConnectionString))\n            {\n                await connection.OpenAsync();\n                using (var command = new SqlCommand("Course_NewReportGet_Get_Sav", connection)\n                {\n                    CommandType = CommandType.StoredProcedure,\n                    CommandTimeout = 60, // Adjust timeout as necessary\n                })\n                {\n                    command.Parameters.AddRange(objPara);\n                    var reader = await command.ExecuteReaderAsync();\n\n                    while (await reader.ReadAsync())\n                    {\n                        Response.Write("user: " + reader["userid"].ToString() + " / course: " + reader["bundleid"].ToString() + "<br/>");\n                    }\n                }\n            }\n        }\n    }\n\n    protected async void Proceed(object sender, EventArgs e)\n    {\n        await GetUsersAsync();\n    }