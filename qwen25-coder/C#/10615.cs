public SqlCommand CreateStoredProcedureCommand(string procName, params SqlParameter[] parameters)\n{\n    var cmd = new SqlCommand(procName, connection) { CommandType = CommandType.StoredProcedure };\n    foreach (var param in parameters)\n    {\n        cmd.Parameters.Add(param);\n    }\n    return cmd;\n}\n\n// Usage:\nvar cmd = CreateStoredProcedureCommand("StoredProc", \n                                      new SqlParameter("@p1", 1), \n                                      new SqlParameter("@p2", 2));