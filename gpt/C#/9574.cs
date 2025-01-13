ResponseSheet Tests = new ResponseSheet();\nDataSet ReturData = new DataSet();\nOracleDataAdapter da;\n\ntry\n{\n    using (OracleConnection conn = new OracleConnection(ConnString))\n    {\n        conn.Open();\n\n        using (OracleCommand cmd = new OracleCommand())\n        {\n            cmd.Connection = conn;\n            cmd.CommandText = @"SELECT gsh.locid, locations.description, GSH.workorder, GSH.comstatus, GSH.teststatus, \n                                GSH.fireresult, GSH.lightresult, GSH.watercold, GSH.waterhot, GSH.responsedate, \n                                GSH.comments, GSH.testername \n                                FROM gsh_vhs_locations locs\n                                LEFT OUTER JOIN locations ON locs.maximoloc = locations.location\n                                LEFT OUTER JOIN gsh_vhs_comms GSH ON locs.LOCID = GSH.locid \n                                WHERE gsh.insertdate > sysdate-7\n                                ORDER BY locid, locations.description, GSH.workorder, GSH.comstatus, GSH.teststatus, \n                                GSH.fireresult, GSH.lightresult, GSH.watercold, GSH.waterhot, GSH.responsedate, \n                                GSH.comments, GSH.testername";\n\n            da = new OracleDataAdapter(cmd);\n            da.MissingMappingAction = MissingMappingAction.Error;\n            da.MissingSchemaAction = MissingSchemaAction.AddWithKey; // Ensure schema is added\n\n            // Add TableMapping\n            da.TableMappings.Add("Table", "ResponseSheet");\n\n            da.Fill(ReturData, "ResponseSheet");\n\n            // Check if data is filled\n            if (ReturData.Tables["ResponseSheet"] != null && ReturData.Tables["ResponseSheet"].Rows.Count > 0)\n            {\n                Console.WriteLine("Data fetched successfully.");\n            }\n            else\n            {\n                Console.WriteLine("No data returned from query.");\n            }\n        }\n    }\n}\ncatch (Exception ex)\n{\n    Console.WriteLine(TimeStamp() + ex.Message.ToString() + " Get Capture Report (TraceCode: 00019)");\n}\n\nreturn ReturData;